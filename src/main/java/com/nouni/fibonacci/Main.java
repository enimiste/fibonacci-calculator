package com.nouni.fibonacci;

import com.beust.jcommander.JCommander;
import com.nouni.fibonacci.FibonacciCalculator.Algo;
import com.nouni.fibonacci.jcommander.Args;
import com.nouni.fibonacci.utils.Utils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

import static com.nouni.fibonacci.FibonacciCalculator.calculate;
import static java.lang.System.err;
import static java.lang.System.out;

public class Main {

    public static void main(String... args) {
        Main main = new Main();
        Args arg = new Args();
        JCommander jcmd = JCommander.newBuilder()
                .addObject(arg)
                .programName("java -jar fibonacci-calculator.jar")
                .build();
        try {
            jcmd.parse(args);
            main.run(arg, jcmd);
        } catch (Exception e) {
            err.println(e.getMessage());
            jcmd.usage();
        }
    }

    public void run(Args arg, JCommander jcmd){
        if(arg.isShowHelp()) {
            jcmd.usage();
        } else {
            List<Algo> algos = arg.getAlgos();
            if(arg.getAlgos().isEmpty())
                algos = Arrays.asList(Algo.withoutRecursive());

            algos.forEach(algo -> {
                show(algo.name(), arg.getN(), () -> calculate(arg.getN(), algo));
            });
        }
    }

    private static void show(String prefix, int n, Supplier<Double> fn) {
        StopWatch watch = new StopWatch();
        watch.start();
        Double res = fn.get();
        watch.stop();
        long timeMls = watch.getTime(TimeUnit.MILLISECONDS);
        long timeMcs = watch.getTime(TimeUnit.MICROSECONDS);
        out.printf("%s \t: Fib(%d)=%.0f in %d ms (%d microsec)%n",
                Utils.ucWords(prefix.replace("_", " ").toLowerCase()),
                n,
                res,
                timeMls,
                timeMcs);
    }
}
