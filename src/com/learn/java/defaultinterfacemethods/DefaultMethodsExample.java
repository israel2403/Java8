package com.learn.java.defaultinterfacemethods;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DefaultMethodsExample {

  public static void main(String[] args) {
    /* Sort the list names in alphabetical order */
    List<String> stringList = Arrays.asList(
      "Adam",
      "Jenny",
      "Alex",
      "Dan",
      "Mike",
      "Eric"
    );

    Collections.sort(stringList);
    /* Prior Java 8 */
    System.out.println("Sorted list using Collections.Sort(E) " + stringList);
    
    /* Java 8 */
    
    stringList.sort(Comparator.naturalOrder());
    System.out.println("Sorted list using Comparator.rev() " + stringList);
    stringList.sort(Comparator.reverseOrder());
    System.out.println("Sorted list using Comparator.reverseOrder() " + stringList);
  }
}
