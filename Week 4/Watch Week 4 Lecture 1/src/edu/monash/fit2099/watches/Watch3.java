package edu.monash.fit2099.watches;
import edu.monash.fit2099.counters.LinkedCounter;
import edu.monash.fit2099.counters.MaxCounter;

public class Watch3 extends Watch {
		
	private LinkedCounter milliseconds;
	private LinkedCounter seconds;
	private LinkedCounter minutes;
	private MaxCounter hours;
	
	public Watch3() {
		
		hours = new MaxCounter(MAX_HOURS);
		this.addCounter(hours);
		minutes = new LinkedCounter(MAX_MINUTES, hours);
		this.addCounter(minutes);
		seconds = new LinkedCounter(MAX_SECONDS, minutes);
		this.addCounter(seconds);
		milliseconds = new LinkedCounter(MAX_MILLISECONDS, seconds);
		this.addCounter(milliseconds);
	}
	
	public void tick() {
		milliseconds.increment();
	}
	
}
