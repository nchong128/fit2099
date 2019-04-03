import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

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
        /*return lairLocationArrayList.get(0).getMinions().get(0).hasSkill(MinionSkill.PROCRASTINATION) && // first minion
                lairLocationArrayList.get(0).getMinions().get(0).hasSkill(MinionSkill.SCUBA) &&
                lairLocationArrayList.get(0).getMinions().get(0).hasSkill(MinionSkill.BUILDING) &&
                lairLocationArrayList.get(0).getMinions().get(1).hasSkill(MinionSkill.FENCING) &&        // second minion
                lairLocationArrayList.get(0).getMinions().get(1).hasSkill(MinionSkill.BUILDING) &&
                lairLocationArrayList.get(0).getMinions().get(1).hasSkill(MinionSkill.SLEEPING) &&
                lairLocationArrayList.get(0).getMinions().get(1).hasSkill(MinionSkill.PROCRASTINATION) &&
                lairLocationArrayList.get(1).getMinions().get(1).hasSkill(MinionSkill.PSYCHOLOGY) &&     // third minion
                lairLocationArrayList.get(1).getMinions().get(1).hasSkill(MinionSkill.BUILDING) &&
                lairLocationArrayList.get(2).getMinions().get(0).hasSkill(MinionSkill.SLEEPING) &&       // fourth minion
                lairLocationArrayList.get(2).getMinions().get(1).hasSkill(MinionSkill.SCUBA);            // fifth minion*/
        return true;
    }

    private String[] getInfo() {
        String name = readString(NAME_PROMPT);
        String id = readString(ID_PROMPT);
        String givenName = name.split(" ")[0];
        String familyName = name.split(" ")[1];

        String[] results = {id, givenName, familyName};

        return results;
    }

    private void addMinions() {
        String name, id, familyName, givenName;

        try {
            String[] firstMinionInfo = getInfo();
            Researcher firstMinion = new Researcher(firstMinionInfo[0], firstMinionInfo[1], firstMinionInfo[2]);

            SupportStaff secondMinion = new SupportStaff("B1234567", "Katy", "Perry");
            Researcher thirdMinion = new Researcher("C1234567", "John", "Doe");
            SupportStaff fourthMinion = new SupportStaff("D1234567", "Karl", "Marx");
            Researcher fifthMinion = new Researcher("E1234567", "Lebron", "James");

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
            fifthMinion.addSkill(MinionSkill.SLEEPING);

            Team firstTeam = new Team();
            firstTeam.addMinion(firstMinion);
            firstTeam.addMinion(secondMinion);

            Team secondTeam = new Team();
            secondTeam.addMinion(firstMinion);
            secondTeam.addMinion(thirdMinion);

            Team thirdTeam = new Team();
            thirdTeam.addMinion(fourthMinion);
            thirdTeam.addMinion(fifthMinion);

            lairLocationArrayList.get(0).assignTeam(firstTeam);
            lairLocationArrayList.get(1).assignTeam(secondTeam);
            lairLocationArrayList.get(2).assignTeam(thirdTeam);

        } catch(IllegalArgumentException e) {
            System.out.println("Error occurred " + e);
            System.out.println("Restarting read");
            addMinions();
        }
    }

    private ArrayList<HashMap> getHashMapArrayList () {
        HashMap<MinionSkill, Integer> firstMap = new HashMap<>();
        firstMap.put(MinionSkill.BUILDING, 2);

        HashMap<MinionSkill, Integer> secondMap = new HashMap<>();
        secondMap.put(MinionSkill.SCUBA, 1);

        HashMap<MinionSkill, Integer> thirdMap = new HashMap<>();
        thirdMap.put(MinionSkill.SLEEPING, 2);

        HashMap<MinionSkill, Integer> fourthMap = new HashMap<>();
        fourthMap.put(MinionSkill.FENCING, 1);

        ArrayList<HashMap> hashMapArrayList = new ArrayList<HashMap>();
        hashMapArrayList.add(firstMap);
        hashMapArrayList.add(secondMap);
        hashMapArrayList.add(thirdMap);
        hashMapArrayList.add(fourthMap);

        return hashMapArrayList;
    }

    public void createLairLocations() {
        /* HashMap chosen because it has a predictable iteration order, which it iterates based on the order the keys
         * are entered
        */
        ArrayList<HashMap> hashMapArrayList = getHashMapArrayList();

        lairLocationArrayList = new ArrayList<LairLocation>(){
            {
                add(new LairLocation("Shark Tank", "Full of dangerous sharks!", hashMapArrayList.get(0)));
                add(new LairLocation("Mad Scientist Lab", "Contains dangerous chemicals!",hashMapArrayList.get(1)));
                add(new LairLocation("Abandoned Circus", "Murderous Clowns!",hashMapArrayList.get(2)));
                add(new LairLocation("Wholefoods Lounge", "Yucky!", hashMapArrayList.get(3)));
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
