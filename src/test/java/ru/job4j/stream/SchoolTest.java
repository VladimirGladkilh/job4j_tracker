package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
        //tenA.forEach(System.out::println);
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
        //tenA.forEach(System.out::println);
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
        //tenA.forEach(System.out::println);
        assertThat(tenA.size(), is(5));
    }
}
