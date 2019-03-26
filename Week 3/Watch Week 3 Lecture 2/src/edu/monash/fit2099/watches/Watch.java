package edu.monash.fit2099.watches;

import java.util.ArrayList;

import edu.monash.fit2099.counters.Counter;

public abstract class Watch {

	public abstract void tick();
	
	private ArrayList<Counter> counters = new ArrayList<Counter>();
	
	protected void addCounter(Counter newCounter) {
		counters.add(newCounter);
	}
	
	public void display() {	
		String prefix = ""; 
		for (Counter thisCounter : counters) {
			System.out.print(prefix + String.format("%02d", thisCounter.getValue()));
			prefix = ":";
		}
		System.out.println();
	}
		
	public void testWatch(int numTicks) {
		for (int i = 0; i < numTicks; i++) {
			display();
			tick();
		}
	}
}
