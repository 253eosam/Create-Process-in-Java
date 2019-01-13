# Create-Process-in-Java
Creating an external process using ProcessBuilder class

* (parent) 프로세스는 새로운 (child) 프로세스를 생성 가능
  - system call을 호출하여 생성함 ex) UNIX fork() 시스템호출

* Unix에서의 프로세스 생성 
  - fork() 시스템 호출 : 자신을 복제하여 자식 프로세스를 생성함
  - exce(new_program) : 새로운 프로그램을 적재하여 실행함
  - wait() : parent는 child가 종료될 때까지 대기함
  
* Java에서의 프로세스 생성
  - An instance of JVM
  - 다중 스레드는 지원하지만 process 생성은 지원하지 않는다.
    => 하나의 JVM(=하나의 프로세스 =하나의 주소 공간)에서 process memory(주소 공간)들을 분리하기 어렵기 때문
  - Possible to create a process external to the JVM by using ProcessBuilder class
  ※ ProcessBuilder allows a Java program to specify a OS-native process
    (such as /usr/bin/ls or C:\\windows\\system32\\mspaint.exe)
   
* We'll play to open the win32 program, which is "Hello world.exe"
