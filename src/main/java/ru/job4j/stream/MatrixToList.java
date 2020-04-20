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


        Integer[][] intMatrix = new Integer[3][3];
        for (int i = 0; i < 3; i ++) {
            for (int j = 0; j < 3; j ++) {
                intMatrix[i][j] = i * j;
            }
        }

        List<Integer> integerList = convert(intMatrix);
        System.out.println(integerList);

    }
    public static List<Integer> convert(Integer[][] intMatrix) {
        List<Integer> integerList = Stream.of(intMatrix).flatMap(integers -> Stream.of(integers))
                .collect(Collectors.toList());
        return integerList;
    }
}
