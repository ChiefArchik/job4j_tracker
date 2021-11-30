package ru.job4j.oop;

public class Train implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " Движется по железнодорожным путям.");
    }

    @Override
    public void sound() {
        System.out.println(getClass().getSimpleName() + " Стук металлических колес об рельсы.");
    }
}
