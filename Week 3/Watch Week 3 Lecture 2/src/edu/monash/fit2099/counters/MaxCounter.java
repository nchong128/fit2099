package edu.monash.fit2099.counters;

public class MaxCounter extends Counter {

	private int max;
	
	public MaxCounter(int max) {
		this.max = max;
	}
	
	@Override	
	public void increment() {
		super.increment();
		if (this.getValue() == max) {
			this.reset();
		}
	}
}
