package com.eomcs.mylist.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Todo;
import com.eomcs.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController 
// 이 클래스가 클라이언트 요청 처리 담당자임을 표시한다.
// 이 표시(애노테이션)가 붙어있어야만 스프링 부트가 인식한다.
public class TodoController {

  // Todo 객체 목록을 저장할 메모리를 준비한다.
  ArrayList todoList = new ArrayList();

  public TodoController() throws Exception {
    System.out.println("TodoController() 호출됨!");

    try {
      BufferedReader in = new BufferedReader(new FileReader("todos.json")); // 데코레이터

      // JSON 문자열을 다룰 객체 준비
      ObjectMapper mapper = new ObjectMapper();

      // 1) JSON 파일에서 문자열을 읽어 온다.
      // => 읽어 온 문자열은 배열 형식이다.
      //      String jsonStr = in.readLine();

      // 2) JSON 문자열을 가지고 자바 객체를 생성한다.
      // => 배열 형식의 JSON 문자열에서 Board의 배열 객체를 생성한다.
      //      Todo[] todos = mapper.readValue(jsonStr, Todo[].class);

      // 3) 배열 객체를 ArrayList에 저장한다.
      //      for (Todo todo : todos) {
      //        todoList.add(todo);
      //      }
      //      todoList.addAll(todos);

      todoList = new ArrayList(mapper.readValue(in.readLine(), Todo[].class));

      in.close();
    } catch (Exception e) {
      System.out.println("todo 데이터를 로딩하는 중에 오류 발생!");
    }
  }

  @RequestMapping("/todo/list") // 클라이언트 요청을 다루는 역할
  public Object list() {
    return todoList.toArray(); // 복사한 항목들을 담고 있는 새 배열을 리턴한다.
  };


  @RequestMapping("/todo/add")
  public Object add(Todo todo) {
    // System.out.println(todo);
    todoList.add(todo);
    return todoList.size();
  }


  @RequestMapping("/todo/update")
  public Object update(int index, Todo todo) {
    if (index < 0 || index >= todoList.size()) {
      return 0;
    }

    Todo old = (Todo) todoList.get(index);
    todo.setDone(old.isDone());  // 기존의 체크 정보를 그대로 가져가야 한다.

    return todoList.set(index, todo) == null ? 0 : 1;
  }


  @RequestMapping("/todo/check")
  public Object check(int index, boolean done) {
    if (index < 0 || index >= todoList.size()) {
      return 0;  // 인덱스가 무효해서 설정하지 못했다.
    } 
    ((Todo) todoList.get(index)).setDone(done);
    return 1;  // 해당 항목의 상태를 변경했다.
  }


  @RequestMapping("/todo/delete")
  public Object delete(int index) {
    if (index < 0 || index >= todoList.size()) {
      return 0;
    } 

    todoList.remove(index);  // 메서드 이름으로 코드의 의미를 짐작할 수 있다. 이것이 메서드로 분리하는 이유이다.
    return 1;
  }

  @RequestMapping("/todo/save")
  public Object save() throws Exception {
    // 1) 바이트 스트림 객체 준비
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("todos.json")));

    // JSON 형식의 문자열을 다룰 객체를 준비한다.
    ObjectMapper mapper = new ObjectMapper();

    // 1) 객체를 JSON 형식의 문자열로 생성한다.
    // => ArrayList에서 Board 배열을 꺼낸 후 JSON 문자열로 만든다.
    String jsonStr = mapper.writeValueAsString(todoList.toArray());

    // 2) JSON 형식으로 바꾼 문자열을 파일로 출력한다.
    out.println(jsonStr);

    out.close();
    return todoList.size();
  }
}