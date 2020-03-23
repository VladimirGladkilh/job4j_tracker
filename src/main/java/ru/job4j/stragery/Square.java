package ru.job4j.stragery;

import java.util.StringJoiner;

public class Square implements Shape {
    @Override
    public String draw() {
        int size = 5;
        StringJoiner sb = new StringJoiner(System.lineSeparator());
        for (int i = 0; i <= size; i++) {
            String st = "";
            for (int j =0; j <= size; j++) {
                if (i ==0 || i == size || j == 0 || j == size) {
                    st += "+";
                } else {
                    st += " ";
                }
            }
            sb.add(st);
        }
        return sb.toString();
    }
}
