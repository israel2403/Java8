package com.learn.java.streams.parallel;

public class Sum {

  private int total;

  public Integer getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public void performSum(final int input) {
    this.total += input; 
  }
}
