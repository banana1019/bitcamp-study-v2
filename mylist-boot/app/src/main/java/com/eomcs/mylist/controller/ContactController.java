package com.eomcs.mylist.controller;

import java.io.FileWriter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Contact;
import com.eomcs.util.ArrayList;

@RestController 
public class ContactController {

  // Contact 객체 목록을 저장할 메모리 준비
  // => Object[] list = new Object[5];
  // => int size = 0;
  ArrayList contactList;

  public ContactController() {
    contactList = new ArrayList();
    System.out.println("ContactController() 호출됨!");
  }

  @RequestMapping("/contact/list")
  public Object list() {
    return contactList.toArray(); 
  }

  @RequestMapping("/contact/add")
  public Object add(Contact contact) {
    //    System.out.println(contact);
    contactList.add(contact);
    return contactList.size();
  }

  @RequestMapping("/contact/get")
  public Object get(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return "";
    }

    return contactList.get(index);
  }

  @RequestMapping("/contact/update")
  public Object update(Contact contact) {
    int index = indexOf(contact.getEmail());
    if (index == -1) {
      return 0;
    }

    return contactList.set(index, contact) == null ? 0 : 1;
  }

  @RequestMapping("/contact/delete")
  public Object delete(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return 0;
    }

    contactList.remove(index);
    return 1;
  }

  @RequestMapping("/contact/save")
  public Object save() throws Exception {
    FileWriter out = new FileWriter("contact.csv"); // 따로 경로를 지정하지 않으면 파일은 프로젝트 폴더에 파일이 생성된다.
    Object[] arr = contactList.toArray();
    for (Object obj : arr) {
      Contact contact = (Contact) obj;
      out.write(String.format("%s,%s,%s,%s\n", 
          contact.getName(), 
          contact.getEmail(), 
          contact.getTel(), 
          contact.getCompany()));
    }
    out.close();
    return 0;
  }

  int indexOf(String email) {
    for (int i = 0; i < contactList.size(); i++) {
      Contact contact = (Contact) contactList.get(i);
      if (contact.getEmail().equals(email)) { 
        return i;
      }
    }
    return -1;
  }
}