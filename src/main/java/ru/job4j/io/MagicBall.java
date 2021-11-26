package ru.job4j.io;

import java.util.Scanner;
import java.util.Random;

public class MagicBall {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Я великий Оракул. Что ты хочешь узнать?");
        String question = input.nextLine();
        int answer = new Random().nextInt(3);
        String oracleSay = "Может быть.";
        if (answer == 0) {
            oracleSay = "ДА.";
        } else if (answer == 1) {
            oracleSay = "НЕТ";
        }
        System.out.println(oracleSay);
    }
}
