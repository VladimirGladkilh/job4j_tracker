package ru.job4j.prof;

public class Surgeon extends Doctor {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Surgeon() {
        super();
    }

    public Surgeon(int age) {
        super();
        this.setAge(age);
    }
}
