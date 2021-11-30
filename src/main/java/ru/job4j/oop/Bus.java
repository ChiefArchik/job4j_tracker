package ru.job4j.oop;

public class Bus implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " Движется по скоростным трассам.");
    }

    @Override
    public void sound() {
        System.out.println(getClass().getSimpleName()
                + " Звук работы двигателя внутреннего сгорания.");
    }
}