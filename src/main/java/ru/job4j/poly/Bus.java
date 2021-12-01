package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("Автобус едет.");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Колличество пассажиров: " + count);
    }

    @Override
    public int fuel(int liters) {
        int literPrice = 50;
        return liters * literPrice;
    }
}
