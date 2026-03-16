import java.util.*;

class RoomAllocationService {

    private Set<String> allocatedRoomIds;
    private Map<String, Set<String>> assignedRoomsByType;

    public RoomAllocationService() {
        allocatedRoomIds = new HashSet<>();
        assignedRoomsByType = new HashMap<>();
    }

    public void allocateRoom(Reservation reservation, RoomInventory inventory) {

        String roomType = reservation.getRoomType();
        Map<String, Integer> availability = inventory.getRoomAvailability();

        if (availability.get(roomType) != null && availability.get(roomType) > 0) {

            String roomId = generateRoomId(roomType);

            allocatedRoomIds.add(roomId);

            assignedRoomsByType
                    .computeIfAbsent(roomType, k -> new HashSet<>())
                    .add(roomId);

            inventory.updateAvailability(roomType, availability.get(roomType) - 1);

            System.out.println("Room allocated to " + reservation.getGuestName()
                    + " | Room Type: " + roomType
                    + " | Room ID: " + roomId);
        } else {
            System.out.println("No available " + roomType + " rooms for "
                    + reservation.getGuestName());
        }
    }

    private String generateRoomId(String roomType) {

        int count = assignedRoomsByType
                .getOrDefault(roomType, new HashSet<>())
                .size() + 1;

        String roomId = roomType.substring(0, 1).toUpperCase() + count;

        while (allocatedRoomIds.contains(roomId)) {
            count++;
            roomId = roomType.substring(0, 1).toUpperCase() + count;
        }

        return roomId;
    }
}

public class UseCase6RoomAllocation {

    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();
        RoomAllocationService service = new RoomAllocationService();

        Reservation r1 = new Reservation("Abhi", "Single");
        Reservation r2 = new Reservation("Subha", "Double");
        Reservation r3 = new Reservation("Vanmathi", "Suite");

        service.allocateRoom(r1, inventory);
        service.allocateRoom(r2, inventory);
        service.allocateRoom(r3, inventory);
    }
}