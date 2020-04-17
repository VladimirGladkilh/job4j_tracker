package ru.job4j.stream;

import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        List<Student> sortStudents = students.stream().filter(predict)
                .collect(Collectors.toList());
        return sortStudents;
    }
    public HashMap<String, Student> collectToMap(List<Student> students) {
        HashMap mapStudent = (HashMap) students.stream().distinct().collect(
                Collectors.toMap(
                        student -> student.getFamilia(),
                        student -> student)
        );
        return mapStudent;
    }
}
