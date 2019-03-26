public class Minion {
    private String minionId, givenName, familyName;

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

    Minion(String newMinionId) {
        this.minionId = newMinionId;
    }

    Minion(String newMinionId, String newGivenName, String newFamilyName) {
        this.minionId = newMinionId;
        this.givenName = newGivenName;
        this.familyName = newFamilyName;
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

}
