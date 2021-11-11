package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int b) {
        return x - b;
    }

    public int divide(int c) {
        return x / c;
    }

    public int sumAllOperation(int z) {
        return sum(z) + multiply(z) + minus(z) + divide(z);
    }

    public static void main(String[] args) {
        int rslSum = Calculator.sum(9);
        System.out.println(rslSum);
        Calculator calculator = new Calculator();
        int rslMultiply = calculator.multiply(4);
        System.out.println(rslMultiply);
        int rslMinus = minus(3);
        System.out.println(rslMinus);
        int rslDivide = calculator.divide(5);
        System.out.println(rslDivide);
        int rslAll = calculator.sumAllOperation(5);
        System.out.println(rslAll);
    }
}
