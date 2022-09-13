package com.learn.java.optional;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;
import java.util.Optional;

public class OptionalExample {

  public static String getStudentName() {
    final Student student = null;
    return (student != null) ? student.getName() : null;
  }

  public static void main(String[] args) {
    Optional<String> stringOptional = getStudentNameOptional();
    if (stringOptional.isPresent()) {
      System.out.println(
        "Length of the student Name: " + stringOptional.get().length()
      );
    }
  }

  public static Optional<String> getStudentNameOptional() {
    Optional<Student> studentOptional = Optional.ofNullable(
      StudentDataBase.studentSupplier.get()
    );

    if (studentOptional.isPresent()) {
      return studentOptional.map(Student::getName);
    }
    return Optional.empty(); // Represents an optional object with no value
  }
}
