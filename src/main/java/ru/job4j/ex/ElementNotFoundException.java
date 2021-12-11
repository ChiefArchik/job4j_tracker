package ru.job4j.ex;

public class ElementNotFoundException extends Throwable {

    public static void main(String[] args) {
        try {
            FindElement.indexOf(new String[]{"1", "3", "2"}, "4");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
