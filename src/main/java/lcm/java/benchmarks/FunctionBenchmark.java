package lcm.java.benchmarks;

import java.util.function.Function;

class FunctionBenchmark<I, O> {

    String name;
    I predefinedInput;
    I lastInput = null;
    O lastOutput = null;

    FunctionBenchmark(String name) {
        this.name = name;
    }

    FunctionBenchmark(String name, I predefinedInput) {
        this.name = name;
        this.predefinedInput = predefinedInput;
    }

    void runFunction(I input, Function<I, O> function, String title) {
        Benchmark.printSeparator();
        System.gc();
        long start = System.currentTimeMillis();
        var output = function.apply(input);
        System.out.println(String.format("[%s] Time for %s: %dms", name, title, System.currentTimeMillis() - start));
        System.out.println("Input: " + printInput(input));
        System.out.println("Output: " + printOutput(output));
        addInput(input);
        addOutput(output);
    }

    void runFunction(Function<I, O> function, String title) {
        runFunction(predefinedInput, function, title);
    }

    String printOutput(O o) {
        return Benchmark.printObject(o);
    }

    String printInput(I i) {
        return Benchmark.printObject(i);
    }

    void addOutput(O output) {
        if (lastOutput != null)
            if (!equalOutputs(lastOutput, output)) {
                System.out.println("===== ERROR: DIFFERENT OUTPUTS! =====");
                System.out.println("PREVIOUS: " + printOutput(lastOutput));
                System.out.println("NOW: " + printOutput(output));
                throw new AssertionError("Output not like the previous!");
            }
        lastOutput = output;
    }

    void addInput(I input) {
        if (lastInput != null)
            if (!equalInputs(lastInput, input)) {
                System.out.println("===== ERROR: INPUTS WERE DIFFERENT AFTER FUNCTION! =====");
                System.out.println("PREVIOUS: " + printInput(lastInput));
                System.out.println("NOW: " + printInput(input));
                throw new AssertionError("Input didn't end like the previous!");
            }
        lastInput = input;
    }

    boolean equalOutputs(O o1, O o2) {
        return Benchmark.equalObjects(o1, o2);
    }

    boolean equalInputs(I i1, I i2) {
        return Benchmark.equalObjects(i1, i2);
    }

}
