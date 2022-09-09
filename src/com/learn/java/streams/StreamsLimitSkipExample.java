package com.learn.java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsLimitSkipExample {

  public static void main(String[] args) {
    List<Integer> integers = Arrays.asList(6, 7, 8, 9, 10);
    Optional<Integer> limit = limit(integers);
    if (limit.isPresent()) {
      System.out.println("limit()");
      System.out.println(limit.get());
    }
    Optional<Integer> skip = skip(integers);
    if (skip .isPresent()) {
      System.out.println("skip()");
      System.out.println(skip.get());
    }
  }

  private static Optional<Integer> limit(List<Integer> integers) {
    return integers.stream().limit(2).reduce((a, b) -> a + b);
  }

  private static Optional<Integer> skip(List<Integer> integers) {
    return integers.stream().skip(2).reduce((a, b) -> a + b);
  }
}
