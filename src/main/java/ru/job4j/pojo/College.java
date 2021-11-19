package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Чубанов Роман Игоревич");
        student.setGroup("26-21");
        student.setEntrance(new Date());

        System.out.println("Ф.И.О.: " + student.getFullName() + "," + " группа: "
                + student.getGroup() + ","
                + " Дата поступления: " + student.getEntrance());
    }
}
