public class Lair {
    private LairLocation firstLairLocation, secondLairLocation, thirdLairLocation;

    public void printStatus() {
        System.out.println("Welcome to the Supervillain's Lair Management System");
        createRooms();
        displayRooms();
        System.out.println("Good bye. Thank you for using the Supervillain's Lair Management System.");
    }

    public void createRooms() {
        firstLairLocation = new LairLocation("Shark Tank", "Full of dangerous sharks!");
        secondLairLocation = new LairLocation("Mad Scientist Lab", "Contains dangerous chemicals!");
        thirdLairLocation = new LairLocation("Abandoned Circus", "Murderous Clowns!");
    }

    public void displayRooms()  {
        System.out.println(firstLairLocation.getLairLocationDescription());
        System.out.println(secondLairLocation.getLairLocationDescription());
        System.out.println(thirdLairLocation.getLairLocationDescription());

    }
}
