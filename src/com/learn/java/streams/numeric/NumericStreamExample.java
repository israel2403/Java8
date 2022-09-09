package com.learn.java.streams.numeric;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericStreamExample {

  public static List<Integer> mapToObj() {
    return IntStream
      .rangeClosed(1, 5)
      .mapToObj(
        i -> {
          return new Integer(i);
        }
      )
      .collect(Collectors.toList());
  }

  public static long mapToLong() {
    return IntStream.rangeClosed(1, 5).mapToLong(n -> n).sum();
  }

  public static double mapToDouble() {
    return IntStream.rangeClosed(1, 5).mapToDouble(n -> n).sum();
  }

  public static void main(String[] args) {
    System.out.println("mapToObj: " + mapToObj());
    System.out.println("mapToLong: " + mapToLong());
    System.out.println("mapToDouble: " + mapToDouble());
  }
}
