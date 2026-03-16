abstract class Room {

    // Number of beds available in the room
    protected int numberOfBeds;

    // Total size of the room in square feet
    protected int squareFeet;

    // Price charged per night
    protected double pricePerNight;

    // Constructor
    public Room(int numberOfBeds, int squareFeet, double pricePerNight) {
        this.numberOfBeds = numberOfBeds;
        this.squareFeet = squareFeet;
        this.pricePerNight = pricePerNight;
    }

    // Method to display room details
    public void displayRoomDetails() {
        System.out.println("Number of Beds: " + numberOfBeds);
        System.out.println("Room Size (sq ft): " + squareFeet);
        System.out.println("Price Per Night: ₹" + pricePerNight);
        System.out.println("---------------------------");
    }
}

// Single Room
class SingleRoom extends Room {

    public SingleRoom() {
        super(1, 250, 1500.0);
    }
}

// Double Room
class DoubleRoom extends Room {

    public DoubleRoom() {
        super(2, 400, 2500.0);
    }
}

// Suite Room
class SuiteRoom extends Room {

    public SuiteRoom() {
        super(3, 750, 5000.0);
    }
}

// Main class
public class BookMyStayApp {

    public static void main(String[] args) {

        SingleRoom single = new SingleRoom();
        DoubleRoom doubleRoom = new DoubleRoom();
        SuiteRoom suite = new SuiteRoom();

        System.out.println("Single Room Details:");
        single.displayRoomDetails();

        System.out.println("Double Room Details:");
        doubleRoom.displayRoomDetails();

        System.out.println("Suite Room Details:");
        suite.displayRoomDetails();
    }
}