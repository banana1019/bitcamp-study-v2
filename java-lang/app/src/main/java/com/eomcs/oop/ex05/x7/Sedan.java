package com.eomcs.oop.ex05.x7;

public class Sedan extends Car {
  boolean auto;
  boolean openedSunroof; // 상태를 저장할 인스턴스 변수 필요해서 추가함

  @Override
  public void run() {
    System.out.println("씽씽 달린다");
  }

  public void openSunroof() {
    System.out.println("썬루프 연다");
    this.openedSunroof = true;
  }

  public void closeSunroof() {
    System.out.println("썬루프 닫는다");
    this.openedSunroof = false;
  }
}
