package com.learn.java.streams;

import com.learn.java.data.StudentDataBase;

public class StreamsMatchExample {

  public static boolean allMatch() {
    return StudentDataBase
      .getAllStudents()
      .stream()
      .allMatch(student -> student.getGpa() >= 3.5);
  }
  public static boolean anyMatch() {
    return StudentDataBase
      .getAllStudents()
      .stream()
      .anyMatch(student -> student.getGpa() >= 4.0);
  }
  public static boolean noneMatch() {
    return StudentDataBase
      .getAllStudents()
      .stream()
      .noneMatch(student -> student.getGpa() >= 4.1);
  }

  public static void main(String[] args) {
    System.out.println("allMatch() " + allMatch());
    System.out.println("anyMatch() " + anyMatch());
    System.out.println("noneMatch() " + noneMatch());
  }
}
