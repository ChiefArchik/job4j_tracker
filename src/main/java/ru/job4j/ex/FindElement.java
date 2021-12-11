package ru.job4j.ex;

public class FindElement {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {

        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                rsl = i;
                break;
            }
        }

        if (rsl == -1) {
            throw new ElementNotFoundException();
        }
        System.out.println(rsl);
        return rsl;
    }
}
