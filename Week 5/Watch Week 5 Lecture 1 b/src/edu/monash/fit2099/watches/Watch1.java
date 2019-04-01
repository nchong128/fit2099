package edu.monash.fit2099.watches;

public class Watch1 extends Watch {
		
	private Watch2 myWatch2;
	
	public Watch1() throws Exception {		
		myWatch2 = new Watch2();
	}
	
	public void tick() {
		myWatch2.tick(); // delegation
	}
	
	@Override
	public void display() {
		myWatch2.display(); // delegation
	}
	
}
