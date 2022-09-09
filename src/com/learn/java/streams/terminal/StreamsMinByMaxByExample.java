package com.learn.java.streams.terminal;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamsMinByMaxByExample {

  public static Optional<Student> minBy() {
    return StudentDataBase
      .getAllStudents()
      .stream()
      .collect(Collectors.minBy(Comparator.comparing(Student::getGpa)));
  }

  public static Optional<Student> maxBy() {
    return StudentDataBase
      .getAllStudents()
      .stream()
      .collect(Collectors.maxBy(Comparator.comparing(Student::getGpa)));
  }

  public static void main(String[] args) {
    System.out.println("minBy(): " + minBy());
    System.out.println("maxBy(): " + maxBy());
  }
}
