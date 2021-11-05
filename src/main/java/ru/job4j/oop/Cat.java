package ru.job4j.oop;

public class Cat {

    private String food;

    private String name;

    public void show() {
        System.out.println(this.name + " ate a " + this.food);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public void giveNick(String nick) {
        this.name = nick;
    }

    public static void main(String[] args) {
        System.out.println("There are gav`s food.");
        ru.job4j.oop.Cat gav = new ru.job4j.oop.Cat();
        gav.eat("kotleta");
        gav.giveNick("Gav");
        gav.show();
        System.out.println("There are black`s food.");
        ru.job4j.oop.Cat black = new ru.job4j.oop.Cat();
        black.eat("fish");
        black.giveNick("Black");
        black.show();
    }
}

