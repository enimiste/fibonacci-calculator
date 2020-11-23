package com.nouni.fibonacci.impl;

import com.nouni.fibonacci.FibonacciCalculator;

//O(Fn)
public class RecursiveFibonacci implements FibonacciCalculator {

    @Override
    public double calculate(Integer n) {
        if (n <= 1) return 1;
        return calculate(n - 1) + calculate(n - 2);
    }
}
