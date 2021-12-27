package com.eomcs.mylist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
// 이 클래스가 클라이언트 요청 처리 담당자임을 표시한다.
// 이 표시(애노테이션)가 붙어있어야만 스프링 부트가 인식한다.
public class ContactController {

  @RequestMapping("/contact/list") // 클라이언트 요청을 다루는 역할
  public Object list() {
    return ArrayList.toArray(); // 복사한 항목들을 담고 있는 새 배열을 리턴한다.
  };


  @RequestMapping("/contact/add")
  public Object add(Contact contact) {
    // System.out.println(contact);
    ArrayList.add(contact);
    return ArrayList.size;
  }


  @RequestMapping("/contact/get")
  public Object get(String email) {
    int index = ArrayList.indexOf(email);
    if (index == -1) {
      return "";
    } 

    return ArrayList.contacts[index];

  }


  @RequestMapping("/contact/update")
  public Object update(Contact contact) {
    int index = ArrayList.indexOf(contact.email);
    if (index == -1) {
      return 0;
    }

    return ArrayList.set(index, contact) == null ? 0 : 1;
  }


  @RequestMapping("/contact/delete")
  public Object delete(String email) {
    int index = ArrayList.indexOf(email);
    if (index == -1) {
      return 0;
    }

    ArrayList.remove(index);  // 메서드 이름으로 코드의 의미를 짐작할 수 있다. 이것이 메서드로 분리하는 이유이다.
    return 1;
  }
}