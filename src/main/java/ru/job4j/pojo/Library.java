package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book first = new Book("My-My", 100);
        Book second = new Book("Clean code", 1);
        Book third = new Book("War and Peace", 100500);
        Book four = new Book("Java for kids", 666);

        Book[] myLib = new Book[4];
        myLib[0] = first;
        myLib[1] = second;
        myLib[2] = third;
        myLib[3] = four;
        for (int index = 0; index < myLib.length; index++) {
            Book bk = myLib[index];
            System.out.println(bk.getName() + " - " + bk.getPagesCount());
        }
        System.out.println("Replace 1 and 3");
        Book tmp = myLib[1];
        myLib[1] = myLib[3];
        myLib[3] = tmp;
        for (int index = 0; index < myLib.length; index++) {
            Book bk = myLib[index];
            System.out.println(bk.getName() + " - " + bk.getPagesCount());
        }
        System.out.println("Print Clean code");
        for (int index = 0; index < myLib.length; index++) {
            Book bk = myLib[index];
            if (bk.getName().equals("Clean code")) {
                System.out.println(bk.getName() + " - " + bk.getPagesCount());
            }
        }

    }
}
