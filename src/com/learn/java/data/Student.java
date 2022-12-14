package com.learn.java.data;

import com.learn.java.optional.Bike;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Student {

  public Student() {}

  public Student(final String name) {
    this.name = name;
  }

  private String name;
  private int gradeLevel;
  private double gpa;
  private String gender;
  private int noteBooks;
  private Optional<Bike> bike = Optional.empty();

  public Optional<Bike> getBike() {
    return bike;
  }

  public void setBike(Optional<Bike> bike) {
    this.bike = bike;
  }

  public Student(
    String name,
    int gradeLevel,
    double gpa,
    String gender,
    int noteBooks,
    List<String> activities
  ) {
    this.name = name;
    this.gradeLevel = gradeLevel;
    this.gpa = gpa;
    this.gender = gender;
    this.noteBooks = noteBooks;
    this.activities = activities;
  }

  public Student(
    final String name,
    final int gradeLevel,
    final double gpa,
    final String gender,
    final List<String> activities
  ) {
    this.name = name;
    this.gradeLevel = gradeLevel;
    this.gpa = gpa;
    this.gender = gender;
    this.activities = activities;
  }

  public Student(
    String name,
    int gradeLevel,
    double gpa,
    String gender,
    List<String> activities,
    Optional<Bike> bike
  ) {
    this(name, gradeLevel, gpa, gender, activities);
    this.bike = bike;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getGradeLevel() {
    return gradeLevel;
  }

  public void setGradeLevel(int gradeLevel) {
    this.gradeLevel = gradeLevel;
  }

  public double getGpa() {
    return gpa;
  }

  public void setGpa(double gpa) {
    this.gpa = gpa;
  }

  public void printListOfActivities() {
    System.out.println(activities);
  }

  private List<String> activities = new ArrayList<>();

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  @Override
  public String toString() {
    return (
      "Student [activities=" +
      activities +
      ", bike=" +
      bike +
      ", gender=" +
      gender +
      ", gpa=" +
      gpa +
      ", gradeLevel=" +
      gradeLevel +
      ", name=" +
      name +
      ", noteBooks=" +
      noteBooks +
      "]"
    );
  }

  public List<String> getActivities() {
    return activities;
  }

  public void setActivities(List<String> activities) {
    this.activities = activities;
  }

  public int getNoteBooks() {
    return noteBooks;
  }

  public void setNoteBooks(int noteBooks) {
    this.noteBooks = noteBooks;
  }
}
