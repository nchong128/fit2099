package edu.monash.fit2099.watches;
import edu.monash.fit2099.counters.LinkedCounter;
import edu.monash.fit2099.counters.MaxCounter;

public class Watch2 extends Watch {
		
	
	private MaxCounter minutes;
	private MaxCounter hours;
	
	public Watch2() {
		
		hours = new MaxCounter(MAX_HOURS);
		this.addCounter(hours);
		minutes = new LinkedCounter(MAX_MINUTES, hours);
		this.addCounter(minutes);
	}
	
	public void tick() {
		minutes.increment();
		if (minutes.getValue() == 0) {
			hours.increment();
		}
	}
	
}
