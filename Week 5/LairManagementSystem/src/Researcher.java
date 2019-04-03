public class Researcher extends Minion{

    Researcher(String newMinionId) throws IllegalArgumentException {
        super(newMinionId);
    }

    Researcher(String newMinionId, String newGivenName, String newFamilyName) throws IllegalArgumentException {
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
