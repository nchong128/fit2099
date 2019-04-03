import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Team {
    private ArrayList<Minion> teamList;

    public Team() {
        this.teamList = new ArrayList<Minion>();
    }

    public void addMinion(Minion m) {
        this.teamList.add(m);
    }

    public void removeMinion(Minion m) {
        this.teamList.remove(m);
    }

    public int hasSkill(MinionSkill minionSkill) {
        int counter = 0;
        for (Minion m: this.teamList) {
            if (m.hasSkill(minionSkill)) {
                counter ++;
            }
        }
        return counter;
    }

    public ArrayList<Minion> getTeamList() {
        return this.teamList;
    }


}

