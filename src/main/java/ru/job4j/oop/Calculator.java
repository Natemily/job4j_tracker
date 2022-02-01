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
        return b - x;
    }

    public int divine(int c) {
        return c / x;
    }

    public int sumAllOperation(int s) {
        return sum(s) + multiply(s) + minus(s) + divine(s);
    }

    public static void main(String[] args) {
        int result = sum(10);
        System.out.println(result);

        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(5);
        System.out.println(rsl);

        System.out.println("Вычитание: " + minus(15));
        System.out.println("Деление: " + calculator.divine(15));
        System.out.println("Сумма: " + calculator.sumAllOperation(20));
    }
}