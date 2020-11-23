package com.nouni.fibonacci.jcommander.converters;

import com.beust.jcommander.IStringConverter;
import com.nouni.fibonacci.FibonacciCalculator;

import static com.nouni.fibonacci.FibonacciCalculator.Algo.*;

public class FibonacciAlgoConverter implements IStringConverter<FibonacciCalculator.Algo> {
    @Override
    public FibonacciCalculator.Algo convert(String s) {
        int v = Integer.parseInt(s);
        switch (v) {
            case 1:
                return TAIL_RECURSIVE;
            case 2:
                return ITERATIVE;
            case 3:
                return MATRIX;
            case 4:
                return CLOSED_FORM;
            case 5:
                return RECURSIVE;
            default:
                throw new IllegalArgumentException("The -algo value not valid");
        }
    }
}
