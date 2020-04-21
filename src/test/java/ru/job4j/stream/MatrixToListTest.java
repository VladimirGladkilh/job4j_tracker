package ru.job4j.stream;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MatrixToListTest {
    @Test
    public void Then3to3Test() {
        Integer[][] intMatrix = {{0, 0, 0}, {0, 1, 2}, {0, 2, 4}};
        List<Integer> integerList = MatrixToList.convert(intMatrix);
        List<Integer> validList = List.of(0, 0, 0, 0, 1, 2, 0, 2, 4);
        assertThat(integerList.equals(validList), is(true));
    }
    @Test
    public void Then2to2Test() {
        Integer[][] intMatrix = {{1, 2}, {2, 4}};
        List<Integer> integerList = MatrixToList.convert(intMatrix);
        List<Integer> validList = List.of(1, 2, 2, 4);
        assertThat(integerList.equals(validList), is(true));
    }
}
