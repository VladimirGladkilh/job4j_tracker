package ru.job4j.oop;

public class Student {
    public void music() {
        System.out.println("https://yandex.ru/video/search?text=%D0%BA%D1%83%D0%B7%D0%BD%D0%B5%D1%87%D0%B8%D0%BA%20%D0%BD%D0%B0%20%D0%B1%D0%B0%D1%8F%D0%BD%D0%B5&path=wizard&parent-reqid=1584425443567209-998457936766809941000140-vla1-1993&noreask=1&filmId=13537551458109022262");
    }
    public void song() {
        System.out.println("I believe I can fly");
    }
    public static void main(String[] args) {
        Student petya = new Student();
        petya.music();
        petya.music();
        petya.music();
        petya.song();
        petya.song();
        petya.song();
    }
}
