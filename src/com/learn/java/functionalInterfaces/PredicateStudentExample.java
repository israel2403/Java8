package com.learn.java.functionalInterfaces;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;
import java.util.List;
import java.util.function.Predicate;

public class PredicateStudentExample {

  static Predicate<Student> p1 = student -> student.getGradeLevel() >= 3;
  static Predicate<Student> p2 = student -> student.getGradeLevel() >= 3.9;

  public static void filterStudentByGradeLevel() {
    System.out.println("filterStudentByGradeLevel: ");
    List<Student> students = StudentDataBase.getAllStudents();
    students.forEach(
      student -> {
        if (p1.test(student)) {
          System.out.println(student);
        }
      }
    );
  }

  public static void filterStudentByGpa() {
    System.out.println("filterStudentByGpa: ");
    List<Student> students = StudentDataBase.getAllStudents();
    students.forEach(
      student -> {
        if (p2.test(student)) {
          System.out.println(student);
        }
      }
    );
  }

  public static void filterStudents() {
    System.out.println("filterStudents: ");
    List<Student> students = StudentDataBase.getAllStudents();
    students.forEach(
      student -> {
        if (p2.and(p2).test(student)) {
          System.out.println(student);
        }
      }
    );
  }

  public static void main(String[] args) {
    filterStudentByGradeLevel();
    filterStudentByGpa();
    filterStudents();
  }
}
