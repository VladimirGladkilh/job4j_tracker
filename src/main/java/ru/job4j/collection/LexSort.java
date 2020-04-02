package ru.job4j.collection;
import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int compare = left.compareTo(right);
        String lChar = left.split(". ")[0];
        try {
            int lNum = Integer.parseInt(left.split(". ")[0]);
            int rNum = Integer.parseInt(right.split(". ")[0]);
            compare = Integer.compare(lNum, rNum);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return compare;
    }
}