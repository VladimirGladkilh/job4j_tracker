package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        char[] lChars = left.toCharArray();
        char[] rChars = right.toCharArray();
        int compare = 0;
        for (int i = 0; i < Math.min(lChars.length, rChars.length); i++) {
            compare = Character.compare(lChars[i], rChars[i]);
            if (compare != 0) {
                break;
            }
        }
        if (compare == 0) {
            compare = Integer.compare(lChars.length, rChars.length);
        }
        return compare;
    }
}