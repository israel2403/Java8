package com.learn.java.functionalInterfaces;

public class FunctionExample1 {

    public static String performConcant(String str) {
        return FunctionExample.addSomeString.apply(str);
    }

    public static void main(String[] args) {
        String result = performConcant("Hello");
        System.out.println("Result : " + result);
    }
}
