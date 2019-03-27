public class SupportStaff extends Minion {

    SupportStaff(String newMinionId) {
        super(newMinionId);
    }

    SupportStaff(String newMinionId, String newGivenName, String newFamilyName) {
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
