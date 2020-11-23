package com.nouni.fibonacci.impl;

import com.nouni.fibonacci.FibonacciCalculator;

//O(n)
public class IterativeFibonacci implements FibonacciCalculator {

    @Override
    public double calculate(Integer n) {
        double prev = 1;
        double cur = 1;
        while (n > 1) {
            double tmp = cur;
            cur = prev + cur;
            prev = tmp;
            n--;
        }
        return cur;
    }
}
