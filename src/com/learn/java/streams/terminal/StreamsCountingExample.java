package com.learn.java.streams.terminal;

import com.learn.java.data.StudentDataBase;
import java.util.stream.Collectors;

public class StreamsCountingExample {

  public static Long count() {
    return StudentDataBase
      .getAllStudents()
      .stream()
      .filter(student -> student.getGpa() >= 3.9)
      .collect(Collectors.counting());
  }

  public static void main(String[] args) {
    System.out.println("count(): " + count());
  }
}
