package edu.monash.fit2099.watches;
import edu.monash.fit2099.counters.Counter;

public class Watch1 implements Watch {
		
	private Counter minutes;
	private Counter hours;
	
	static final private int MAX_HOURS = 24;
	static final private int MAX_MINUTES = 60;
	
	public Watch1() {
		
		hours = new Counter();
		minutes = new Counter();
	}
	
	public void tick() {
		minutes.increment();
		if (minutes.getValue() == 60) {
			minutes.reset();
			hours.increment();
			if (hours.getValue() == 24) {
				hours.reset();
			}
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
