import java.util.HashMap;
import java.util.Map;

/**
 * Book My Stay App
 *
 * Use Case 4: Room Search & Availability Check
 *
 * Demonstrates read-only access to centralized inventory
 * and displays available rooms without modifying system state.
 *
 * @author Student
 * @version 4.0
 */

/* ---------------- ROOM DOMAIN MODEL ---------------- */

abstract class Room {

    private String roomType;
    private int beds;
    private double price;

    public Room(String roomType, int beds, double price) {
        this.roomType = roomType;
        this.beds = beds;
        this.price = price;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getBeds() {
        return beds;
    }

    public double getPrice() {
        return price;
    }

    public void displayDetails() {
        System.out.println("Room Type : " + roomType);
        System.out.println("Beds      : " + beds);
        System.out.println("Price     : ₹" + price);
    }
}

class SingleRoom extends Room {
    public SingleRoom() {
        super("Single Room", 1, 1200);
    }
}

class DoubleRoom extends Room {
    public DoubleRoom() {
        super("Double Room", 2, 2000);
    }
}

class SuiteRoom extends Room {
    public SuiteRoom() {
        super("Suite Room", 3, 4500);
    }
}

/* ---------------- INVENTORY CLASS ---------------- */

class RoomInventory {

    private HashMap<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();

        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 0); // Example unavailable room
    }

    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    public Map<String, Integer> getInventory() {
        return inventory;
    }
}

/* ---------------- SEARCH SERVICE ---------------- */

class RoomSearchService {

    public void searchAvailableRooms(RoomInventory inventory, Room[] rooms) {

        System.out.println("\nAvailable Rooms:\n");

        for (Room room : rooms) {

            int available = inventory.getAvailability(room.getRoomType());

            // Defensive check: show only available rooms
            if (available > 0) {

                room.displayDetails();
                System.out.println("Available : " + available);
                System.out.println("---------------------------");

            }
        }
    }
}

/* ---------------- APPLICATION ENTRY ---------------- */

public class UseCase4RoomSearch {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("     Book My Stay App v4.0");
        System.out.println("   Room Search & Availability");
        System.out.println("=================================");

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Room domain objects
        Room[] rooms = {
                new SingleRoom(),
                new DoubleRoom(),
                new SuiteRoom()
        };

        // Search service
        RoomSearchService searchService = new RoomSearchService();

        // Perform search
        searchService.searchAvailableRooms(inventory, rooms);

        System.out.println("\nSearch completed. Inventory state unchanged.");
    }
}