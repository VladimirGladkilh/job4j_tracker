package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        int spichki = 11;
        System.out.println("Игра Спички");
        System.out.println("Возьмите от 1 до 3 спичек");
        Scanner input = new Scanner(System.in);
        boolean run = true;
        int playerNumber = 1;
        while (run) {
            int select = Integer.valueOf(input.nextLine());
            if (select > spichki) {
                System.out.println("Осталось спичек: " + spichki+".\nЗа один раз можно взять не более "+ Math.min(3, spichki)+" спичек");
            } else {
                if (select > 0 && select <= 3 && select <= spichki) {
                    spichki -= select;
                    System.out.println("Игрок " + playerNumber + " берет " + select + " спичек");
                    System.out.println("Осталось спичек: " + spichki);
                    if (spichki == 0) {
                        System.out.println("Игрок " + playerNumber + " победил");
                        run = false;
                    }
                    playerNumber = playerNumber == 1 ? 2 : 1;
                } else {
                    System.out.println("Неверное число");
                }
            }
        }
    }
}
