package com.example.test;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

import static com.example.test.FibonacciCalculator.Algo.*;
import static com.example.test.FibonacciCalculator.calculate;
import static java.lang.String.format;
import static java.lang.System.in;
import static java.lang.System.out;

public class Main {

    public static void main(String... args) {
        Scanner scanner = new Scanner(in);
        int n = 200;
        show("Closed-Form : ", n, () -> calculate(n, CLOSED_FORM));
        show("Tail Recursive : ", n, () -> calculate(n, TAIL_RECURSIVE));
        show("Iterative : ", n, () -> calculate(n, ITERATIVE));
        show("Matrix : ", n, () -> calculate(n, MATRIX));
        show("Recursive : ", n, () -> calculate(n, RECURSIVE));
    }

    private static void show(String prefix, int n, Supplier<Double> fn) {
        StopWatch watch = new StopWatch();
        watch.start();
        Double res = fn.get();
        watch.stop();
        long timeMls = watch.getTime(TimeUnit.MILLISECONDS);
        long timeMcs = watch.getTime(TimeUnit.MICROSECONDS);
        out.printf("%s Fib(%d)=%.0f in %d ms (%d microsec)%n", prefix, n, res, timeMls, timeMcs);
    }
}
