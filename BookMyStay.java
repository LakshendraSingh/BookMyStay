/**
 * Hotel Booking Management System
 *
 * <p>Use Case 2: Basic Room Types & Static Availability</p>
 * This program demonstrates object modeling using abstraction,
 * inheritance, and polymorphism before introducing data structures.
 *
 * @author Student
 * @version 1.0
 */

// Abstract class representing a general Room
abstract class Room {

    // Encapsulated attributes
    private String roomType;
    private int beds;
    private double price;

    // Constructor
    public Room(String roomType, int beds, double price) {
        this.roomType = roomType;
        this.beds = beds;
        this.price = price;
    }

    // Getter methods
    public String getRoomType() {
        return roomType;
    }

    public int getBeds() {
        return beds;
    }

    public double getPrice() {
        return price;
    }

    // Method to display room details
    public void displayRoomDetails() {
        System.out.println("Room Type: " + roomType);
        System.out.println("Beds: " + beds);
        System.out.println("Price per Night: $" + price);
    }
}

// Concrete class: Single Room
class SingleRoom extends Room {

    public SingleRoom() {
        super("Single Room", 1, 1000);
    }
}

// Concrete class: Double Room
class DoubleRoom extends Room {

    public DoubleRoom() {
        super("Double Room", 2, 1800);
    }
}

// Concrete class: Suite Room
class SuiteRoom extends Room {

    public SuiteRoom() {
        super("Suite Room", 3, 3500);
    }
}

public class UseCase2HotelBookingApp {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("      Book My Stay - Hotel Rooms");
        System.out.println("======================================");

        // Creating room objects (Polymorphism)
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Static availability variables
        int singleRoomAvailable = 10;
        int doubleRoomAvailable = 6;
        int suiteRoomAvailable = 3;

        // Display room details
        System.out.println("\n--- Single Room ---");
        single.displayRoomDetails();
        System.out.println("Available: " + singleRoomAvailable);

        System.out.println("\n--- Double Room ---");
        doubleRoom.displayRoomDetails();
        System.out.println("Available: " + doubleRoomAvailable);

        System.out.println("\n--- Suite Room ---");
        suite.displayRoomDetails();
        System.out.println("Available: " + suiteRoomAvailable);

        System.out.println("\nThank you for checking room availability!");
    }
}