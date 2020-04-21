package ru.job4j.lambda;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
        return null;
        /*students.stream().flatMap( )
        .collect( // собираем карту
                Collectors.groupingBy(t -> t.key, // определяем группировку
                        Collector.of(
                                HashSet:: new, // аккумулятор.
                                (set, el) -> // как добавлять данные.
                                        (left, right) -> { left.addAll(right); return left; } // для агрегации.
                        )
                )
        );*/
    }
}