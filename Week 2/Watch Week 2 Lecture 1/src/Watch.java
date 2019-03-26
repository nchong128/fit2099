
public class Watch {
		
	Counter minutes;
	Counter hours;
	
	public Watch() {
		
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
