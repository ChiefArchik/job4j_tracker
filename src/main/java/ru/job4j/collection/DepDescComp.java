package ru.job4j.collection;

import java.util.Comparator;

/**
 * Класс определяющий работу компаратора для сортировки элементов по убыванию.
 * @author ARTAMONOV DMITRY
 * @version 1.0
 * @since 07.02.2022
 */
public class DepDescComp implements Comparator<String> {

    /**
     * Метод переопределяет логику компаратора для сортировки элементов по убыванию.
     * @param o1 первый параметр.
     * @param o2 второй параметр.
     * @return результат сравнения.
     */
    @Override
    public int compare(String o1, String o2) {
        int rsl = o2.split("/")[0].compareTo(o1.split("/")[0]);
        return (rsl == 0) ? o1.compareTo(o2) : rsl;
    }
}