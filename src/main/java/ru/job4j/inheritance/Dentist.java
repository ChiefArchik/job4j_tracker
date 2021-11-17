package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private String drill;

    public Dentist(String name, String surname,
                   boolean education, String birthday,
                   boolean whiteRobe, String drill) {
        super(name, surname, education, birthday, whiteRobe);
        this.drill = drill;
    }

    public String remote(String teeth) {
        return teeth;
    }
}
