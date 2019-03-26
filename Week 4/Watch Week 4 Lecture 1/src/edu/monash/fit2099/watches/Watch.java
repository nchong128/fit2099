package edu.monash.fit2099.watches;

import java.util.ArrayList;

import edu.monash.fit2099.counters.*;

public abstract class Watch {
	
	static final int MAX_HOURS = 24;
	static final int MAX_MINUTES = 60;
	static final int MAX_SECONDS = 60;
	static final int MAX_MILLISECONDS = 1000;
	
	public abstract void tick();
	
	private ArrayList<MaxCounter> counters = new ArrayList<MaxCounter>();
	
	protected void addCounter(MaxCounter newCounter) {
		counters.add(newCounter);
	}
	
	public void display() {	
		String prefix = ""; 
		for (MaxCounter thisCounter : counters) {
			double fieldWidth = Math.ceil(Math.log10(thisCounter.getMax()));
			// create a format string with the correct field width for this counter
			String fieldFormat = "%0" + String.format("%.0f", fieldWidth) + "d";
			System.out.print(prefix + String.format(fieldFormat, thisCounter.getValue()));
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
