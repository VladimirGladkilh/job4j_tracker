package ru.job4j.prof;

public class Pacient {
    private String fio;
    private Diagnose diagnose;

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Diagnose getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(Diagnose diagnose) {
        this.diagnose = diagnose;
    }

    public Pacient() {
        super();
    }

    public Pacient(String fio, Diagnose diagnose) {
        super();
        this.setFio(fio);
        this.setDiagnose(diagnose);
    }
}
