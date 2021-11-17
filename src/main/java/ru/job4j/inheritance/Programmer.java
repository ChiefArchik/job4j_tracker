package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private String computer;

    public Programmer(String name, String surname,
                      boolean education, String birthday,
                      boolean developer, String computer) {
        super(name, surname, education, birthday, developer);
        this.computer = computer;
    }

    public String develop(String programm) {
        return programm;
    }
}
