package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class DiapasonFunc {
     List<Double> diapason(int begin, int end, UnaryOperator<Double> oper) {
        List<Double> res= new ArrayList<Double>();
        while (begin < end) {
            res.add(oper.apply((double) begin));
            begin ++;
        }
        return res;
    }
}
