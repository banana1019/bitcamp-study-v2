// 클래스 변수의 응용
//
package com.eomcs.oop.ex03;

public class Exam0162 {

  static class Member {

    // Member와 관련된 값을 갖고 있는 변수라면
    // 다음과 같이 Member 클래스에 두는 것이 유지보수에 좋다.
    // - 여러 인스턴스에서 공통으로 사용할 값을 담는 변수라면 static 필드로 선언하라!
    // - 조회용으로 사용할 변수이면서 외부에서도 사용해야 할 변수라면 public으로 공개하라!
    // - 다음 변수는 클래스 변수(스태틱 변수)의 전형적인 예이다.
    public static final int GUEST = 0;
    public static final int MEMBER = 1;
    public static final int MANAGER = 2;
    //
    // 클래스 변수의 활용 예: 상수 변수를 선언할 때
    // - 모든 인스턴스가 같은 값을 가질 경우,
    //   클래스 변수로 만드는 것이 바람직하다.
    // - 값을 저장하는 것이 아닌 조회하는 용도로만 사용하는 변수라면
    //   대문자로 선언하여 상수임을 표현하라!
    // - 조회 용도로만 사용하기로 했으면 final로 값을 변경되는 것을 막아라!
    // - 보통 조회용으로 사용하는 변수는 공개해도 되기 때문에 public으로 선언한다!

    String id;
    String password;
    int type; // 0: 손님, 1: 회원, 2: 관리자
  }

  public static void main(String[] args) {

    // Member와 관련된 상수라면 
    // Member 클래스에 선언하는 것이 유지보수에 더 낫다.
    // final int GUEST = 0;
    // final int MEMBER = 1;
    // final int MANAGER = 2;

    Member m4 = new Member();
    m4.id = "aaa";
    m4.password = "1111";
    m4.type = Member.GUEST;
    // 스태틱 변수는 변수명 앞에 클래스명을 명시해야 한다.

    Member m5 = new Member();
    m5.id = "bbb";
    m5.password = "1111";
    m5.type = Member.MANAGER;

    Member m6 = new Member();
    m6.id = "ccc";
    m6.password = "1111";
    m6.type = Member.MEMBER;
  }
}








