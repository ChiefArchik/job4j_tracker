package ru.job4j.inheritance;

public class Surgeon extends  Doctor {
    private String scalpel;

    public Surgeon(String name, String surname,
                   boolean education, String birthday,
                   boolean whiteRobe, String scalpel) {
        super(name, surname, education, birthday, whiteRobe);
        this.scalpel = scalpel;
    }

    public String cut(String tumor) {
        return tumor;
    }
}
