package com.eomcs.mylist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
// 이 클래스가 클라이언트 요청 처리 담당자임을 표시한다.
// 이 표시(애노테이션)가 붙어있어야만 스프링 부트가 인식한다.
public class TodoController {

  @RequestMapping("/todo/list") // 클라이언트 요청을 다루는 역할
  public Object list() {
    return ArrayList2.toArray(); // 복사한 항목들을 담고 있는 새 배열을 리턴한다.
  };


  @RequestMapping("/todo/add")
  public Object add(Todo todo) {
    // System.out.println(todo);
    ArrayList2.add(todo);
    return ArrayList2.size;
  }


  @RequestMapping("/todo/update")
  public Object update(int index, Todo todo) {
    if (index < 0 || index >= ArrayList2.size) {
      return 0;
    } 

    return ArrayList2.set(index, todo) == null ? 0 : 1;
  }


  @RequestMapping("/todo/check")
  public Object check(int index, boolean done) {
    if (index < 0 || index >= ArrayList2.size) {
      return 0;  // 인덱스가 무효해서 설정하지 못했다.
    } 
    ((Todo) ArrayList2.list[index]).done = done;
    return 1;  // 해당 항목의 상태를 변경했다.
  }


  @RequestMapping("/todo/delete")
  public Object delete(int index) {
    if (index < 0 || index >= ArrayList2.size) {
      return 0;
    } 

    ArrayList2.remove(index);  // 메서드 이름으로 코드의 의미를 짐작할 수 있다. 이것이 메서드로 분리하는 이유이다.
    return 1;
  }
}