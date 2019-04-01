package edu.monash.fit2099.counters;

public class Counter {

	private int value = 0;
	
	public void reset() {
		value = 0;
	}
	
	public void decrement() {
		value--;
	}
	
	public void increment() {
		value++;
	}
	
	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return Integer.valueOf(this.getValue()).toString();
	}

}

