package com.learn.java.streams.parallel;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;
import java.util.List;
import java.util.stream.Collectors;

public class ParallerlStraemsExample1 {

  public static List<String> sequentialPrintStudentActivities() {
    long startTime = System.currentTimeMillis();
    List<String> collect = StudentDataBase
      .getAllStudents()
      .stream()
      .map(Student::getActivities)
      .flatMap(List::stream)
      .distinct()
      .collect(Collectors.toList());
    long endTime = System.currentTimeMillis();
    System.out.println(
      "Duration to execute pipeline in sequential: " + (endTime - startTime)
    );
    return collect;
  }

  public static List<String> parallerPrintStudentActivities() {
    long startTime = System.currentTimeMillis();
    List<String> collect = StudentDataBase
      .getAllStudents()
      .stream()
      .parallel()
      .map(Student::getActivities)
      .flatMap(List::stream)
      .distinct()
      .collect(Collectors.toList());
    long endTime = System.currentTimeMillis();
    System.out.println(
      "Duration to execute pipeline in parallel: " + (endTime - startTime)
    );
    return collect;
  }

  public static void main(String[] args) {
    sequentialPrintStudentActivities();
    parallerPrintStudentActivities();
  }
}
