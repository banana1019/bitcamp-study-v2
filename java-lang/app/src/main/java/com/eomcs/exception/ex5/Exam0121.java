// 예외 처리 후 - 생각해 볼 문제
package com.eomcs.exception.ex5;

import java.sql.Date;
import java.util.Scanner;

public class Exam0121 {
  // RuntimeException 계열의 예외는 굳이 throws 문장을 선언하지 않아도 되지만,
  // read()를 호출하는 개발자에게 어떤 예외가 발생할 수 있는지
  // 명확하게 제시해주는 것이 유지보수에 도움이 되기 때문에
  // 메서드 선언부에 발생되는 예외를 명시하는 것이 좋다.
  //
  // => 그런데 조금 아쉬움이 있는 점은
  //    read() 메서드를 사용하는 개발자가
  //    이 메서드에서 RuntimeException을 던진다는 의미에 대해
  //    직관적으로 이해하기는 어렵다.
  //    그냥 RuntimeException을 던진다고 하니, 
  //    예외를 던진다는 것은 이해하지만,
  //    그 예외가 의미하는 바가 무엇인지 즉시 알아보기 힘들다는 얘기다.
  //
  static Board read() throws RuntimeException {
    try (Scanner keyScan = new Scanner(System.in)) {
      Board board = new Board();

      System.out.print("번호> ");
      board.setNo(Integer.parseInt(keyScan.nextLine()));

      System.out.print("제목> ");
      board.setTitle(keyScan.nextLine());

      System.out.print("내용> ");
      board.setContent(keyScan.nextLine());

      System.out.print("등록일> ");
      board.setCreatedDate(Date.valueOf(keyScan.nextLine()));

      return board;
    }
  }

  public static void main(String[] args) {
    // 이 프로그램을 실행할 때,
    // 1) 번호를 입력할 때 숫자가 아닌 것을 입력하면 NumberFormatException 예외가 발생한다.
    // 2) 날짜를 입력할 때 yyyy-MM-dd 형식에 맞지 않게 입력하면, IllegalArgumentException 예외가 발생한다.
    //
    // 예외 클래스 이름을 보면 오류의 원인이 상세하게 나와 있지만,
    // 전체적인 그림에서 어느 객체에서 발생된 예외인지 직관적으로 알 수 없다.
    //
    Board board = read();
    System.out.println("---------------------");
    System.out.printf("번호: %d\n", board.getNo());
    System.out.printf("제목: %s\n", board.getTitle());
    System.out.printf("내용: %s\n", board.getContent());
    System.out.printf("등록일: %s\n", board.getCreatedDate());
  }
}


