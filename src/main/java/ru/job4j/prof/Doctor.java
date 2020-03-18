package ru.job4j.prof;

public class Doctor extends Profession {
    private String profil;

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public Doctor() {
        super();
    }
    public Diagnose heal(Pacient pacient) {
        return pacient.getDiagnose();
    }
}
