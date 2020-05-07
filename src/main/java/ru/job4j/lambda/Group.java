package ru.job4j.lambda;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Arrays.copyOf;

public class Group {
    static class Holder {
        String key, value;

        Holder(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
    public static Map<String, Set<String>> sections(List<Student> students) {

        Set<Holder> hs = new HashSet<Holder>();
        Map map = students.stream()
                .flatMap(student -> {
                    student.getUnits().forEach((u)-> hs.add(new Holder(u, student.getName())) );
                    return hs.stream();}
                )
                .collect(Collectors.groupingBy(t->t.key,
                        Collector.of(
                                HashSet<String>::new, // аккумулятор.
                                (set, el) -> set.add(el.value),// как добавлять данные.
                                (left, right) -> { left.addAll(right); return left; } // для агрегации.
                        )
                        )
                );
        return map;
    }

   /* public static void main(String[] args) {
    List<Student> students = asList(new Student("Jon", Set.of("Box", "Footbal")),
            new Student("Mike", Set.of("Swiming", "Hokkey", "Box")),
            new Student("Bill", Set.of("Footbal", "Sambo")));
        Set<Holder> hs = new HashSet<Holder>();
        Map map = students.stream()
                .flatMap(student -> {
                    student.getUnits().forEach((u)-> hs.add(new Holder(u, student.getName())) );
                    return hs.stream();}
                )
                .collect(Collectors.groupingBy(t->t.key,
                        Collector.of(
                                HashSet::new, // аккумулятор.
                                (set, el) -> set.add(el),// как добавлять данные.
                                (left, right) -> { left.addAll(right); return left; } // для агрегации.
                        )
                        )
                );

        Map<String, Set<String>> grouping = Group.sections(students);
        Set<String> inBox = Set.of("Jon", "Mike");
        for (String gr: grouping.keySet()
             ) {
            System.out.println(gr);
            for (String val:grouping.get(gr)
                 ) {
                System.out.println(val);
            }
        }

    }*/


}