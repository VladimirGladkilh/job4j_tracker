package ru.job4j.stragery;

import java.util.StringJoiner;

public class Triangle implements Shape {
    @Override
    public String draw() {
        int size = 5;
        StringJoiner sb = new StringJoiner(System.lineSeparator());
        for (int i = 0; i <= size; i++) {
            String st = "";
            for (int j =0; j <= i; j++) {
                if (i ==0 || i == size || j == 0 || j == i) {
                    st += "X";
                } else {
                    st += " ";
                }
            }
            sb.add(st);
        }
        return sb.toString();
    }
}
