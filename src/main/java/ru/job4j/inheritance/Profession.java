package ru.job4j.inheritance;

public class Profession {
    private String name;
    private String surname;
    private boolean education;
    private String birthday;

    public Profession(String name, String surname, boolean education, String birthday) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public  boolean getEducation() {
        return education;
    }

    public String getBirthday() {
        return birthday;
    }
}