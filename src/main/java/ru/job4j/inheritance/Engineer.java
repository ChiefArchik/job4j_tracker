package ru.job4j.inheritance;

public class Engineer extends Profession {
    private boolean developer;

    public Engineer(String name, String surname, boolean education,
                    String birthday, boolean developer) {
        super(name, surname, education, birthday);
        this.developer = developer;
    }

    public int calculate(int result) {
        return result;
    }
}
