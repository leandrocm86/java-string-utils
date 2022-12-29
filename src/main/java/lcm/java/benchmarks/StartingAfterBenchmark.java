package lcm.java.benchmarks;

import java.util.ArrayList;
import java.util.List;

import lcm.java.S;

class StartingAfterBenchmark extends FunctionBenchmark<List<String>, List<String>> {

	StartingAfterBenchmark(String name, List<String> predefinedInput) {
		super(name, predefinedInput);
	}
	
	void runSingleOccurrence() {
		
		runFunction(strings -> {
			var output = new ArrayList<String>();
			strings.forEach(s -> {
				output.add(new S(s).startingAfter("AAA").toString());
			});
			return output;
		}, "S.startingAfter AAA (SINGLE OCCURRENCE)");
		
		runFunction(strings -> {
			var output = new ArrayList<String>();
			strings.forEach(s -> {
				output.add(s.substring(s.indexOf("AAA")+3));
			});
			return output;
		}, "INDEXOF AAA (SINGLE OCCURRENCE)");
		
		runFunction(strings -> {
			var output = new ArrayList<String>();
			strings.forEach(s -> {
				output.add(s.split("AAA", 2)[1]);
			});
			return output;
		}, "SPLIT AAA (SINGLE OCCURRENCE)");
	}
	
	void runSecondOccurrence() {
		
		runFunction(strings -> {
			var output = new ArrayList<String>();
			strings.forEach(s -> {
				output.add(new S(s).startingAfter("AAA", 2).toString());
			});
			return output;
		}, "S.startingAfter AAA (2nd OCCURRENCE)");
		
		runFunction(strings -> {
			var output = new ArrayList<String>();
			strings.forEach(s -> {
				output.add(s.substring(s.indexOf("AAA", s.indexOf("AAA")+3)+3));
			});
			return output;
		}, "INDEXOF AAA (2nd OCCURRENCE)");
		
		runFunction(strings -> {
			var output = new ArrayList<String>();
			strings.forEach(s -> {
				output.add(s.split("AAA", 3)[2]);
			});
			return output;
		}, "SPLIT AAA (2nd OCCURRENCE)");
	}
	
}
