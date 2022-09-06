package com.learn.java.methodreference;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;
import java.util.function.Predicate;

public class RefactorMethodReferenceExample {

  static Predicate<Student> p1 = s -> s.getGradeLevel() >= 3;
  static Predicate<Student> p2 =
    RefactorMethodReferenceExample::graterThanGradeLevel;

  public static boolean graterThanGradeLevel(final Student student) {
    return p1.test(student);
  }

  public static void main(String[] args) {
    System.out.println(p2.test(StudentDataBase.studentSupplier.get()));
  }
}
