package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Ивано Иван Иванович");
        student.setGruppa("Base");
        student.setDateBegin(new Date());
        System.out.println(student.getFio() + " группа № - " + student.getGruppa() + " Дата поступления: " + student.getDateBegin());

    }
}
