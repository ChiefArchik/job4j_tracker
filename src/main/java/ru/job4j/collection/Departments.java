package ru.job4j.collection;

import java.util.*;

/**
 * Класс описывает методы сортировки департаментов.
 * @author DMITRY ARTAMONOV
 * @version 1.0
 * @since 07.02.2022
 */
public class Departments {

    /**
     * Метод добавляющий пропущенные департаменты.
     * @param deps входящий список департаментов.
     * @return дополненный список департаментов.
     */
    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                start += el;
                tmp.add(start);
                start += "/";
            }
        }
        return new ArrayList<>(tmp);
    }

    /**
     * Метод выполняющий сортировку департаментов по возрастанию.
     * @param orgs сортируемый список департаментов.
     */
    public static void sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    /**
     * Метод выполняющий сортировку департаментов по убыванию.
     * @param orgs сортируемый список департаментов.
     */
    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }
}