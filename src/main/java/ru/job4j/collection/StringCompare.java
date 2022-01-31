package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        int less = Math.min(left.length(), right.length());
            for (int i = 0; i < less; i++) {
                char leftChar = left.charAt(i);
                char rightChar = right.charAt(i);
                rsl = Character.compare(leftChar, rightChar);
                if (rsl != 0) {
                    break;
                } else {
                    rsl = Integer.compare(left.length(), right.length());
                }
            }
        return rsl;
    }
}
