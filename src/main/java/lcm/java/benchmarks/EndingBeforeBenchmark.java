package lcm.java.benchmarks;

import java.util.ArrayList;
import java.util.List;

import lcm.java.S;

class EndingBeforeBenchmark extends FunctionBenchmark<List<String>, List<String>> {

	EndingBeforeBenchmark(String name, List<String> predefinedInput) {
		super(name, predefinedInput);
	}
	
	void runSingleOccurrence() {
		
		runFunction(strings -> {
			var output = new ArrayList<String>();
			strings.forEach(s -> {
				output.add(new S(s).endingBefore("ZZZ").toString());
			});
			return output;
		}, "S.endingBefore ZZZ (SINGLE OCCURRENCE)");
		
		runFunction(strings -> {
			var output = new ArrayList<String>();
			strings.forEach(s -> {
				output.add(s.substring(0, s.indexOf("ZZZ")));
			});
			return output;
		}, "INDEXOF ZZZ (SINGLE OCCURRENCE)");
		
		runFunction(strings -> {
			var output = new ArrayList<String>();
			strings.forEach(s -> {
				output.add(s.split("ZZZ", 2)[0]);
			});
			return output;
		}, "SPLIT ZZZ (SINGLE OCCURRENCE)");
	}
	
	void runSecondOccurrence() {
		
		runFunction(strings -> {
			var output = new ArrayList<String>();
			strings.forEach(s -> {
				output.add(new S(s).endingBefore("ZZZ", 2).toString());
			});
			return output;
		}, "S.endingBefore ZZZ (2nd OCCURRENCE)");
		
		runFunction(strings -> {
			var output = new ArrayList<String>();
			strings.forEach(s -> {
				output.add(s.substring(0, s.indexOf("ZZZ", s.indexOf("ZZZ")+3)));
			});
			return output;
		}, "INDEXOF ZZZ (2nd OCCURRENCE)");
		
		runFunction(strings -> {
			var output = new ArrayList<String>();
			strings.forEach(s -> {
				String[] split = s.split("ZZZ", 3);
				output.add(split[0]+"ZZZ"+split[1]);
			});
			return output;
		}, "SPLIT ZZZ (2nd OCCURRENCE)");
	}
	
}
