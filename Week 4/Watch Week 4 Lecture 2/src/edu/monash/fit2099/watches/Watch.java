package edu.monash.fit2099.watches;

import java.util.ArrayList;

import edu.monash.fit2099.counters.*;

public class Watch {
	
	static public final int MAX_HOURS = 24;
	static public final int MAX_MINUTES = 60;
	static public final int MAX_SECONDS = 60;
	static public final int MAX_MILLISECONDS = 1000;
		
	private ArrayList<MaxCounter> counters = new ArrayList<MaxCounter>();
	
	public Watch() {
		 /* needed so no-argument constructors in subclasses can call it.
		  * A Watch created using this will do nothing, as it has no
		  * counters.
		  */
	}
	
	public Watch(int[] maxValues) {
		
		MaxCounter lastCounter = new MaxCounter(maxValues[0]);
		this.addCounter(lastCounter);
		for (int i = 1; i < maxValues.length; i++) { // notice we start from 1, not 0
			MaxCounter thisCounter = new LinkedCounter(maxValues[i], lastCounter);
			this.addCounter(thisCounter);
			lastCounter = thisCounter; // notice we can assign a LinkedCounter to a MaxCounter
		}
	}
	
	protected void addCounter(MaxCounter newCounter) {
		counters.add(newCounter);
	}
	
	protected MaxCounter getLeastSignificantCounter() {
		return counters.get(counters.size() - 1);
	}
	
	public void display() {	
		String prefix = ""; 
		for (MaxCounter thisCounter : counters) {
			System.out.print(prefix + thisCounter);
			prefix = ":";
		}
		System.out.println();
	}
			
	public void tick() {
		getLeastSignificantCounter().increment();
	}
	
	public void testWatch(int numTicks) {
		for (int i = 0; i < numTicks; i++) {
			display();
			tick();
		}
	}

}
