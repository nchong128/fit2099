import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Lair {
    private ArrayList<LairLocation> lairLocationArrayList;
    private static final String NAME_PROMPT = "Enter minion name: ";
    private static final String ID_PROMPT = "Enter minion ID: ";

    public void printStatus() {
        System.out.println("Welcome to the Supervillain's Lair Management System");
        System.out.println();
        createLairLocations();
        addMinions();

        // Test if minions have given skills
        if (!testMinions()) {
            System.out.println("Minion skills do not work!");
        }

        displayLairLocations();
        System.out.println("Good bye. Thank you for using the Supervillain's Lair Management System.");
    }

    private boolean testMinions() {
        return lairLocationArrayList.get(0).getMinions().get(0).hasSkill(MinionSkill.PROCRASTINATION) && // first minion
                lairLocationArrayList.get(0).getMinions().get(0).hasSkill(MinionSkill.SCUBA) &&
                lairLocationArrayList.get(0).getMinions().get(0).hasSkill(MinionSkill.BUILDING) &&
                lairLocationArrayList.get(0).getMinions().get(1).hasSkill(MinionSkill.FENCING) &&        // second minion
                lairLocationArrayList.get(0).getMinions().get(1).hasSkill(MinionSkill.BUILDING) &&
                lairLocationArrayList.get(0).getMinions().get(1).hasSkill(MinionSkill.SLEEPING) &&
                lairLocationArrayList.get(0).getMinions().get(1).hasSkill(MinionSkill.PROCRASTINATION) &&
                lairLocationArrayList.get(1).getMinions().get(1).hasSkill(MinionSkill.PSYCHOLOGY) &&     // third minion
                lairLocationArrayList.get(1).getMinions().get(1).hasSkill(MinionSkill.BUILDING) &&
                lairLocationArrayList.get(2).getMinions().get(0).hasSkill(MinionSkill.SLEEPING) &&       // fourth minion
                lairLocationArrayList.get(2).getMinions().get(1).hasSkill(MinionSkill.SCUBA);            // fifth minion
    }

    private void addMinions() {
        String name, id, familyName, givenName;

        name = readString(NAME_PROMPT);
        id = readString(ID_PROMPT);
        givenName = name.split(" ")[0];
        familyName = name.split(" ")[1];

        Researcher firstMinion = new Researcher(id);
        firstMinion.setGivenName(givenName);
        firstMinion.setFamilyName(familyName);

        name = readString(NAME_PROMPT);
        id = readString(ID_PROMPT);
        givenName = name.split(" ")[0];
        familyName = name.split(" ")[1];
        SupportStaff secondMinion = new SupportStaff(id, givenName, familyName);

        name = readString(NAME_PROMPT);
        id = readString(ID_PROMPT);
        givenName = name.split(" ")[0];
        familyName = name.split(" ")[1];
        Researcher thirdMinion = new Researcher(id, givenName, familyName);

        name = readString(NAME_PROMPT);
        id = readString(ID_PROMPT);
        givenName = name.split(" ")[0];
        familyName = name.split(" ")[1];
        SupportStaff fourthMinion = new SupportStaff(id, givenName, familyName);

        name = readString(NAME_PROMPT);
        id = readString(ID_PROMPT);
        givenName = name.split(" ")[0];
        familyName = name.split(" ")[1];
        Researcher fifthMinion = new Researcher(id, givenName, familyName);

        // Add some skills to the minions
        firstMinion.addSkill(MinionSkill.PROCRASTINATION);
        firstMinion.addSkill(MinionSkill.SCUBA);
        firstMinion.addSkill(MinionSkill.BUILDING);

        secondMinion.addSkill(MinionSkill.FENCING);
        secondMinion.addSkill(MinionSkill.BUILDING);
        secondMinion.addSkill(MinionSkill.SLEEPING);
        secondMinion.addSkill(MinionSkill.PROCRASTINATION);

        thirdMinion.addSkill(MinionSkill.PSYCHOLOGY);
        thirdMinion.addSkill(MinionSkill.BUILDING);

        fourthMinion.addSkill(MinionSkill.SLEEPING);

        fifthMinion.addSkill(MinionSkill.SCUBA);

        lairLocationArrayList.get(0).assignMinion(firstMinion);
        lairLocationArrayList.get(0).assignMinion(secondMinion);

        lairLocationArrayList.get(1).assignMinion(firstMinion);
        lairLocationArrayList.get(1).assignMinion(thirdMinion);

        lairLocationArrayList.get(2).assignMinion(fourthMinion);
        lairLocationArrayList.get(2).assignMinion(fifthMinion);
    }


    public void createLairLocations() {
        lairLocationArrayList = new ArrayList<LairLocation>(){
            {
                add(new LairLocation("Shark Tank", "Full of dangerous sharks!"));
                add(new LairLocation("Mad Scientist Lab", "Contains dangerous chemicals!"));
                add(new LairLocation("Abandoned Circus", "Murderous Clowns!"));
                add(new LairLocation("Wholefoods Lounge", "Yucky!"));
            }
        };
    }

    private String readString(String prompt) {
        System.out.println(prompt);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        try {
            s = in.readLine();
        } catch(IOException e) {
            e.printStackTrace();
        }

        return s;
    }

    public void displayLairLocations()  {
        for (int i = 0; i < lairLocationArrayList.size(); i++ ) {
            System.out.println(lairLocationArrayList.get(i).description());
            System.out.println("Assigned Minions:");
            ArrayList<Minion> minionsArrayList = lairLocationArrayList.get(i).getMinions();

            // If no minions are given, print the err message
            if (minionsArrayList.size() == 0) {
                System.out.println("No minions for this lair location");
            } else {
                // Iterate over all minions and print each description sequentially
                for (int j = 0; j <minionsArrayList.size(); j ++) {
                    System.out.println(minionsArrayList.get(j).description());
                }
            }
            // Print the total payroll for that lairlocation
            System.out.println("Total payroll: " + lairLocationArrayList.get(i).getTotalPayroll());

            System.out.println();
        }

    }


}
