package com.learn.java.methodreference;

import java.util.function.Consumer;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

public class ConsumerMethodReferenceExample {

  static Consumer<Student> c1 = System.out::println;

  static Consumer<Student> c2 = Student::printListOfActivities;

  public static void main(String[] args) {
    System.out.println("c1");
    StudentDataBase.getAllStudents().forEach(c1);
    System.out.println("c2");
    StudentDataBase.getAllStudents().forEach(c2);
  }
}
