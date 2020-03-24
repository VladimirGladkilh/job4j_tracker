package ru.job4j.ex;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FactTest {
    @Test(expected = IllegalArgumentException.class)
    public void whenMenshe0() {
        Fact.calc(-5);
    }
    @Test(expected = IllegalArgumentException.class)
    public void whenMenshe0_2(){
        int rsl = Fact.calc(-50);
        assertThat(rsl, is(1));
    }
}
