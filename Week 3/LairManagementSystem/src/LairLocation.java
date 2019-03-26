import java.util.ArrayList;

public class LairLocation {
    private String lairName, lairDescription;

    private ArrayList<Minion> minions;

    LairLocation(String lairName, String lairDescription) {
        this.lairName = lairName;
        this.lairDescription = lairDescription;

        minions = new ArrayList<Minion>();
    }

    public String description() {
        return this.lairName + ": " + this.lairDescription;
    }

    public void assignMinion(Minion minion){
        minions.add(minion);
    }

    public ArrayList<Minion> getMinions() {
        ArrayList<Minion> minionsArrayList = new ArrayList<Minion>();

        for (int i = 0; i < this.minions.size(); i++) {
            minionsArrayList.add(minions.get(i));
        }

        return minionsArrayList;
    }
}
