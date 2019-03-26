import edu.monash.fit2099.watches.*;

public class Driver {

	public static void main(String[] args) {	
		
		Watch[] watches = new Watch[3];
		
		watches[0] = new Watch1();
		watches[1] = new Watch2();
		watches[2] = new Watch3();
		
		System.out.println("##############################");
		for (int i = 0; i < watches.length; i++) {
			System.out.println("Testing Watch" + (i+1));
			watches[i].testWatch(200);		
			System.out.println("##############################");
		}
	}

}
