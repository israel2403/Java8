package com.learn.java.streams.numeric;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class NumericStreamsExample {

  public static Integer sumOfNumbers(final List<Integer> integerList) {
    return integerList.stream().reduce(0, (x, y) -> x + y);
  }
  public static int sumOfNumbersIntStream() {
    return IntStream.range(1, 7).sum();
  }

  public static void main(String[] args) {
    List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6);
    System.out.println("Sum of N Numbers : " + sumOfNumbers(integerList));
    System.out.println("Sum of N Numbers using IntStrea, : " + sumOfNumbersIntStream());
  }
}
