import java.util.ArrayList;

public class LairLocation {
    private String lairName, lairDescription;

    private ArrayList<Minion> minions;

    LairLocation(String lairName, String lairDescription) {
        this.lairName = lairName;
        this.lairDescription = lairDescription;

        this.minions = new ArrayList<Minion>();
    }

    public String description() {
        return this.lairName + ": " + this.lairDescription;
    }

    public void assignMinion(Minion minion){
        this.minions.add(minion);
    }

    public int getTotalPayroll() {
        int total = 0;

        for (Minion minion: this.minions) {
            total += minion.monthlyPay();
        }
        return total;
    }

    public ArrayList<Minion> getMinions() {
        return new ArrayList<Minion>(this.minions);

    }
}
