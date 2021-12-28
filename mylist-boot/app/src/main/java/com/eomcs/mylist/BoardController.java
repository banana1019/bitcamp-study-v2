package com.eomcs.mylist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class BoardController {

  @RequestMapping("/board/list")
  public Object list() {
    return ArrayList3.toArray(); 
  }

  @RequestMapping("/board/add")
  public Object add(Board contact) {
    System.out.println(contact);
    ArrayList3.add(contact);
    return ArrayList3.size;
  }


  @RequestMapping("/board/get")
  public Object get(String title) {
    int index = indexOf(title);
    if (index == -1) {
      return "";
    }

    return ArrayList3.list[index];
  }

  @RequestMapping("/board/update")
  public Object update(Board contact) {
    int index = indexOf(contact.title);
    if (index == -1) {
      return 0;
    }

    return ArrayList3.set(index, contact) == null ? 0 : 1;
  }

  @RequestMapping("/board/delete")
  public Object delete(String title) {
    int index = indexOf(title);
    if (index == -1) {
      return 0;
    }

    ArrayList3.remove(index);
    return 1;
  }

  static int indexOf(String title) {
    for (int i = 0; i < ArrayList3.size; i++) {
      Board contact = (Board) ArrayList3.list[i];
      if (contact.title.equals(title)) { 
        return i;
      }
    }
    return -1;
  }
}