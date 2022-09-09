package com.learn.java.streams;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;
import java.util.Optional;

public class StreamsFindAnyFirstExample {

  public static Optional<Student> findAnyStudent() {
    return StudentDataBase
      .getAllStudents()
      .stream()
      .filter(student -> student.getGpa() >= 3.9)
      .findAny();
  }
  public static Optional<Student> findFirstStudent() {
    return StudentDataBase
      .getAllStudents()
      .stream()
      .filter(student -> student.getGpa() >= 3.9)
      .findFirst();
  }

  public static void main(String[] args) {
    Optional<Student> findAnyStudent = findAnyStudent();
    System.out.println("findAnyStudent()");
    if (findAnyStudent.isPresent()) {
      System.out.println(findAnyStudent.get());
    } else {
        System.out.println("No student found!");
    }
    Optional<Student> findFirstStudent = findFirstStudent();
    System.out.println("findFirstStudent()");
    if (findFirstStudent.isPresent()) {
      System.out.println(findFirstStudent.get());
    } else {
        System.out.println("No student found!");
    }
  }
}
