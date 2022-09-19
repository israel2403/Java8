package com.learn.java.data.defaultmethods;

public class TestClass implements TestInterface {

  @Override
  public void square(int a) {
    System.out.println(a * a);
  }

  // implementation of square abstract method
  public static void main(String[] args) {
    TestClass d = new TestClass();
    d.square(4);
    // default method executed
    d.show();
  }
}
