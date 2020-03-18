package ru.job4j.prof;

public class Builder extends Engeneer {
    private String profil;

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public String getProfil() {
        return profil;
    }

    public Builder() {
        super();
        this.setCanBuild(true);
    }

    public Builder(String professia) {
        super();
        this.setProfil(professia);
        this.setCanBuild(true);
    }

}
