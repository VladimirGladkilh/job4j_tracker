package ru.job4j.sort;

import java.util.Arrays;

public class Machine {
    private final int[] COINS = {10, 5, 2, 1};

    public static void main(String[] args) {
        System.out.println(25 % 10);
    }
    public int[] change(int money, int price) {
        int[] rsl = new int[100];
        int size = 0;
            money -= price;
            for (int moneta: COINS){
                while (money - moneta >= 0) {
                    rsl[size] = moneta;
                    money -= moneta;
                    size ++;
                }
            }
        return Arrays.copyOf(rsl, size);
    }
}