package ru.job4j.ex;

public class ElementNotFoundException extends Throwable {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {

        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                rsl = i;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException();
        }
        System.out.println(rsl);
        return rsl;
    }

    public static void main(String[] args) {
        try {
            indexOf(new String[]{"1", "3", "2"}, "4");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
