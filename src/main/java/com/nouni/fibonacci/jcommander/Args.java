package com.nouni.fibonacci.jcommander;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.beust.jcommander.validators.PositiveInteger;
import com.nouni.fibonacci.FibonacciCalculator.Algo;
import com.nouni.fibonacci.jcommander.converters.FibonacciAlgoConverter;

import java.util.List;

import static java.util.Collections.emptyList;

public class Args {
    @Parameter(names = "-n", description = "The nth fibonacci number to calculate", validateWith = PositiveInteger.class, required = true)
    Integer n;

    @Parameter(names = {"-h", "--help"}, description = "Show usage", help = true)
    boolean showHelp;

    @Parameter(names = {"-a", "--algo"}, description = "Algorithm to be used for the calculation" +
            "(1: TAIL_RECURSIVE, 2: ITERATIVE, 3: MATRIX, 4: CLOSED_FORM, 5: RECURSIVE). " +
            "If you don't use this option the value from the alogs (1, 2, 3 and 4) will be shown. You can" +
            " use many values using this syntax : -a 1 2 4",
            variableArity = true,//you should disable acceptUnknownOptions in the JCommander object
            converter = FibonacciAlgoConverter.class)
    List<Algo> algos;

    public Integer getN() {
        return n;
    }

    public List<Algo> getAlgos() {
        return algos == null ? emptyList() : algos;
    }

    public boolean isShowHelp() {
        return showHelp;
    }

    public void setN(Integer n) {
        this.n = n;
    }

    public void setShowHelp(boolean showHelp) {
        this.showHelp = showHelp;
    }

    public void setAlgos(List<Algo> algos) {
        this.algos = algos;
    }
}
