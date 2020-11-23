package com.nouni.fibonacci.impl;

import com.nouni.fibonacci.FibonacciCalculator;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

//O(1)
public class ClosedFormFibonacci implements FibonacciCalculator {

    @Override
    public double calculate(Integer n) {
        if (n <= 1) return 1;
        double sqrt5 = sqrt(5);
        double terme1 = pow((1 + sqrt5) / 2, n + 1);
        double terme2 = pow((1 - sqrt5) / 2, n + 1);
        double res = (1 / sqrt5) * (terme1 - terme2);
        return res;
    }
}
