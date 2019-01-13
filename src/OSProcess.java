/*
 * Title : Java에서의 프로세스 생성
 * Date : 2019-01-13
 * Author : Donald D
 * Detail : An instance of JVM은 다중 스레드는 지원하지만 process 생성은 지원하지 않는다. 
 * 하나의 JVM(= 하나의 프로세스, = 하나의 주소 공간)에서 process memory(주소 공간)들을 분리하기 어렵기 때문이다.
 * => Possible to create a process external to the JVM by using ProcessBuilder class
 * processBuilder allows a java program to specify a OS-native process (such as Unix /usr/bin/ls or C:\\windows\\system32\\mspaint.exe)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class OSProcess {
	public static void main(String[] args) throws IOException {
		if(args.length != 1) {
			System.err.println("사용법: java OSProcess 명령");
			System.exit(0);
		}
		ProcessBuilder pb = new ProcessBuilder(args[0]);
		Process proc = pb.start();	//external process 생성 - 명령 실행
		//external process와 JVM은 서로 영향을 줄 수 없다. 따라서 external process의 InputStream, OutputStream을 통해 통신한다.
		InputStream is = proc.getInputStream();	//proc의 입력스트림
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line;
		while((line = br.readLine()) != null) {	//proc의 출력을 읽음
			System.out.println(line);
		}
		br.close();
	}
}
