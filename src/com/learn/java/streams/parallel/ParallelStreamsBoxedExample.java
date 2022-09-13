package com.learn.java.streams.parallel;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamsBoxedExample {

  public static Integer sequentialSum(List<Integer> integerList) {
    long startTime = System.currentTimeMillis();
    Integer sum = integerList.stream().reduce(0, (x, y) -> x + y);
    long duration = System.currentTimeMillis() - startTime;
    System.out.println("Duration in Sequential Stream: " + duration);
    return sum;
  }

  public static Integer parallelSum(List<Integer> integerList) {
    long startTime = System.currentTimeMillis();
    Integer sum = integerList.parallelStream().reduce(0, (x, y) -> x + y);
    long duration = System.currentTimeMillis() - startTime;
    System.out.println("Duration in Parallel Stream: " + duration);
    return sum;
  }

  public static void main(String[] args) {
    List<Integer> integerList = IntStream
      .rangeClosed(1, 10000)
      .boxed()
      .collect(Collectors.toList());
    sequentialSum(integerList);
    parallelSum(integerList);
  }
}
