package ru.job4j.lambda;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.util.Map;
import java.util.Set;

public class GroupTest {
    @Test
    public void checkGroup() {
        List<Student> students = asList(new Student("Jon", Set.of("Box", "Footbal")),
                new Student("Mike", Set.of("Swiming", "Hokkey", "Box")),
                new Student("Bill", Set.of("Footbal", "Sambo")));
        Map<String, Set<String>> grouping = Group.sections(students);
        Set<String> inBox = Set.of("Jon", "Mike");

        assertEquals(grouping.get("Box").equals(inBox), true);
    }
    @Test
    public void checkStud() {
        List<Student> students = asList(new Student("Jon", Set.of("Box", "Footbal")),
                new Student("Mike", Set.of("Swiming", "Hokkey", "Box")),
                new Student("Bill", Set.of("Footbal", "Sambo")));
        Map<String, Set<String>> grouping = Group.sections(students);
        Set<String> inBox = Set.of("Jon", "Mike");

        assertEquals(grouping.get("Footbal").equals(inBox), false);
    }
}
