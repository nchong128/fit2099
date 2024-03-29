package edu.monash.fit2099.watches;

import java.util.ArrayList;

import edu.monash.fit2099.counters.*;

/**
 * Implements a watch made up of an arbitrary number of counters linked together.
 * Each counter has a maximum value. When it reaches its maximum, it resets its
 * value to zero, and increments its neighbour.
 * 
 * @author David Squire
 *
 */
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
	
	/**
	 * Create a Watch using an array integers that specify the maximum values of the counters
	 * that make up the desired Watch. Elements of the array must be in order from the most significant
	 * counter (e.g. hours) at position {@code 0}, to the least significant (e.g. seconds) at position
	 * {@code maxValues.length - 1}
	 * 
	 * @param maxValues an array of integers that specify the maximum values of the counters.
	 * There must be at least one element in the array, and all the maximum values must be
	 * greater than 0.
	 * 
	 */
	public Watch(int[] maxValues) {
		
		assert maxValues != null : "Null reference passed to Watch constructor.";
		assert maxValues.length >= 1 : "Must pass at least one counter maximum value in array parameter";
		
		MaxCounter lastCounter = new MaxCounter(maxValues[0]);
		this.addCounter(lastCounter);
		for (int i = 1; i < maxValues.length; i++) { // notice we start from 1, not 0
			// Commented out to demonstrate the Exception thrown by the MaxCounter constructor
			// assert maxValues[i] > 0 : "Counter maximum values must be greater than zero. maxValues[" + i + "] = " + maxValues[i];
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
	
	/**
	 * Increment the least significant counter of the Watch.
	 */
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
