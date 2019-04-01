package edu.monash.fit2099.counters;

public class MaxCounter extends Counter {

	private final int max;
	private final String fieldFormat;

	public MaxCounter(int max) throws Exception {

		if (max <= 0) {
			throw new Exception("Maximum value of a MaxCounter must be greater than zero.");
		}
		
		this.max = max;
		// create a format string with the correct field width for this counter
		double fieldWidth = Math.ceil(Math.log10(max));
		fieldFormat = "%0" + String.format("%.0f", fieldWidth) + "d";
	}
	
	public int getMax() {
		return max;
	}
	
	@Override	
	public void increment() {
		super.increment();
		if (this.getValue() == max) {
			this.reset();
		}
	}
	
	@Override
	public String toString() {
		return String.format(fieldFormat, this.getValue());
	}
}
