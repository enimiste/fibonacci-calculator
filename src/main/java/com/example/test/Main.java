package com.example.test;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

import static com.example.test.FibonacciCalculator.Algo.*;
import static com.example.test.FibonacciCalculator.calculate;
import static java.lang.System.in;
import static java.lang.System.out;

public class Main {

    public static void main(String... args) {
        Scanner scanner = new Scanner(in);
        int n = 200;
        long res = 0L;
        out.println(Long.MAX_VALUE);
        show("Closed-Form : ", n, () -> calculate(n, CLOSED_FORM));
        show("Tail Recursive : ", n, () -> calculate(n, TAIL_RECURSIVE));
        show("Iterative : ", n, () -> calculate(n, ITERATIVE));
        show("Matrix : ", n, () -> calculate(n, MATRIX));
        show("Recursive : ", n, () -> calculate(n, RECURSIVE));
    }

    private static void show(String prefix, int n, Supplier<Long> fn) {
        StopWatch watch = new StopWatch();
        watch.start();
        Long res = fn.get();
        watch.stop();
        long timeMls = watch.getTime(TimeUnit.MILLISECONDS);
        long timeMcs = watch.getTime(TimeUnit.MICROSECONDS);
        out.println(prefix + " Fib(" + n + ")=" + res + "  in " + timeMls + "ms (" + timeMcs + " microsec)");
    }
}
