package com.eomcs.oop.ex11.overview.step3;

public class StackIterator implements Iterator {
  MyStack stack;
  int cursor;

  public StackIterator(MyStack stack) {
    this.stack = stack;
  }

  @Override
  public boolean hasNext() {
    return stack.size() > 0;
  }

  @Override
  public Object next() {
    return stack.pop();
  }
}
