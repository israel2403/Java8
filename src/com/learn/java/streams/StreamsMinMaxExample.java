package com.learn.java.streams;

import java.lang.StackWalker.Option;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsMinMaxExample {

  public static Integer findMaxValue(final List<Integer> integerList) {
    return integerList.stream().reduce(0, (a, b) -> (a > b) ? a : b);
  }

  public static Optional<Integer> findMaxValueOptional(
    final List<Integer> integerList
  ) {
    return integerList.stream().reduce((a, b) -> (a > b) ? a : b);
  }

  public static void main(String[] args) {
    List<Integer> integerList = Arrays.asList(6, 7, 8, 9, 10);
    System.out.println("findMaxValue()");
    System.out.println(findMaxValue(integerList));
    System.out.println("findMaxValueOptional()");
    Optional<Integer> optionalInteger = findMaxValueOptional(integerList);
    if (optionalInteger.isPresent()) {
      System.out.println(optionalInteger.get());
    } else {
      System.out.println("Input list is empty");
    }
  }
}
