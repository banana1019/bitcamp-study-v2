package com.eomcs.mylist.domain;

import java.sql.Date;

public class Board implements java.io.Serializable {
  String title;
  String content;
  int viewCount;
  java.sql.Date createdDate;


  public Board() {
    System.out.println("Board() 호출됨!");
  }

  public Board(String csvStr) {
    // 예) csvStr => "홍길동,hong@test.com,010-1111-2222,비트캠프"
    String[] values = csvStr.split(","); // 예) ["홍길동","hong@test.com","010-1111-2222","비트캠프"]
    this.setTitle(values[0]); // 배열에 들어 있는 각 항목을 객체의 필드에 저장한다. 
    this.setContent(values[1]);
    this.setViewCount(Integer.valueOf(values[2]));
    this.setCreatedDate(Date.valueOf(values[3]));
  }

  // 적용기술
  // => 스태틱 메서드 : 특정 인스턴스에 종속되지 않고 사용하는 메서드
  // => GoF의 'Factory Method' 패턴
  //    객체 생성 과정이 복잡할 경우 new 명령을 통해 직접 객체를 생성하는 대신에
  //    메서드를 통해 객체를 리턴받는다.
  //    이렇게 객체를 만들어주는 메서드를 '공장 메서드(factory method)'라 부른다.
  //    보통 스태틱 메서드로 정의한다.
  //
  public static Board valueOf(String csvStr) {
    // 예) csvStr => "홍길동,hong@test.com,010-1111-2222,비트캠프"

    String[] values = csvStr.split(","); // 예) ["홍길동","hong@test.com","010-1111-2222","비트캠프"]

    Board board = new Board();
    board.setTitle(values[0]); // 배열에 들어 있는 각 항목을 객체의 필드에 저장한다. 
    board.setContent(values[1]);
    board.setViewCount(Integer.valueOf(values[2]));
    board.setCreatedDate(Date.valueOf(values[3]));

    return board;
  }

  // 적용 기술
  // => 인스턴스 메서드: 특정 인스턴스를 사용한다면 인스턴스 메서드로 만들라!  
  // => GRASP의 Information Expert 패턴
  //    데이터를 가공하는 기능은 그 데이터를 갖고 있는 클래스에 둬야 한다.
  public String toCsvString() {
    return String.format("%s,%s,%s,%s", 
        this.getTitle(), 
        this.getContent(), 
        this.getViewCount(), 
        this.getCreatedDate());
  }

  @Override
  public String toString() {
    return "Board [title=" + title + ", content=" + content + ", viewCount=" + viewCount
        + ", createdDate=" + createdDate + "]";
  }

  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public int getViewCount() {
    return viewCount;
  }
  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }
  public java.sql.Date getCreatedDate() {
    return createdDate;
  }
  public void setCreatedDate(java.sql.Date createdDate) {
    this.createdDate = createdDate;
  }

}
