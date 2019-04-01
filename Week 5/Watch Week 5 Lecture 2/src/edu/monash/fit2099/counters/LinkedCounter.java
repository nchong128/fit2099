package edu.monash.fit2099.counters;

public class LinkedCounter extends MaxCounter {
	
	Counter neighbour;
	
	public LinkedCounter(int max, Counter neighbour) {
		super(max);
		this.neighbour = neighbour;
	}
	
	@Override
	public void increment() {
		super.increment();
		if (this.getValue() == 0) {
			neighbour.increment();
		}
	}
}
