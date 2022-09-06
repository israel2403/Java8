package com.learn.java.streams;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsFlatMapExample {

  public static List<String> printStudentActivities() {
    return StudentDataBase
      .getAllStudents()
      .stream()
      .map(Student::getActivities)
      .flatMap(List::stream)
      .distinct()
      .collect(Collectors.toList());
  }

  public static Long totalNumOfActivitiesLong() {
    return StudentDataBase
      .getAllStudents()
      .stream()
      .map(Student::getActivities)
      .flatMap(List::stream)
      .distinct()
      .count();
  }

  public static List<String> totalNumOfActivitiesLongSorted() {
    return StudentDataBase
      .getAllStudents()
      .stream()
      .map(Student::getActivities)
      .flatMap(List::stream)
      .distinct()
      .sorted()
      .collect(Collectors.toList());
  }

  public static void main(String[] args) {
    System.out.println("printStudentActivities: " + printStudentActivities());
    System.out.println(
      "totalNumOfActivitiesLong: " + totalNumOfActivitiesLong()
    );
    System.out.println(
      "totalNumOfActivitiesLongSorted: " + totalNumOfActivitiesLongSorted()
    );
  }
}
