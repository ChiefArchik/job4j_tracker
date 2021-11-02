package ru.job4j.oop;

public class DummyDic {

    public String engToRus(String eng) {
        String word = "unknown word";
        return word;
    }

    public static void main(String[] args) {
        DummyDic word = new DummyDic();
        String eng = word.engToRus("");
        System.out.println("Неизвестное слово - " + eng);
    }
}
