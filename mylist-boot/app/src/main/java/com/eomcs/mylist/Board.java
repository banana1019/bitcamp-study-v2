package com.eomcs.mylist;

public class Board {
  String title;
  String content;
  int view;
  java.sql.Date created;

  @Override
  public String toString() {
    return "Board [title=" + title + ", content=" + content + ", view=" + view
        + ", created=" + created + "]";
  }

  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public int getView() {
    return view;
  }
  public void setView(int view) {
    this.view = view;
  }
  public java.sql.Date getCreated() {
    return created;
  }
  public void setCreated(java.sql.Date created) {
    this.created = created;
  }

}
