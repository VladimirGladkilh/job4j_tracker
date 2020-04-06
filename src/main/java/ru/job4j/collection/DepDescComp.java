package ru.job4j.collection;
import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    /*public int compare(String o1, String o2) {
        int compare = 0;
        String[] o1String = o1.split("/");
        String[] o2String = o2.split("/");
        for (int i = 0; i < Math.min(o1String.length, o2String.length); i++) {
            if (i == 0) {
                compare = o2String[i].compareTo(o1String[i]);
            } else {
                compare = o1String[i].compareTo(o2String[i]);
            }
            if (compare != 0) {
                break;
            }
        }
        if (compare == 0) {
            compare = Integer.compare(o1String.length, o2String.length);
        }
        return compare;
    }*/
    public int compare(String o1, String o2) {
        String[] o1String = o1.split("/");
        String[] o2String = o2.split("/");
        int compare = o2String[0].compareTo(o1String[0]);
        if (compare == 0) {
            for (int i = 1; i < Math.min(o1String.length, o2String.length); i++) {
                compare = o1String[i].compareTo(o2String[i]);
                if (compare != 0) {
                    break;
                }
            }
        }
        if (compare == 0) {
            compare = Integer.compare(o1String.length, o2String.length);
        }
        return compare;
    }

    public static void main(String[] args) {
        String a="A";
        String b="B";
        System.out.println(a.compareTo(b));
    }
}