package br.com.mateusandrade.math;

public class SimpleMath {
  public Double sum(Double numberOne, Double numberTwo) {
    return numberOne + numberTwo;
  }
  public Double sub(Double numberOne, Double numberTwo) {
    return (numberOne) - (numberTwo);
  }

  public Double multi(Double numberOne, Double numberTwo) {
    return (numberOne) * (numberTwo);
  }

  public Double div(Double numberOne, Double numberTwo) {
    return (numberOne) / (numberTwo);
  }

  public Double mean(Double numberOne, Double numberTwo) {
    return (numberOne + numberTwo) / 2;
  }

  public Double sqrt(Double number) {
    return Math.sqrt(number);
  }
}
