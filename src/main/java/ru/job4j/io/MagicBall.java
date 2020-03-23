package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        int answer = new Random().nextInt(3);
        String otvet = "Может быть";
        if (answer < 2) {
            otvet = answer == 0 ? "Да": "Нет";
        }
        System.out.println(otvet);
    }
}
