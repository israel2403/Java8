package com.learn.java.streams.parallel;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class ParallelStreamExample {

  public static long checkPerfomanceResult(
    Supplier<Integer> supplier,
    int numberOfTimes
  ) {
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < numberOfTimes; i++) {
      supplier.get();
    }
    long endTime = System.currentTimeMillis();
    return endTime - startTime;
  }

  public static Integer sumSequentialStream() {
    return IntStream.rangeClosed(1, 100000).sum();
  }

  public static Integer sumParallelStream() {
    return IntStream.rangeClosed(1, 100000).parallel().sum();
  }

  public static void main(String[] args) {
    System.out.println(
      "Available processors: " + Runtime.getRuntime().availableProcessors()
    );
    System.out.println(
      "sumSequentialStream(): " +
      checkPerfomanceResult(ParallelStreamExample::sumSequentialStream, 20)
    );
    System.out.println(
      "sumParallelStream(): " +
      checkPerfomanceResult(ParallelStreamExample::sumParallelStream, 20)
    );
  }
}
