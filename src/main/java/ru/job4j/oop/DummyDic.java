package ru.job4j.oop;

public class DummyDic {

    public String engToRus(String eng) {
        return "unknown word" + eng;
    }

    public static void main(String[] args) {
        DummyDic word = new DummyDic();
        String eng = word.engToRus("");
        System.out.println(eng);
    }
}