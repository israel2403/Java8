package com.learn.java.defaultinterfacemethods;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class DefaultMehtodsExample2 {

  static Consumer<Student> studentConsumer = student ->
    System.out.println(student);

  static Comparator<Student> studentNameComparator = Comparator.comparing(
    Student::getName
  );
  static Comparator<Student> studentGradeComparator = Comparator.comparingInt(
    Student::getGradeLevel
  );

  public static void sortByName(List<Student> students) {
    System.out.println("After sort");
    students.sort(studentNameComparator);
    students.forEach(studentConsumer);
  }

  public static void sortByGpa(List<Student> students) {
    System.out.println("After sort GPA");
    Comparator<Student> studentGPAComparator = Comparator.comparingDouble(
      Student::getGpa
    );
    students.sort(studentGPAComparator);
    students.forEach(studentConsumer);
  }

  public static void comparatorChaining(List<Student> students) {
    System.out.println("After comparator chaining");
    students.sort(studentGradeComparator.thenComparing(studentNameComparator));
    students.forEach(studentConsumer);
  }

  public static void sortWithNullValues(List<Student> students) {
    System.out.println("After sortWithNullValues()");
    Comparator<Student> nullsFirst = Comparator.nullsFirst(
      studentNameComparator
    );
    students.sort(nullsFirst);
    students.forEach(studentConsumer);
  }

  public static void main(String[] args) {
    List<Student> students = StudentDataBase.getAllStudents();
    /* System.out.println("Sort by Name");
    System.out.println("Before Sort");
    students.forEach(studentConsumer);
    sortByName(students); */
    /* System.out.println("Before Sort");
    students.forEach(studentConsumer);
    System.out.println("Sort by Gpa");
    sortByGpa(students); */
    /* System.out.println("Before Sort");
    students.forEach(studentConsumer);
    System.out.println("Sort by comparatorChaining");
    comparatorChaining(students); */
    System.out.println("Before Sort");
    students.forEach(studentConsumer);
    sortWithNullValues(students);
  }
}
