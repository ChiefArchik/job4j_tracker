package ru.job4j.inheritance;

public class Builder extends Engineer {
    private String tool;

    public Builder(String name, String surname,
                      boolean education, String birthday,
                      boolean developer, String tool) {
        super(name, surname, education, birthday, developer);
        this.tool = tool;
    }

    public String plan(String build) {
        return build;
    }
}
