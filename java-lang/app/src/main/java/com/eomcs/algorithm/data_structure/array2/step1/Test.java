package com.eomcs.algorithm.data_structure.array2.step1;

import com.eomcs.algorithm.data_structure.array2.Score;

public class Test {
  public static void main(String[] args) {
    ArrayList list = new ArrayList();
    list.add(new Score("홍길동", 100, 100, 100));
    list.add(new Score("임꺽정", 90, 90, 90));
    list.add(new Score("유관순", 80, 80, 80));
    list.add(new Score("안중근", 70, 70, 70));
    list.add(new Score("윤봉길", 80, 90, 100));

    for (int i = 0; i < list.size(); i++) {
      Score s = (Score) list.get(i);
      System.out.printf("%s: %d, %f\n", s.name, s.sum, s.aver);
    }


  }
}
