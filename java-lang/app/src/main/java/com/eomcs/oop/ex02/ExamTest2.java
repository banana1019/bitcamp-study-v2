package com.eomcs.oop.ex02;

//1) 관련 메서드를 클래스로 묶는다.
//2) 메서드에서 계산한 결과를 클래스 변수에 저장한다.
//3) 인스턴스 변수로 바꿔서 결과를 개별적으로 관리한다.
//4) 인스턴스 메서드로 바꿔서 인스턴스 주소를 this 변수에 받는다.
//5) 클래스를 별도의 소스 파일로 분리한다.
//6) 클래스를 패키지로 분류한다.

public class ExamTest2 {

  static class Calculator {

    int result = 0;

    static void plus(Calculator c, int a) {
      c.result += a;
    }

    static void minus(Calculator c, int a) {
      c.result -= a;
    }

    static void multiple(Calculator c, int a) {
      c.result *= a;
    }

    static void divide(Calculator c, int a) {
      c.result /= a;
    }

    static int abs(int a) {
      return a >= 0 ? a : a * -1;
    }
  }

  public static void main(String[] args) {

    Calculator c1 = new Calculator();
    Calculator c2 = new Calculator();

    Calculator.plus(c1, 2);
    Calculator.plus(c1, 3);    
    Calculator.minus(c1, 1);
    Calculator.multiple(c1, 7);
    Calculator.divide(c1, 3);

    Calculator.plus(c2, 2);
    Calculator.plus(c2, 3);    
    Calculator.minus(c2, 1);
    Calculator.multiple(c2, 7);
    Calculator.divide(c2, 3);

    c1.result = 1;

    System.out.printf("result = %d\n", c1.result);
    System.out.printf("result = %d\n", c2.result);
  }


}

