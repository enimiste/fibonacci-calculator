package com.nouni.fibonacci;

import com.nouni.fibonacci.impl.*;

public interface FibonacciCalculator {
    enum Algo {
        CLOSED_FORM,
        TAIL_RECURSIVE,
        ITERATIVE,
        MATRIX,
        RECURSIVE;

        static Algo[] withoutRecursive() {
            return new Algo[]{
                    CLOSED_FORM,
                    TAIL_RECURSIVE,
                    ITERATIVE,
                    MATRIX
            };
        }
    }

    double calculate(Integer n);

    static double calculate(Integer n, Algo algo) {
        return get(algo).calculate(n);
    }

    static FibonacciCalculator get(Algo algo) {
        switch (algo) {
            case RECURSIVE:
                return new RecursiveFibonacci();
            case TAIL_RECURSIVE:
                return new TailRecursiveFibonacci();
            case ITERATIVE:
                return new IterativeFibonacci();
            case MATRIX:
                return new MatrixFibonacci();
            case CLOSED_FORM:
                return new ClosedFormFibonacci();
            default:
                throw new IllegalArgumentException(algo + " algorithm not supported");
        }
    }
}

