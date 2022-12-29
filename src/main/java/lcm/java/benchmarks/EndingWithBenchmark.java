package lcm.java.benchmarks;

import java.util.ArrayList;
import java.util.List;

import lcm.java.S;

class EndingWithBenchmark extends FunctionBenchmark<List<String>, List<String>> {

	EndingWithBenchmark(String name, List<String> predefinedInput) {
		super(name, predefinedInput);
	}
	
	void runSingleOccurrence() {

		lastOutput = null;
		
		runFunction(strings -> {
			var output = new ArrayList<String>();
			strings.forEach(s ->
				output.add(new S(s).endingWith("ZZZ").toString())
			);
			return output;
		}, "S.endingWith ZZZ (SINGLE OCCURRENCE)");
		
		runFunction(strings -> {
			var output = new ArrayList<String>();
			strings.forEach(s ->
				output.add(s.substring(0, s.indexOf("ZZZ")+3))
			);
			return output;
		}, "INDEXOF ZZZ (SINGLE OCCURRENCE)");
		
		runFunction(strings -> {
			var output = new ArrayList<String>();
			strings.forEach(s ->
				output.add(s.split("ZZZ", 2)[0]+"ZZZ")
			);
			return output;
		}, "SPLIT ZZZ (SINGLE OCCURRENCE)");
	}
	
	void runSecondOccurrence() {

		lastOutput = null;
		
		runFunction(strings -> {
			var output = new ArrayList<String>();
			strings.forEach(s ->
				output.add(new S(s).endingWith("ZZZ", 2).toString())
			);
			return output;
		}, "S.endingWith ZZZ (2nd OCCURRENCE)");
		
		runFunction(strings -> {
			var output = new ArrayList<String>();
			strings.forEach(s ->
				output.add(s.substring(0, s.indexOf("ZZZ", s.indexOf("ZZZ")+3)+3))
			);
			return output;
		}, "INDEXOF ZZZ (2nd OCCURRENCE)");
		
		runFunction(strings -> {
			var output = new ArrayList<String>();
			strings.forEach(s -> {
				String[] split = s.split("ZZZ", 3);
				output.add(split[0]+"ZZZ"+split[1]+"ZZZ");
			});
			return output;
		}, "SPLIT ZZZ (2nd OCCURRENCE)");
	}
	
}
