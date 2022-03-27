package com.eomcs.mylist.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Book;
import com.eomcs.util.ArrayList;

@RestController 
public class MyBookController {

  // Book 객체 목록을 저장할 메모리를 준비한다.
  ArrayList bookList = new ArrayList();

  public MyBookController() {
    System.out.println("BookController() 호출됨!");
  }

  @RequestMapping("/book2/list")
  public Object list() {
    return bookList.toArray(); 
  }

  @RequestMapping("/book2/add")
  public Object add(Book book) {
    System.out.println(book);
    bookList.add(book);
    return bookList.size();
  }


  @RequestMapping("/book2/get")
  public Object get(int index) {
    if (index < 0 || index >= bookList.size()) {
      return "";
    }
    Book book = (Book) bookList.get(index);
    return book;
  }

  @RequestMapping("/book2/update")
  public Object update(int index, Book book) {
    if (index < 0 || index >= bookList.size()) {
      return 0;
    }
    Book old = (Book) bookList.get(index);
    return bookList.set(index, book) == null ? 0 : 1;
  }

  @RequestMapping("/book2/delete")
  public Object delete(int index) {
    if (index < 0 || index >= bookList.size()) {
      return 0;
    }
    return bookList.remove(index) == null ? 0 : 1;
  }
}