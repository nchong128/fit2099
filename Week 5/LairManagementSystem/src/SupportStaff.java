public class SupportStaff extends Minion {

    SupportStaff(String newMinionId) throws IllegalArgumentException {
        super(newMinionId);
    }

    SupportStaff(String newMinionId, String newGivenName, String newFamilyName) throws IllegalArgumentException {
        super(newMinionId, newGivenName, newFamilyName);
    }

    @Override
    public int monthlyPay() {
        int base = 3000;
        int bonus = this.getNumberOfSkills();
        int multiplier = 500;

        return base + bonus * multiplier;
    }
}
