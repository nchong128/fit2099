package edu.monash.fit2099.watches;
import edu.monash.fit2099.counters.LinkedCounter;
import edu.monash.fit2099.counters.MaxCounter;

public class Watch3 extends Watch {
		
	private LinkedCounter seconds;
	private LinkedCounter minutes;
	private MaxCounter hours;
	
	static final private int MAX_HOURS = 24;
	static final private int MAX_MINUTES = 60;
	static final private int MAX_SECONDS = 60;
	
	public Watch3() {
		
		hours = new MaxCounter(MAX_HOURS);
		this.addCounter(hours);
		minutes = new LinkedCounter(MAX_MINUTES, hours);
		this.addCounter(minutes);
		seconds = new LinkedCounter(MAX_SECONDS, minutes);
		this.addCounter(seconds);
	}
	
	public void tick() {
		seconds.increment();
	}
	
}
