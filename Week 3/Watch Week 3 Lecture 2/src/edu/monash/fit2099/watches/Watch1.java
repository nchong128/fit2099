package edu.monash.fit2099.watches;
import edu.monash.fit2099.counters.Counter;
import edu.monash.fit2099.counters.LinkedCounter;
import edu.monash.fit2099.counters.MaxCounter;

public class Watch1 extends Watch {
		
	private Counter minutes;
	private Counter hours;
	
	static final private int MAX_HOURS = 24;
	static final private int MAX_MINUTES = 60;
	
	public Watch1() {
		
		hours = new Counter();
		this.addCounter(hours);
		minutes = new Counter();
		this.addCounter(minutes);
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
	
}
