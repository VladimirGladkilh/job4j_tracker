package ru.job4j.stream;

public class Student implements Comparable {
    private int score;

    public Student(int score, String familia) {
        this.score = score;
        this.familia = familia;
    }

    public Student() {
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    private String familia;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(Object o) {
        return this.getFamilia().compareTo(((Student) o).getFamilia());
    }
}
