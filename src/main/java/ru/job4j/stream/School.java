package ru.job4j.stream;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class School {
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        List<Student> sortStudents = students.stream().filter(predict)
                .collect(Collectors.toList());
        return sortStudents;
    }
    public Map<String, Student> collectToMap(List<Student> students) {
        Map mapStudent = students.stream().collect(
                Collectors.toMap(
                        student -> student.getFamilia(),
                        student -> student, BinaryOperator.maxBy((o1, o2) -> Integer.compare(o1.getScore(), o2.getScore())))
        );
        return mapStudent;
    }

    public List<Student> levelOf(List<Student> students, int bound) {

        List<Student> sortStudents = students.stream()
                .flatMap(Stream :: ofNullable)
                .sorted((o1, o2) -> Integer.compare(o2.getScore(), o1.getScore()))
                .takeWhile(student -> student.getScore() >= bound)
                .sorted()
                .collect(Collectors.toList());
        return sortStudents;
    }
}
