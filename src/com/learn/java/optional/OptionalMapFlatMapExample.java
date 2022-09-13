package com.learn.java.optional;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;
import java.util.Optional;

public class OptionalMapFlatMapExample {

  // filter
  public static void optionalFilter() {
    Optional<Student> studentOptional = Optional.ofNullable(
      StudentDataBase.studentSupplier.get()
    );

    studentOptional
      .filter(student -> student.getGpa() >= 4.0)
      .ifPresent(student -> System.out.println(student));
  }

  // flatmap
  public static void optionalFlatMap() {
    Optional<Student> studentOptional = Optional.ofNullable(
      StudentDataBase.studentSupplier.get()
    );
    Optional<String> name = studentOptional
      .filter(student -> student.getGpa() >= 3.5)
      .flatMap(Student::getBike)
      .map(Bike::getName);
    System.out.println(name);
  }

  // map
  public static void optionlMap() {
    Optional<Student> studentOptional = Optional.ofNullable(
      StudentDataBase.studentSupplier.get()
    );
    if (studentOptional.isPresent()) {
      Optional<String> stringOptional = studentOptional
        .filter(student -> student.getGpa() >= 3.5)
        .map(Student::getName);
      System.out.println(stringOptional.get());
    }
  }

  public static void main(String[] args) {
    optionalFilter();
    optionlMap();
    optionalFlatMap();
  }
}
