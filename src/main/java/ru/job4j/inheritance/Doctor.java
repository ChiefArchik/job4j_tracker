package ru.job4j.inheritance;

public class Doctor extends Profession {
    private boolean whiteRobe;

    public Doctor(String name, String surname, boolean education,
                  String birthday, boolean whiteRobe) {
        super(name, surname, education, birthday);
        this.whiteRobe = whiteRobe;
    }

    public boolean heal(boolean health) {
        return health;
    }
}
