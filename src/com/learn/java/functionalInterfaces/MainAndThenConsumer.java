package com.learn.java.functionalInterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class MainAndThenConsumer {

  public static void main(String[] args) {
    // Consumer to multyply 2 to every integer of a list
    Consumer<List<Integer>> mConsumer = integerList -> {
      for (int i = 0; i < integerList.size(); i++) {
        integerList.set(i, 2 * integerList.get(i));
      }
    };

    // Consumer to display a list of Integers
    Consumer<List<Integer>> displayIntegerList = integerList -> {
      integerList
        .stream()
        .forEach(integer -> System.out.println(integer + " "));
    };

    List<Integer> integerList = Arrays.asList(2, 1, 3);

    // Using then
    mConsumer.andThen(displayIntegerList).accept(integerList);
  }
}
