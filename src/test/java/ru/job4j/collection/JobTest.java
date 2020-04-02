package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }
    @Test
    public void whenCompatorByName() {
        Comparator<Job> cmpNamePriority = new JobDescByName();
        int rsl = cmpNamePriority.compare(
                new Job("BBB", 1),
                new Job("AAA", 10)
        );
        assertThat(rsl, lessThan(0));
    }
    @Test
    public void whenCompatorByNameAsc() {
        Comparator<Job> cmpNamePriority = new JobAscByName();
        int rsl = cmpNamePriority.compare(
                new Job("AAA", 10),
                new Job("BBB", 1)
        );
        assertThat(rsl, lessThan(0));
    }
    @Test
    public void whenCompatorByPrority() {
        Comparator<Job> cmpNamePriority = new JobAscByPriority();
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }
    @Test
    public void whenCompatorByProrityDesc() {
        Comparator<Job> cmpNamePriority = new JobDescByPriority();
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 10),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }
    @Test
    public void whenCompatorAscByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("AAA", 1),
                new Job("AAA", 3)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorAscByNameAndDescByPrority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("AAA", 11),
                new Job("AAA", 3)
        );
        assertThat(rsl, lessThan(0));
    }
}
