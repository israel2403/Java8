package com.learn.java.optional;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;
import java.util.Optional;

public class OptionalOrElseExample {

  //orElse
  public static String optionalOrElse() {
    Optional<Student> sOptional = Optional.ofNullable(
      StudentDataBase.studentSupplier.get()
    );

    String name = sOptional.map(Student::getName).orElse("Default");
    return name;
  }

  //orElseGet
  public static String optionalOrElseGet() {
    Optional<Student> sOptional = Optional.ofNullable(
      StudentDataBase.studentSupplier.get()
    );
    String name = sOptional.map(Student::getName).orElseGet(() -> "Default");
    return name;
  }

  //orElseThrow
  public static String optionalOrElseThrow() {
    Optional<Student> sOptional = Optional.ofNullable(null);
    String name = sOptional
      .map(Student::getName)
      .orElseThrow(() -> new RuntimeException("No data Available"));
    return name;
  }

  public static void main(String[] args) {
    System.out.println("optionalOrElse(): " + optionalOrElse());
    System.out.println("optionalOrElseGet(): " + optionalOrElseGet());
    System.out.println("optionalOrElseThrow(): " + optionalOrElseThrow());
  }
}
