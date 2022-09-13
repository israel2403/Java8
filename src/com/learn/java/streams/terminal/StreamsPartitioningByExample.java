package com.learn.java.streams.terminal;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsPartitioningByExample {

  public static Map<Boolean, List<Student>> partitioningBy_1() {
    Predicate<Student> gpaStudent = student -> student.getGpa() >= 3.8;
    return StudentDataBase
      .getAllStudents()
      .stream()
      .collect(Collectors.partitioningBy(gpaStudent));
  }

  public static Map<Boolean, Set<Student>> partitioningBy_2() {
    Predicate<Student> gpaStudent = student -> student.getGpa() >= 3.8;
    return StudentDataBase
      .getAllStudents()
      .stream()
      .collect(Collectors.partitioningBy(gpaStudent, Collectors.toSet()));
  }

  public static void main(String[] args) {
    partitioningBy_1()
      .forEach(
        (flag, students) -> {
          System.out.println("Is >= 3.8: " + flag + "\nStudents: " + students);
        }
      );
    partitioningBy_2()
      .forEach(
        (flag, students) -> {
          System.out.println("Is >= 3.8: " + flag + "\nStudents: " + students);
        }
      );
  }
}
