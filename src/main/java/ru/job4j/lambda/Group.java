package ru.job4j.lambda;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Group {
    static class Holder {
        String key, value;

        Holder(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
    public static Map<String, Set<String>> sections(List<Student> students) {
        Map map = students.stream()
                .flatMap(student ->  student.getUnits().stream()
                        .map(s->new Holder(s, student.getName()))
                )
                .collect(Collectors.groupingBy(t->t.key,
                        Collector.of(
                                HashSet::new,
                                (set, el) -> set.add(el.value),
                                (left, right) -> { left.addAll(right); return left; }
                        )
                        )
                );
        return map;
    }

}