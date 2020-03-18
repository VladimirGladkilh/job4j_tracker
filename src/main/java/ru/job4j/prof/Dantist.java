package ru.job4j.prof;

import java.util.Date;

public class Dantist extends Doctor{
    private String subSpec;

    public String getSubSpec() {
        return subSpec;
    }

    public void setSubSpec(String subSpec) {
        this.subSpec = subSpec;
    }

    public Dantist() {
        super();
    }
    public Dantist(String name, String surName, String profil, String education, Date birtDate) {
        super();
        this.setName(name);
        this.setSurName(surName);
        this.setProfil(profil);
        this.setBirthDay(birtDate);
        this.setEducation(education);
    }
}
