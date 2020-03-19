package ru.job4j.pojo;

public class Book {
    private String name;
    private int pagesCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(int pagesCount) {
        this.pagesCount = pagesCount;
    }
    public Book(String name, int pagesCount) {
        this.setName(name);
        this.setPagesCount(pagesCount);
    }
}
