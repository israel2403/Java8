package com.learn.java.streams;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsExamlple {

  public static void main(String[] args) {
    // Student name and there activities in a map
    Predicate<Student> studentPredicate =
      (student -> student.getGradeLevel() >= 3);
    Predicate<Student> studentJpaPredicate =
      (student -> student.getGpa() >= 3.9);

    Map<String, List<String>> studentMap = StudentDataBase
      .getAllStudents()
      .stream()
      .peek(
        (
          student -> {
            System.out.println(student);
          }
        )
      )
      .filter(studentPredicate)
      .peek(
        student -> {
          System.out.println("after 1 st filter" + student);
        }
      )
      .filter(studentJpaPredicate)
      .peek(
        student -> {
          System.out.println("after 2 nd filter" + student);
        }
      )
      .collect(Collectors.toMap(Student::getName, Student::getActivities));
    studentMap.forEach(
      (key, value) -> {
        System.out.println("Key: " + key + ", Value: " + value);
      }
    );
  }
}
