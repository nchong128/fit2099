
public class Watch3 {
	
	private LinkedCounter seconds;
	private LinkedCounter minutes;
	private MaxCounter hours;
	
	public Watch3() {
		
		hours = new MaxCounter(24);
		minutes = new LinkedCounter(60, hours);
		seconds = new LinkedCounter(1000, minutes);
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
