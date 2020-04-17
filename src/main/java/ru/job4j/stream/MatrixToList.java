package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixToList {
    public static void main(String[] args) {
        List<List<Integer>> matrix = List.of(
                List.of(1, 2),
                List.of(3, 4)
        );
        /*System.out.println(
                matrix.stream().flatMap(e -> e.stream()).collect(Collectors.toList())
        );*/

        Integer[][] intMatrix = new Integer[3][3];
        for (int i = 0; i < 3; i ++) {
            for (int j = 0; j < 3; j ++) {
                intMatrix[i][j] = i * j;
            }
        }

        List<Integer> integerList = Stream.of(intMatrix).flatMap(integers -> Stream.of(integers))
                .collect(Collectors.toList());
        System.out.println(integerList);

    }
}
