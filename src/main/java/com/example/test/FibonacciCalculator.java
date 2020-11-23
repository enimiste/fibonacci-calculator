package com.example.test;

import Jama.Matrix;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public interface FibonacciCalculator {
    enum Algo {
        RECURSIVE, TAIL_RECURSIVE, ITERATIVE, MATRIX, CLOSED_FORM;
    }

    Long calculate(Integer n);

    static Long calculate(Integer n, Algo algo) {
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

//O(Fn)
class RecursiveFibonacci implements FibonacciCalculator {

    @Override
    public Long calculate(Integer n) {
        if (n <= 1) return 1L;
        return calculate(n - 1) + calculate(n - 2);
    }
}

//O(n)
class TailRecursiveFibonacci implements FibonacciCalculator {

    @Override
    public Long calculate(Integer n) {
        return calculateHelper(n, 1, 1);
    }

    private Long calculateHelper(Integer n, long prev, long cur) {
        if (n <= 1) return cur;
        return calculateHelper(n - 1, cur, prev + cur);
    }
}

//O(n)
class IterativeFibonacci implements FibonacciCalculator {

    @Override
    public Long calculate(Integer n) {
        long prev = 1;
        long cur = 1;
        while (n > 1) {
            long tmp = cur;
            cur = prev + cur;
            prev = tmp;
            n--;
        }
        return cur;
    }
}

//O(2^n)
class MatrixFibonacci implements FibonacciCalculator {

    @Override
    public Long calculate(Integer n) {
        if (n <= 1) return 1L;
        Matrix A = new Matrix(new double[][]{
                {1, 1},
                {1, 0}
        });

        Matrix An = matrixPower(A, n);
        Matrix b = new Matrix(new double[][]{
                {1},
                {0}
        });

        Matrix Fn = An.times(b);
        return (long) Fn.get(0, 0);
    }

    private Matrix matrixPower(Matrix A, Integer n) {
        if (n == 0)
            return Matrix.identity(A.getRowDimension(), A.getColumnDimension());

        Matrix R = A.copy();
        while (n > 1) {
            R = R.times(A);
            n--;
        }
        return R;
    }

    private void printMatrix(Matrix M) {
        M.print(4, 0);
    }
}

//O(1)
class ClosedFormFibonacci implements FibonacciCalculator {

    @Override
    public Long calculate(Integer n) {
        if (n <= 1) return 1L;
        double sqrt5 = sqrt(5);
        double terme1 = pow((1 + sqrt5) / 2, n + 1);
        double terme2 = pow((1 - sqrt5) / 2, n + 1);
        double res = (1 / sqrt5) * (terme1 - terme2);
        return (long) res;
    }
}