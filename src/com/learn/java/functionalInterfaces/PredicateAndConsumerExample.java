package com.learn.java.functionalInterfaces;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateAndConsumerExample {

  Predicate<Student> p1 = student -> student.getGradeLevel() >= 3;
  Predicate<Student> p2 = student -> student.getGpa() >= 3.9;

  BiPredicate<Integer, Double> biPredicate = (gradeLevel, gpa) ->
    gradeLevel >= 3 && gpa >= 3.9;

  BiConsumer<String, List<String>> studentBiconsumer = (name, activities) ->
    System.out.println(name + " : " + activities);

  Consumer<Student> studentConsumer =
    (
      student -> {
        if (biPredicate.test(student.getGradeLevel(), student.getGpa())) {
          studentBiconsumer.accept(student.getName(), student.getActivities());
        }
      }
    );

  public void printnameAndActivities(final List<Student> students) {
    students.forEach(studentConsumer);
  }

  public static void main(String[] args) {
    List<Student> listStudents = StudentDataBase.getAllStudents();
    new PredicateAndConsumerExample().printnameAndActivities(listStudents);
  }
}
