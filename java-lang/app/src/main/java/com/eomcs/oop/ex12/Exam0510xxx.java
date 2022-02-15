// 메서드 레퍼런스 - 스태틱 메서드 레퍼런스
package com.eomcs.oop.ex12;


public class Exam0510xxx {

  static class MyCalculator {
    public static int plus(int a, int b) {return a + b;}
    public static int minus(int a, int b) {return a - b;}
    public static int multiple(int a, int b) {return a * b;}
    public static int divide(int a, int b) {return a / b;}
  }

  interface Calculator {
    int compute(int x, int y);
  }

  public static void main(String[] args) {

    // 1) 로컬 클래스
    class CalculatorImpl implements Calculator {
      @Override
      public int compute(int x, int y) {
        return MyCalculator.plus(x, y);
      }
    }

    Calculator c1 = new CalculatorImpl();

    System.out.println(c1.compute(200, 17));

    // 2) 익명 클래스
    Calculator c2 = new Calculator() {
      @Override
      public int compute(int x, int y) {
        return MyCalculator.plus(x, y);
      }
    };

    System.out.println(c2.compute(200, 17));

    // 3) 람다
    Calculator c3 = (x, y) -> MyCalculator.plus(x, y);

    System.out.println(c3.compute(200, 17));

    // 4) 메서드 레퍼런스
    Calculator c4 = MyCalculator::plus;

    System.out.println(c4.compute(200, 17));

  }
}


