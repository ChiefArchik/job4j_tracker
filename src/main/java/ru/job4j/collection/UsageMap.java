package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("chief.archik@yandex.ru", "Dmitry Artamonov");
        map.put("chief.archik@rambler.ru", "Dmitry Artamonov");
        map.put("chief.archik@mail.ru", "Dmitry Artamonov");
        map.put("chief.archik@yandex.ru", "Dmitry Artamonov");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
