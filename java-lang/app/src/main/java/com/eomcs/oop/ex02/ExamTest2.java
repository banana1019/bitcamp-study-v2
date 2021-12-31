package com.eomcs.oop.ex02;

//1) 관련 메서드를 클래스로 묶는다.
//2) 메서드에서 계산한 결과를 클래스 변수에 저장한다.
//3) 인스턴스 변수로 바꿔서 결과를 개별적으로 관리한다.
//4) 인스턴스 메서드로 바꿔서 인스턴스 주소를 this 변수에 받는다.
//5) 클래스를 별도의 소스 파일로 분리한다.
//6) 클래스를 패키지로 분류한다.

public class ExamTest2 {

  static class Calculator {

    static int result = 0;

    static void plus(int a) {
      result += a;
    }

    static void minus(int a) {
      result -= a;
    }

    static void multiple(int a) {
      result *= a;
    }

    static void divide(int a) {
      result /= a;
    }

    static int abs(int a) {
      return a >= 0 ? a : a * -1;
    }
  }

  public static void main(String[] args) {

    Calculator.plus(2);
    Calculator.plus(3);    
    Calculator.minus(1);
    Calculator.multiple(7);
    Calculator.divide(3);

    System.out.printf("result = %d\n", Calculator.result);
  }


}

