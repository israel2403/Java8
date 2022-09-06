package com.learn.java.streams;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsReduceExample {

  public static Integer performMultiplication(final List<Integer> integers) {
    // 1
    // 3
    // 5
    // 7
    // a=1,b=1(from stream) => result 1 is returned
    // a=1,b=3(from stream) => result 3 is returned
    // a=3,b=5(from stream) => result 15 is returned
    // a=15,b=7(from stream) => result 105 is returned
    return integers.stream().reduce(1, (a, b) -> a * b);
  }

  public static Optional<Integer> performMultiplicationWithoutIdentity(
    final List<Integer> integers
  ) {
    // 1
    // 3
    // 5
    // 7
    // a=1,b=1(from stream) => result 1 is returned
    // a=1,b=3(from stream) => result 3 is returned
    // a=3,b=5(from stream) => result 15 is returned
    // a=15,b=7(from stream) => result 105 is returned
    return integers.stream().reduce((a, b) -> a * b);
  }

  public static Optional<Student> getHigiestGPAStudet() {
    return StudentDataBase
      .getAllStudents()
      .stream()
      .reduce((a, b) -> (a.getGpa() > b.getGpa()) ? a : b);
  }

  public static void main(String[] args) {
    List<Integer> integers = Arrays.asList(1, 3, 5, 7);
    List<Integer> integersEmpty = Arrays.asList();
    System.out.println(performMultiplication(integers));

    Optional<Integer> result = performMultiplicationWithoutIdentity(integers);
    System.out.println(result.isPresent());
    System.out.println(result.get());
    Optional<Integer> resultEmpty = performMultiplicationWithoutIdentity(
      integersEmpty
    );
    if (resultEmpty.isPresent()) {
      System.out.println(resultEmpty.get());
    }
    Optional<Student> studentByHighestGPA = getHigiestGPAStudet();
    if (studentByHighestGPA.isPresent()) {
      System.out.println(studentByHighestGPA.get());
    }
  }
}
