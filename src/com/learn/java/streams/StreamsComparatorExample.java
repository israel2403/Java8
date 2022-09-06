package com.learn.java.streams;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsComparatorExample {

  public static List<Student> sortStudentsByname() {
    return StudentDataBase
      .getAllStudents()
      .stream()
      .sorted(Comparator.comparing(Student::getName))
      .collect(Collectors.toList());
  }

  public static List<Student> sortStudentsByGpa() {
    return StudentDataBase
      .getAllStudents()
      .stream()
      .sorted(Comparator.comparing(Student::getGpa))
      .collect(Collectors.toList());
  }

  public static List<Student> sortStudentsByGpaDescending() {
    return StudentDataBase
      .getAllStudents()
      .stream()
      .sorted(Comparator.comparing(Student::getGpa).reversed())
      .collect(Collectors.toList());
  }

  public static void main(String[] args) {
    System.out.println("Students sorted by name");
    sortStudentsByname().forEach(System.out::println);
    System.out.println("Students sorted by gpa");
    sortStudentsByGpa().forEach(System.out::println);
    System.out.println("Students sorted by gpa descending");
    sortStudentsByGpaDescending().forEach(System.out::println);
  }
}
