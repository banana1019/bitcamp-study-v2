package com.eomcs.oop.ex05.x4.app5;

import com.eomcs.oop.ex05.x4.app2.Truck;
import com.eomcs.oop.ex05.x4.app3.CampingTrailer;

public class TrailerTruck extends Truck {
  // 트레일러 붙이는 기능 추가
  CampingTrailer trailer;

  public void setTrailer(CampingTrailer trailer) {
    this.trailer = trailer;
  }

  // 상속 받은 run() 메서드를 현재 클래스의 역할에 맞게끔 재정의한다. => 오버라이딩(overriding)
  @Override
  public void run() {
    // 트레일러 장착 기능이 추가되었다면 다음과 같이 run() 메서드를 변경해야 한다.
    if (trailer == null) {
      super.run(); // 재정의하기 전 메서드 호출
    } else {
      System.out.println("느릿느릿 조심히 움직인다");
    }
  }
}
