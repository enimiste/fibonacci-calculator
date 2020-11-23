package com.nouni.fibonacci.impl;

import Jama.Matrix;
import com.nouni.fibonacci.FibonacciCalculator;

//O(2^n)
public class MatrixFibonacci implements FibonacciCalculator {

    @Override
    public double calculate(Integer n) {
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
        return Fn.get(0, 0);
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
}
