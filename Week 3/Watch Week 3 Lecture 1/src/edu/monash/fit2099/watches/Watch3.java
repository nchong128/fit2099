package edu.monash.fit2099.watches;
import edu.monash.fit2099.counters.LinkedCounter;
import edu.monash.fit2099.counters.MaxCounter;

public class Watch3 implements Watch {
		
	private LinkedCounter seconds;
	private LinkedCounter minutes;
	private MaxCounter hours;
	
	static final private int MAX_HOURS = 24;
	static final private int MAX_MINUTES = 60;
	static final private int MAX_SECONDS = 60;
	
	public Watch3() {
		
		hours = new MaxCounter(MAX_HOURS);
		minutes = new LinkedCounter(MAX_MINUTES, hours);
		seconds = new LinkedCounter(MAX_SECONDS, minutes);
	}
	
	public void tick() {
		seconds.increment();
	}
	
	public void testWatch(int numTicks) {
		for (int i = 0; i < numTicks; i++) {
			System.out.println(
					String.format("%02d", hours.getValue())
					+ ":"
					+ String.format("%02d", minutes.getValue())
					+ ":"
					+ String.format("%02d", seconds.getValue())
			);
			tick();
		}
	}
	
}
