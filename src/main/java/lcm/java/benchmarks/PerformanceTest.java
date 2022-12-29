package lcm.java.benchmarks;

import java.util.ArrayList;

public class PerformanceTest {
	
	public static void main(String[] args) {
		
		int TOTAL_STRINGS = 1000000;
		var randomStrings = new ArrayList<String>();
		for (int i = 0; i < TOTAL_STRINGS; i++) {
			randomStrings.add(Benchmark.generateRandomString() + "AAA" + Benchmark.generateRandomString() + "ZZZ" + Benchmark.generateRandomString()
				+ Benchmark.generateRandomString() + "AAA" + Benchmark.generateRandomString() + "ZZZ" + Benchmark.generateRandomString()
				+ Benchmark.generateRandomString() + "AAA" + Benchmark.generateRandomString() + "ZZZ" + Benchmark.generateRandomString());
		}
		
		var startingAfterTest = new StartingAfterBenchmark("StartingAfter", randomStrings);
		var startingWithTest = new StartingWithBenchmark("StartingWith", randomStrings);
		var endingBeforeTest = new EndingBeforeBenchmark("EndingBefore", randomStrings);
		var endingWithTest = new EndingWithBenchmark("EndingWith", randomStrings);

		startingAfterTest.runSingleOccurrence();
		startingWithTest.runSingleOccurrence();
		endingBeforeTest.runSingleOccurrence();
		endingWithTest.runSingleOccurrence();
		
		startingAfterTest.runSecondOccurrence();
		startingWithTest.runSecondOccurrence();
		endingBeforeTest.runSecondOccurrence();
		endingWithTest.runSecondOccurrence();
	}

}
