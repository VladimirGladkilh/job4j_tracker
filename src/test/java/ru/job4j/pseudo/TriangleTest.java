package ru.job4j.pseudo;

import org.junit.Test;
import ru.job4j.stragery.Paint;
import ru.job4j.stragery.Square;
import ru.job4j.stragery.Triangle;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.StringJoiner;

public class TriangleTest {
    @Test
    public void whenDrawTriangle() {
        String triangleString = new Triangle().draw();
        // проверяем результат вычисления
        assertThat(
                triangleString,
                is(
                        new StringJoiner(System.lineSeparator())
                                .add("X")
                                .add("XX")
                                .add("X X")
                                .add("X  X")
                                .add("X   X")
                                .add("XXXXXX")
                                .toString()
                )
        );
    }
}
