package ru.job4j.oop;

public class Plane implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " Движется по воздушным трассам.");
    }

    @Override
    public void sound() {
        System.out.println(getClass().getSimpleName() + " Гул турбины реактивного двигателя.");
    }
}
