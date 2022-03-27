package com.eomcs.mylist.dao;

import java.io.File;
import org.springframework.stereotype.Repository;
import com.eomcs.mylist.domain.Todo;
import com.fasterxml.jackson.databind.ObjectMapper;

// @Repository
// 클래스에 이 애노테이션을 붙여 표시해 두면, Spring Boot가 이 클래스의 객체를 자동 생성한다.
//
// 의존 객체 주입
@Repository
public class JsonTodoDao extends AbstractTodoDao {

  String filename = "todos.json";

  public JsonTodoDao() {
    try {
      ObjectMapper mapper = new ObjectMapper();
      todoList.addAll(mapper.readValue(new File(filename), Todo[].class));
    } catch (Exception e) {
      System.out.println("해야 할 일 데이터 로딩 중 오류 발생!");
    }
  }

  @Override
  protected void save() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    mapper.writeValue(new File(filename), todoList.toArray());
  }

}
