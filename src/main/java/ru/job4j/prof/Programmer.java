package ru.job4j.prof;

public class Programmer extends Engeneer{
    private String level;
    private String language;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
    public Programmer() {
        super();
        this.setCanBuild(false);
    }
    public Programmer(String name, String surName, String education, String level, String language) {
        super();
        this.setName(name);
        this.setSurName(surName);
        this.setEducation(education);
        this.setLanguage(language);
        this.setLevel(level);
        this.setCanBuild(false);
    }
}
