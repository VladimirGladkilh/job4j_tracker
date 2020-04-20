package ru.job4j.stream;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MatrixToListTest {
    @Test
    public void Then3to3Test() {
        Integer[][] intMatrix = new Integer[3][3];
        for (int i = 0; i < 3; i ++) {
            for (int j = 0; j < 3; j ++) {
                intMatrix[i][j] = i * j;
            }
        }

        List<Integer> integerList = MatrixToList.convert(intMatrix);
        List<Integer> validList = List.of(0, 0, 0, 0, 1, 2, 0, 2, 4);
        assertThat(integerList.equals(validList), is(true));
    }
    @Test
    public void Then2to2Test() {
        Integer[][] intMatrix = new Integer[2][2];
        for (int i = 1; i < 3; i ++) {
            for (int j = 1; j < 3; j ++) {
                intMatrix[i-1][j-1] = i * j;
            }
        }

        List<Integer> integerList = MatrixToList.convert(intMatrix);
        List<Integer> validList = List.of(1, 2, 2, 4);
        assertThat(integerList.equals(validList), is(true));
    }
}
