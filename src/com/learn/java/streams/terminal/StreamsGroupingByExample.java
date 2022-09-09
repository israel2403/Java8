package com.learn.java.streams.terminal;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsGroupingByExample {

  public static Map<String, List<Student>> groupStudentsByGender() {
    return StudentDataBase
      .getAllStudents()
      .stream()
      .collect(Collectors.groupingBy(Student::getGender));
  }

  public static Map<String, List<Student>> customizeGroupingBy() {
    return StudentDataBase
      .getAllStudents()
      .stream()
      .collect(
        Collectors.groupingBy(
          student -> student.getGpa() >= 3.8 ? "OUTSTANDING" : "AVERAGE"
        )
      );
  }

  public static Map<Integer, Map<String, List<Student>>> twoLevelGrouping_1() {
    return StudentDataBase
      .getAllStudents()
      .stream()
      .collect(
        Collectors.groupingBy(
          Student::getGradeLevel,
          Collectors.groupingBy(
            student -> student.getGpa() >= 3.8 ? "OUTSTANDING" : "AVERAGE"
          )
        )
      );
  }

  public static Map<Integer, Integer> twoLevelGrouping_2() {
    return StudentDataBase
      .getAllStudents()
      .stream()
      .collect(
        Collectors.groupingBy(
          Student::getGradeLevel,
          Collectors.summingInt(Student::getNoteBooks)
        )
      );
  }

  public static LinkedHashMap<String, Set<Student>> threeLevelGrouping_1() {
    return StudentDataBase
      .getAllStudents()
      .stream()
      .collect(
        Collectors.groupingBy(
          Student::getName,
          LinkedHashMap::new,
          Collectors.toSet()
        )
      );
  }

  public static Map<Integer, Optional<Student>> calculateTopGpaWithOptional() {
    return StudentDataBase
      .getAllStudents()
      .stream()
      .collect(
        Collectors.groupingBy(
          Student::getGradeLevel,
          Collectors.maxBy(Comparator.comparing(Student::getGpa))
        )
      );
  }

  public static Map<Integer, Student> calculateTopGpaWithoutOptional() {
    return StudentDataBase
      .getAllStudents()
      .stream()
      .collect(
        Collectors.groupingBy(
          Student::getGradeLevel,
          Collectors.collectingAndThen(
            Collectors.maxBy(Comparator.comparing(Student::getGpa)),
            Optional::get
          )
        )
      );
  }

  public static Map<Integer, Student> calculateLeastGpaWithoutOptional() {
    return StudentDataBase
      .getAllStudents()
      .stream()
      .collect(
        Collectors.groupingBy(
          Student::getGradeLevel,
          Collectors.collectingAndThen(
            Collectors.minBy(Comparator.comparing(Student::getGpa)),
            Optional::get
          )
        )
      );
  }

  public static void main(String[] args) {
    /* System.out.println("groupStudentsByGender()");
    groupStudentsByGender()
      .forEach(
        (gender, studentList) ->
          System.out.println(
            "gender: " + gender + " \nstudentList: " + studentList
          )
      );
    System.out.println("customizeGroupingBy()");
    customizeGroupingBy()
      .forEach(
        (category, studentList) ->
          System.out.println(
            "category: " + category + " \nstudentList: " + studentList
          )
      ); */
    /* twoLevelGrouping_1()
      .forEach(
        (gradeLevel, groupStudent) -> {
          System.out.println("Grade Level: " + gradeLevel);
          groupStudent.forEach(
            (category, students) -> {
              System.out.println(
                "Category: " + category + "\nstudentList:" + students
              );
            }
          );
        }
      ); */

    /* twoLevelGrouping_2()
      .forEach(
        (gradeLevel, noOfNoteBooks) -> {
          System.out.println(
            "Grade level: " +
            gradeLevel +
            " - " +
            "No. of Notebooks: " +
            noOfNoteBooks
          );
        }
      ); */
    /* threeLevelGrouping_1()
      .forEach(
        (name, students) -> {
          System.out.println("Name: " + name + "\nStudents: " + students);
        }
      ); */
    /* calculateTopGpaWithOptional()
      .forEach(
        (gradeLevel, student) -> {
          System.out.println(
            "Grade Level: " + gradeLevel + "\nStudent: " + student
          );
        }
      );
    calculateTopGpaWithoutOptional()
      .forEach(
        (gradeLevel, student) -> {
          System.out.println(
            "Grade Level: " + gradeLevel + "\nStudent: " + student
          );
        }
      ); */
    calculateLeastGpaWithoutOptional()
      .forEach(
        (gradeLevel, student) -> {
          System.out.println(
            "Grade Level: " + gradeLevel + "\nStudent: " + student
          );
        }
      );
  }
}
