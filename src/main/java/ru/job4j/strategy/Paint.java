package ru.job4j.strategy;

import java.util.Scanner;

public class Paint {

    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        System.out.println("Введите: 1, для вывода треугольника"
        + " или: 2 для вывода квадрата.");
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());
        Paint context = new Paint();
        if (input == 1) {
            context.draw(new Triangle());
        } else if (input == 2) {
            context.draw(new Square());
        } else {
            System.out.println("Ошибка ввода.");
        }

    }
}