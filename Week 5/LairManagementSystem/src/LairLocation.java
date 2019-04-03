import java.util.ArrayList;
import java.util.HashMap;

public class LairLocation {
    private String lairName, lairDescription;

    private Team minions;

    private HashMap<MinionSkill, Integer> minionSkillHashMap;

    LairLocation(String lairName, String lairDescription, HashMap<MinionSkill, Integer> minionSkillHashMap) {
        this.lairName = lairName;
        this.lairDescription = lairDescription;

        this.minions = new Team();
        this.minionSkillHashMap = minionSkillHashMap;
    }

    public String description() {
        return this.lairName + ": " + this.lairDescription;
    }

    public void assignTeam(Team t) throws IllegalArgumentException {
        // Get team list
        ArrayList<Minion> teamArrayList = t.getTeamList();

        // Find number of SupportStaff and number of Researchers
        int supportStaffCount = 0;
        int researcherCount = 0;
        for (Minion m: teamArrayList) {
            if (m instanceof SupportStaff) {
                supportStaffCount ++;
            } else if (m instanceof Researcher) {
                researcherCount ++;
            }
        }

        // Check rules
        if (teamArrayList.size() < 1) {
            throw new IllegalArgumentException("Team needs to have at least 1 member");
        } else if (supportStaffCount != researcherCount) {
            throw new IllegalArgumentException("There must be the same number of support staff as researchers");
        } else {
            // Get requirement and check against team
            for (MinionSkill minionSkill: this.minionSkillHashMap.keySet()) {
                // For each key get the value and check if Team has the min number of skills
                Integer minNum = this.minionSkillHashMap.get(minionSkill);

                if (t.hasSkill(minionSkill) < minNum) {
                    throw new IllegalArgumentException("Minion skills do not match up");
                }
            }
        }

        this.minions = t;
    }

    public int getTotalPayroll() {
        int total = 0;

        for (int i = 0 ; i < this.minions.getTeamList().size(); i ++) {
            Minion minion = (Minion) this.minions.getTeamList().get(i);
            total += minion.monthlyPay();
        }
        return total;
    }

    public ArrayList<Minion> getMinions() {
        return this.minions.getTeamList();
    }

}
