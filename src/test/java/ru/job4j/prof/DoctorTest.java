package ru.job4j.prof;

import org.junit.Test;
import ru.job4j.prof.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DoctorTest {
    @Test
    public void DoctrorCreate() {
        Pacient pacient = new Pacient();
        Diagnose diagnose = new Diagnose("Diarea");
        pacient.setFio("Иванов Иван Иванович");
        pacient.setDiagnose(diagnose);
        Doctor doctor = new Doctor();
        doctor.setName("Gennadii");
        doctor.setSurName("Malahov");
        doctor.setProfil("Terapevt");
        doctor.setEducation("PTY");
        assertThat(doctor.heal(pacient).getName(), is("Diarea"));
        System.out.println(doctor.getName());
    }

    @Test
    public void DoctrorCreate2() {
        Doctor doctor = new Doctor();
        doctor.setName("Gennadii");
        doctor.setSurName("Malahov");
        doctor.setProfil("Terapevt");
        doctor.setEducation("PTY");
        Diagnose diagnose1 = new Diagnose();
        diagnose1.setName("Ebola");
        Pacient pacient2 = new Pacient("Vasilii Alibababevich", diagnose1 );
        assertThat(doctor.heal(pacient2).getName(), is("Ebola"));
    }

    @Test
    public void CreateDantist() {
        String stringDate = "03/08/1995";
        DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        Date bd = null;
        try {
            bd = date.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Dantist dantist = new Dantist("Иван", "Петров", "Ортодонт", "ФизТех", bd);
        dantist.setSubSpec("Высшая категория");
        Pacient pacient = new Pacient("Макар Петрович", new Diagnose("Пульпит"));
        assertThat(dantist.heal(pacient).getName(), is("Пульпит"));
    }
    @Test
    public void CreateSurgeon() {
        Surgeon surgeon = new Surgeon(55);
        assertThat(surgeon.getAge(), is(55));
    }
    @Test
    public  void CreateProgrammmer() {
        Programmer programmer = new Programmer();
        programmer.setName("Вася");
        programmer.setLevel("middle");
        programmer.setLanguage("C++");
        assertThat(programmer.getName(), is("Вася"));
    }
    @Test
    public  void  CreateProgCanBuild() {
        Programmer programmer = new Programmer();
        assertThat(programmer.getCanBuild(), is(false));
    }

    @Test
    public void CreateBuilder() {
        Builder builder = new Builder("Каменщик");
        builder.setName("Коля");
        assertThat(builder.getCanBuild(), is(true));

    }
}
