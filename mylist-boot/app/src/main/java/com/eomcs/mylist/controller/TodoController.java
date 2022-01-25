package com.eomcs.mylist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.dao.TodoDao;
import com.eomcs.mylist.domain.Todo;

@RestController 
// 이 클래스가 클라이언트 요청 처리 담당자임을 표시한다.
// 이 표시(애노테이션)가 붙어있어야만 스프링 부트가 인식한다.
public class TodoController {

  @Autowired
  TodoDao todoDao;

  @RequestMapping("/todo/list") // 클라이언트 요청을 다루는 역할
  public Object list() {
    return todoDao.findAll(); // 복사한 항목들을 담고 있는 새 배열을 리턴한다.
  };


  @RequestMapping("/todo/add")
  public Object add(Todo todo) throws Exception {
    todoDao.insert(todo);
    return todoDao.countAll();
  }


  @RequestMapping("/todo/update")
  public Object update(int index, Todo todo) throws Exception {
    Todo old = todoDao.findByNo(index);
    if (old == null) {
      return 0;
    }

    todo.setDone(old.isDone());  // 기존의 체크 정보를 그대로 가져가야 한다.

    return todoDao.update(index, todo);
  }


  @RequestMapping("/todo/check")
  public Object check(int index, boolean done) throws Exception {
    return todoDao.updateDone(index, done);
  }


  @RequestMapping("/todo/delete")
  public Object delete(int index) throws Exception {
    return todoDao.delete(index);
  }

}