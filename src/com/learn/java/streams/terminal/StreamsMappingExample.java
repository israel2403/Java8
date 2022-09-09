package com.learn.java.streams.terminal;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsMappingExample {

  public static void main(String[] args) {
    List<String> namesList = StudentDataBase
      .getAllStudents()
      .stream()
      .collect(Collectors.mapping(Student::getName, Collectors.toList()));
    System.out.println("Names List:");
    namesList.forEach(System.out::println);

    Set<String> namesSetList = StudentDataBase
      .getAllStudents()
      .stream()
      .collect(Collectors.mapping(Student::getName, Collectors.toSet()));
    System.out.println("Names Set List:");
    namesSetList.forEach(System.out::println);
  }
}
