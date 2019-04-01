import java.util.ArrayList;

import edu.monash.fit2099.watches.*;

public class Driver {
	
	public static void main(String[] args) {	
		
		ArrayList<Watch> watches = new ArrayList<Watch>();
		
		watches.add(new Watch1());
		watches.add(new Watch2());
		try {
			watches.add(new Watch(new int[] {24, 60, -60, 1000} ));
		}
		catch (Exception e) {
			System.out.println("Watch construction failed with message: \n\t"
					+ e.getMessage()
					+ "\nLet's not bother with this watch for now."
			);
		}
		
		System.out.println("##############################");
		for (Watch watch : watches) {
			System.out.println("Testing Watch: " + watch.getClass().getSimpleName());
			watch.testWatch(200);		
			System.out.println("##############################");
		}
	}

}
