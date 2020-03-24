package ru.job4j.pseudo;

import org.junit.Test;
import ru.job4j.stragery.Square;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.StringJoiner;

public class SquareTest {


    @Test
    public void whenDrawSquare() {
        String squareString = new Square().draw();
        // проверяем результат вычисления
        assertThat(
               squareString,
                is(
                        new StringJoiner(System.lineSeparator())
                                .add("++++++")
                                .add("+    +")
                                .add("+    +")
                                .add("+    +")
                                .add("+    +")
                                .add("++++++")
                                .toString()
                )
        );
    }
}
