package com.nouni.fibonacci.impl;

import com.nouni.fibonacci.FibonacciCalculator;

//O(n)
public class TailRecursiveFibonacci implements FibonacciCalculator {

    @Override
    public double calculate(Integer n) {
        return calculateHelper(n, 1, 1);
    }

    private double calculateHelper(Integer n, double prev, double cur) {
        if (n <= 1) return cur;
        return calculateHelper(n - 1, cur, prev + cur);
    }
}
