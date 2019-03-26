public class LairLocation {
    private String lairName, lairDescription;

    LairLocation(String lairName, String lairDescription) {
        this.lairName = lairName;
        this.lairDescription = lairDescription;
    }

    public String getLairLocationDescription() {
        return this.lairName + ": " + this.lairDescription;
    }
}
