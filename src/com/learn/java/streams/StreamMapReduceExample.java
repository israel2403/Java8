package com.learn.java.streams;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

public class StreamMapReduceExample {

  public static Integer getNotebooksSum() {
    return StudentDataBase
      .getAllStudents()
      .stream()
      .filter(student -> student.getGradeLevel() >= 3)
      .filter(student -> student.getGender().equals("female"))
      .map(Student::getNoteBooks)
      .reduce(0, (a, b) -> a + b);
  }

  public static void main(String[] args) {
    System.out.println("getNotebooksSum()");
    System.out.println(getNotebooksSum());
  }
}
