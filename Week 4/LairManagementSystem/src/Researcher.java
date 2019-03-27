public class Researcher extends Minion{

    Researcher(String newMinionId) {
        super(newMinionId);
    }

    Researcher(String newMinionId, String newGivenName, String newFamilyName) {
        super(newMinionId, newGivenName, newFamilyName);
    }

    @Override
    public int monthlyPay() {
        if (this.getNumberOfSkills() < 3) {
            return 5000;
        } else {
            return 10000;
        }
    }
}
