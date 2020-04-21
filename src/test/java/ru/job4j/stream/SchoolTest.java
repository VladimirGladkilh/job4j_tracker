package ru.job4j.stream;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {
    @Test
    public void Test10AClass() {
        List<Student> tenClass = new ArrayList<Student>();
        for (int i = 0; i < 10; i++) {
            Student s = new Student();
            int score = i * 10;
            s.setScore(score);
            tenClass.add(s);
        }

        School school = new School();
        List<Student> tenA = school.collect(tenClass, student -> student.getScore() >= 70);
        assertThat(tenA.size(), is(3));
    }
    @Test
    public void Test10B_Class() {
        List<Student> tenClass = new ArrayList<Student>();
        for (int i = 0; i < 10; i++) {
            Student s = new Student();
            int score = i * 10;
            s.setScore(score);
            tenClass.add(s);
        }

        School school = new School();
        List<Student> tenA = school.collect(tenClass, student ->
                (student.getScore() >= 50 && student.getScore() < 70 ));

        assertThat(tenA.size(), is(2));
    }
    @Test
    public void Test10V_Class() {
        List<Student> tenClass = new ArrayList<Student>();
        for (int i = 0; i < 10; i++) {
            Student s = new Student();
            int score = i * 10;
            s.setScore(score);
            tenClass.add(s);
        }

        School school = new School();
        List<Student> tenA = school.collect(tenClass, student -> student.getScore() <50);

        assertThat(tenA.size(), is(5));
    }
    @Test
    public void TestStudentMap() {
        List<Student> studentList = Arrays.asList(new Student(100, "Petrov")
                , new Student(70, "Sidorov")
                , new Student(10, "Morozov")
                , new Student(46, "Sidorova"));
        Map<String, Student> hashStudent = new School().collectToMap(studentList);
        //упорядочим список и соберем МАР для проверки "руками"
        studentList.sort((o1, o2) -> o1.getFamilia().compareTo(o2.getFamilia()));
        //studentList.stream().collect(Collectors.toMap(Student::getFamilia, student -> student))
        Map<String, Student> validHash = new HashMap<String, Student>(
                Map.of(studentList.get(0).getFamilia(), studentList.get(0),
                        studentList.get(1).getFamilia(), studentList.get(1),
                        studentList.get(2).getFamilia(), studentList.get(2),
                        studentList.get(3).getFamilia(), studentList.get(3)
                )
        );


    for (Student st: studentList) {
            validHash.put(st.getFamilia(), st);
        }
        assertThat(hashStudent.equals(validHash), is(true));
    }

    @Test
    public void TestLevelOf() {
        List<Student> studentList = Arrays.asList(new Student(100, "Petrov")
                , null
                , new Student(70, "Sidorov")
                , new Student(10, "Morozov")
                , null
                , new Student(46, "Sidorova"));
        List<Student> hashStudent = new School().levelOf(studentList, 70);
        List<Student> validList = Arrays.asList(studentList.get(0), studentList.get(2) );
        assertThat(hashStudent.equals(validList), is(true));

        hashStudent.forEach(student -> System.out.println(student != null ? student.getFamilia() +" " + student.getScore(): "---"));

    }
}
