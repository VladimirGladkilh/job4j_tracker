package ru.job4j.ex;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class CountTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenStartGreaterThenFinish() {
        Count.add(10, 2);
    }
    @Test(expected = IllegalArgumentException.class)
    public void when0to2then3() {
        int rsl = Count.add(10, 3);
        assertThat(rsl, is(3));
    }
    @Test
    public void whenStartGreaterThenFinish2() {
        try {
            Count.add(10, 2);
            fail();
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("Start should be less then finish."));
        }
    }
}