package edu.monash.fit2099.watches;
import edu.monash.fit2099.counters.MaxCounter;

public class Watch2 implements Watch {
		
	
	private MaxCounter minutes;
	private MaxCounter hours;
	
	static final private int MAX_HOURS = 24;
	static final private int MAX_MINUTES = 60;
	
	public Watch2() {
		
		hours = new MaxCounter(24);
		minutes = new MaxCounter(60);
	}
	
	public void tick() {
		minutes.increment();
		if (minutes.getValue() == 0) {
			hours.increment();
		}
	}
	
	public void testWatch(int numTicks) {
		for (int i = 0; i < numTicks; i++) {
			System.out.println(
					String.format("%02d", hours.getValue())
					+ ":"
					+ String.format("%02d", minutes.getValue())
			);
			tick();
		}
	}
	
}
