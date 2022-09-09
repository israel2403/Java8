package com.learn.java.streams.terminal;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;
import java.util.stream.Collectors;

public class StreamsSumAvgExample {

  public static Integer sum() {
    return StudentDataBase
      .getAllStudents()
      .stream()
      .collect(Collectors.summingInt(Student::getNoteBooks));
  }

  public static Double avg() {
    return StudentDataBase
      .getAllStudents()
      .stream()
      .collect(Collectors.averagingInt(Student::getNoteBooks));
  }

  public static void main(String[] args) {
    System.out.println("sum() : " + sum());
    System.out.println("avg() : " + avg());
  }
}
