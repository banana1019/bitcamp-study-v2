// # 클래스 변수
//
package com.eomcs.oop.ex03;

public class Exam0130 {

  // 지금 당장 A 클래스 앞에 붙은 static은 고민하지 말라!
  // 이 예제의 목표는 스태틱 변수이다.
  static class A {

    // 클래스 변수 = 스태틱 변수
    // - static 이 붙은 변수이기 때문에 "스태틱 변수"라고도 부른다.
    // - 클래스를 로딩하는 순간 자동 생성된다.
    // - 클래스와 함께 "Method Area" 영역에 존재한다.
    // - 클래스 이름으로 접근
    //   클래스 이름으로 접근한다고 해서 "클래스에 소속된 변수", "클래스 변수"라 부른다.
    // - 문법
    //     static 데이터타입 변수명;
    //
    static int v1;
    static boolean v2;
  }

  public static void main(String[] args) {

    // 클래스 변수 사용법
    // 클래스명.스태틱변수명 = 값;
    // 클래스를 사용하는 순간 클래스가 로딩되고, 스태틱 변수는 자동 생성된다.
    A.v1 = 100;
    A.v2 = true;

    System.out.printf("%d, %b\n", A.v1, A.v2);
  }
}

// JVM을 실행하는 동안 한 번 클래스가 로딩되면 같은 클래스에 대해 중복 로딩되지 않는다.
// 클래스 변수는 클래스가 로딩될 때 자동 생성되기 때문에 
// 클래스에 대해 딱 한 번 생성된다.
// 따라서 인스턴스 변수처럼 같은 클래스에 대해 여러 개의 개별 데이터를 저장할 수 없다.
// 왜? 변수가 한 개이다.
//

// ## 클래스 로딩
// - 외부 저장장치(예: HDD, USB 메모리, DVD-ROM 등)에 있는 .class 파일을
//   JVM이 관리하는 메모리로 로딩하는 것.
// - 클래스의 코드를 사용하는 시점에 메모리(Method Area 영역)에 로딩된다.

// ## 클래스의 코드를 사용하는 시점?
// - 스태틱 멤버(필드와 메서드)를 사용할 때
//     예) A.v1 = 200; <--- 스태틱 변수 v1 사용
//     예) System.out.println(A.v1); <--- 스태틱 변수 out 사용
//     예) Integer.parseInt(..); <--- 스태틱 변수 parseInt() 사용
// - new 명령을 사용하여 인스턴스를 생성할 때
//     예) new A();
// - 한 번 클래스가 로딩되면 JVM을 종료할 때까지 유지한다.
// - 물론 강제로 클래스를 unloading 할 수 있다. 그리고 다시 로딩할 수 있다.

// ## 주의! 클래스를 로딩할 거라고 착각하는 경우
// - 다음과 같이 레퍼런스 변수를 선언할 때는 클래스를 로딩하지 않는다. 
//   로딩하지 않는다! 로딩하지 않는다! 로딩하지 않는다!
// 예) A obj;
// 예) String str;

// ## 클래스 로딩 과정
// $ java com.eomcs.oop.ex03.Exam0130
// 1) 클래스 파일 'Exam0130.class'을 찾는다.
//    - JDK에서 제공하는 기본 라이브러리에서 찾는다.
//    - JVM을 실행할 때 -classpath 또는 -cp 옵션으로 지정한 CLASSPATH 디렉토리에서 찾는다.
//    - CLASSPATH에 없으면 JVM을 실행하는 현재 폴더에서 찾는다.
//    - 그래도 없으면 오류를 띄운다.
// 2) 바이트코드 검증(Verify)
//    - 클래스의 바이트코드 유효성을 검사한다.
// 3) Exam0130.class를 "Method Area 영역"에 로딩한다.
//    - 즉 클래스를 외부 저장소(HDD)에서 내부 저장소(RAM)로 로딩한다.
//    - bytecode를 분석하여 코드(생성자, 메서드)와 상수를 따로 분리하여 보관한다.
// 4) 스태틱 필드 및 메서드 테이블 준비(Prepare)
//    - Method Area 에 스태틱 필드 생성한다.
//    - 클래스 내부에서 사용하는 이름(변수명, 메서드명, 클래스명 등) 목록을 준비한다.
// 5) 참조하는 외부 클래스나 인터페이스 검사(Resolve)
//    - 로딩된 클래스가 참조하는 외부 클래스나 인터페이스의 유효성을 검사한다.
// 6) 클래스 초기화시키기
//    - 스태틱 블록(static initializers)을 실행한다.
// 7) main() 메서드를 호출한다.
//    - 클래스를 실행하는 것이라면 main() 메서드를 찾아 실행한다.

// ## Exam0130의 main() 메서드 호출
// 1) main() 메서드에 선언된 로컬 변수를 "JVM 스택 영역"에 생성한다.
//    - args 변수를 스택 영역에 생성한다.
// 2) main()의 코드를 실행한다.
//    - A.v1 = 100;
//      => A.class 를 "Method Area"에 로딩한다.
//      => A의 클래스(스태틱) 필드를 "Method Area"에 생성한다.
//      => `A.v1 = 100` 문장을 실행한다.
//    - A.v2 = true;
//      => A 클래스가 이미 로딩되었기 때문에 다시 로딩하지 않는다.
//      => `A.v2 = true` 문장을 실행한다.
//    - System.out.println() 를 실행한다.
//

// ## JVM이 관리하는 메모리 영역
// 1) Heap
//    - new 명령으로 생성한 인스턴스 변수가 놓인다.
//    - 즉 인스턴스 필드가 이 영역에 생성된다.
//      => 메서드는 생성하지 않는다!
//    - 가비지 컬렉터는 이 메모리의 가비지들을 관리한다.
// 2) JVM Stack
//    - 각 스레드가 개인적으로 관리하는 메모리 영역이다.
//    - 스레드에서 메서드를 호출할 때 메서드의 로컬 변수를 이 영역에 만든다.
//    - 메서드가 호출될 때 그 메서드가 사용하는 로컬 변수를 프레임에 담아 만든다.
//    - 메서드 호출이 끝나면 그 메서드가 소유한 프레임이 삭제된다.
// 3) Method Area
//    - JVM이 실행하는 바이트코드(.class 파일)를 두는 메모리 영역이다.
//      => 바이트코드를 그대로 메모리에 두는 것이 아니라, 멤버의 종류에 따라 적절하게 분류한다.
//    - 즉 클래스 코드가 이 영역에 놓이는 것이다.
//    - JVM은 코드를 실행할 때 이 영역에 놓은 명령어를 실행하는 것이다.
//    - 개발자가 작성한 클래스, 메서드 등 이런 코드들이 이 영역에 놓이는 것이다.
//    - 스태틱 필드를 이 영역에 생성한다.
//    - 주의! Heap에는 개발자가 작성한 명령어가 없다.
//


