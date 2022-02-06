package com.eomcs.app1;

public class App {

  public static void main(String[] args) {

    Console console = new Console();
    CommandHandler commandHandler = new CommandHandler();

    while (true) {
      Command command = console.prompt();
<<<<<<< HEAD
      try { // 예외가 발생할 가능성이 있는 코드는 try 블록 안에 가둔다.
        if (command.getName().equals("quit") || command.getName().equals("exit")) {
          break;
        } else if (command.getName().equals("")) {
          continue;
        } else if (command.getName().equals("help")) {
          commandHandler.doHelp();
        } else if (command.getName().equals("add")) {
          commandHandler.doAdd(command);
        } else if (command.getName().equals("minus")) {
          commandHandler.doMinus(command);
        } else if (command.getName().equals("divide")) {
          commandHandler.doDivide(command);
        } else {
          System.out.println("지원하지 않는 연산자입니다.");
        }
      } catch (Exception e) { // try 블록에서 발생된 예외를 잡는 블록을 준비한다.
        // 예외에 대한 적절한 조치를 취하는 코드를 이 블록에 둔다.
        System.out.println("명령어 처리 중 오류 발생!");
=======
      if (command.getName().equals("quit") || command.getName().equals("exit")) {
        break;
      } else if (command.getName().equals("")) {
        continue;
      } else if (command.getName().equals("help")) {
        commandHandler.doHelp();
      } else if (command.getName().equals("add")) {
        commandHandler.doAdd(command);
      } else if (command.getName().equals("minus")) {
        commandHandler.doMinus(command);
      } else {
        System.out.println("지원하지 않는 연산자입니다.");
>>>>>>> c022fe8a5729b7f79aea815346efc4a0c89ac779
      }
    }

    console.close();
  }

}
