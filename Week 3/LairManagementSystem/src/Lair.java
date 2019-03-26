import java.util.ArrayList;

public class Lair {
    private LairLocation[] lairLocationArray;

    public void printStatus() {
        System.out.println("Welcome to the Supervillain's Lair Management System");
        System.out.println();
        createLairLocations();
        addMinions();
        displayLairLocations();
        System.out.println("Good bye. Thank you for using the Supervillain's Lair Management System.");
    }

    private void addMinions() {
        Minion firstMinion = new Minion("12345678");
        firstMinion.setGivenName("Mini");
        firstMinion.setFamilyName("Me");

        Minion secondMinion = new Minion("12345679", "Chum", "Berley");

        Minion thirdMinion = new Minion("12345680", "Donna", "Matrix");

        Minion fourthMinion = new Minion("12345666", "Domestos", "McBleach");

        Minion fifthMinion = new Minion("12103464", "Pyne", "O’Kleen");

        lairLocationArray[0].assignMinion(firstMinion);
        lairLocationArray[0].assignMinion(secondMinion);

        lairLocationArray[1].assignMinion(firstMinion);
        lairLocationArray[1].assignMinion(thirdMinion);

        lairLocationArray[2].assignMinion(fourthMinion);
        lairLocationArray[2].assignMinion(fifthMinion);
    }


    public void createLairLocations() {
        lairLocationArray = new LairLocation[] {
                new LairLocation("Shark Tank", "Full of dangerous sharks!"),
                new LairLocation("Mad Scientist Lab", "Contains dangerous chemicals!"),
                new LairLocation("Abandoned Circus", "Murderous Clowns!"),
                new LairLocation("Wholefoods Lounge", "Yucky!")
        };
    }

    public void displayLairLocations()  {
        for (int i = 0; i < lairLocationArray.length; i++ ) {
            System.out.println(lairLocationArray[i].description());
            System.out.println("Assigned Minions:");
            ArrayList<Minion> minionsArrayList = lairLocationArray[i].getMinions();

            // If no minions are given, print the err message
            if (minionsArrayList.size() == 0) {
                System.out.println("No minions for this lair location");
            } else {
                // Iterate over all minions and print each description sequentially
                for (int j = 0; j <minionsArrayList.size(); j ++) {
                    System.out.println(minionsArrayList.get(j).description());
                }
            }
            System.out.println();
        }

    }


}
