package com.eomcs.mylist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class My1Controller2 {

  String[] books = new String[5];
  int size = 0;

  @RequestMapping("/my1v2/list")
  public Object list() {
    String[] arr = new String[size];
    for (int i = 0; i < size; i++) {
      arr[i] = books[i];
    }
    return arr;
  };

  @RequestMapping("/my1v2/add")
  public Object add(String id, String title, String author, String publisher, String price) {
    String book = id + "," + title + "," + author + "," + publisher + "," + price;
    books[size++] = book;
    return size;
  };

  @RequestMapping("/my1v2/get")
  public Object get(String id) {
    for (int i = 0; i < size; i++) {
      if (books[i].split(",")[0].equals(id)) {
        return books[i];
      }
    }
    return "";
  };

  @RequestMapping("/my1v2/update")
  public Object update(String id, String title, String author, String publisher, String price) {
    String book = id + "," + title + "," + author + "," + publisher + "," + price;
    for (int i = 0; i < size; i++) {
      if (books[i].split(",")[0].equals(title)) {
        books[i] = book;
        return 1;
      }
    }
    return 0;
  }

  @RequestMapping("/my1v2/delete")
  public Object delete(String id) {
    for (int i = 0; i < size; i++) {
      if (books[i].split(",")[0].equals(id)) {
        // 현재 위치의 다음 항목에서 배열 끝까지 반복하여 앞으로 당겨온다.
        for (int j = i + 1; j < size; j++) {
          books[j-1] = books[j];
        }
        size--;
        return 1;
      }
    }
    return 0;
  };
}
