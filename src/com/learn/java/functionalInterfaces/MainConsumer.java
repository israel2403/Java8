package com.learn.java.functionalInterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class MainConsumer {

  public static void main(String[] args) {
    // Consumer to display a number
    Consumer<Integer> display = integer -> System.out.println(integer);
    // Implement display using accept
    display.accept(10);

    // Consumer to multply 2 toevery integer of a list
    Consumer<List<Integer>> modify = integerList -> {
      for (int i = 0; i < integerList.size(); i++) {
        integerList.set(i, 2 * integerList.get(i));
      }
    };

    // Consumer to display a list of numbers
    Consumer<List<Integer>> displayIntegers = listIntgers ->
      listIntgers
        .stream()
        .forEach(integer -> System.out.println(integer + " "));

    List<Integer> lIntegers = Arrays.asList(2, 1, 3);
    modify.accept(lIntegers);
    displayIntegers.accept(lIntegers);
  }
}
