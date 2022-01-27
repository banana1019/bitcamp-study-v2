package com.eomcs.app1;

import java.util.Arrays;
import java.util.Scanner;

public class Console {

  Scanner keyScan = new Scanner(System.in);

  Command prompt() {
    System.out.print("> ");
    String[] values = keyScan.nextLine().split(" ");

    return new Command(values[0], Arrays.copyOfRange(values, 1, values.length));
  }

  void close() {
    keyScan.close();
  }
}
