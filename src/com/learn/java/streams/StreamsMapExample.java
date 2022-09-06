package com.learn.java.streams;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsMapExample {

  public static Set<String> namesSet() {
    return StudentDataBase
      .getAllStudents()
      .stream()
      .map(Student::getName)
      .map(String::toUpperCase)
      .collect(Collectors.toSet());
  }

  public static void main(String[] args) {
    System.out.println(namesSet());
  }
}
