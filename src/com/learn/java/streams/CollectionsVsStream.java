package com.learn.java.streams;

import java.util.ArrayList;

public class CollectionsVsStream {

  public static void main(String[] args) {
    ArrayList<String> names = new ArrayList<>();
    names.add("adam");
    names.add("jim");
    names.add("jenny");

    names.remove(0);
    System.out.println(names);

    
  }
}
