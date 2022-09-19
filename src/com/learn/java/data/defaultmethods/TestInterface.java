package com.learn.java.data.defaultmethods;

public interface TestInterface {
  // abstract method
  public void square(int a);

  // default method
  default void show() {
    System.out.println("Default method Executed");
  }
}
