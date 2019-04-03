import java.util.EnumSet;

public abstract class Minion {
    private String minionId, givenName, familyName;
    private EnumSet<MinionSkill> minionSkill;

/*
    Minion ID
    ============
    Integers allows for mathematical manipulation and deeper comparison (less than, more than, etc.)
    Strings allow for direct comparison to see if two strings are equal
    It is also easier to edit one character in a string as opposed to integers

    Due to the fact that an ID would not be subject to math operations and would instead require
    something more important like editing single characters, a String is more suitable in my opinion.

    Given/family name vs first/last name
    ===================================
    First and last names imply only one word, whereas given and family names are more accurate as a
    person's name can often consist of more than 2 words
*/

    Minion(String newMinionId) throws IllegalArgumentException {
        checkId(newMinionId);
        this.minionId = newMinionId;
        this.minionSkill = EnumSet.noneOf(MinionSkill.class);
    }

    Minion(String newMinionId, String newGivenName, String newFamilyName) throws IllegalArgumentException{
        checkId(newMinionId);
        this.minionId = newMinionId;
        this.givenName = newGivenName;
        this.familyName = newFamilyName;
        this.minionSkill = EnumSet.noneOf(MinionSkill.class);
    }

    private void checkId(String id) throws IllegalArgumentException {
        // Make sure ID fits description of letter with 7 integers
        if (id.length() != 8) {
            throw new IllegalArgumentException("Incorrect ID length");
        } else if (!Character.isLetter(id.charAt(0)) || !Character.isUpperCase(id.charAt(0))) {
            throw new IllegalArgumentException("First character is not a letter");
        } else {
            for (int i = 1; i < id.length(); i ++ ) {
                if (!Character.isDigit(id.charAt(i))) {
                    throw new IllegalArgumentException("ID contains non-integers after alphabet");
                }
            }
        }
    }


    public void setGivenName(String newGivenName) {
        this.givenName = newGivenName;
    }

    public void setFamilyName(String newFamilyName) {
        this.familyName = newFamilyName;
    }

    public String description() {
        return String.format("%s %s %s", this.minionId, this.givenName, this.familyName);
    }

    public void addSkill(MinionSkill skill) {
        this.minionSkill.add(skill);
    }

    public boolean hasSkill(MinionSkill skill) {
        return this.minionSkill.contains(skill);
    }

    public int getNumberOfSkills() {
        return this.minionSkill.size();
    }

    public abstract int monthlyPay();

}
