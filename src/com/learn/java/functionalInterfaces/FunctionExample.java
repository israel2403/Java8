package com.learn.java.functionalInterfaces;

import java.util.function.Function;

public class FunctionExample {

  static Function<String, String> function = name -> name.toUpperCase();

  static Function<String, String> addSomeString = name -> name.concat("default");

  public static void main(String[] args) {
    System.out.println("Result is: " + function.apply("israel"));

    System.out.println("Result of andthen is: " + function.andThen(addSomeString).apply("israel"));
    
    System.out.println("Result of compose is: " + function.compose(addSomeString).apply("israel"));
  }
}
