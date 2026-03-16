import java.util.*;

class CancellationService {

    private Stack<String> releasedRoomIds;
    private Map<String, String> reservationRoomTypeMap;

    public CancellationService() {
        releasedRoomIds = new Stack<>();
        reservationRoomTypeMap = new HashMap<>();
    }

    public void registerBooking(String reservationId, String roomType) {
        reservationRoomTypeMap.put(reservationId, roomType);
    }

    public void cancelBooking(String reservationId) {

        if (!reservationRoomTypeMap.containsKey(reservationId)) {
            System.out.println("Reservation not found: " + reservationId);
            return;
        }

        String roomType = reservationRoomTypeMap.remove(reservationId);
        releasedRoomIds.push(reservationId);

        System.out.println("Booking cancelled for Reservation ID: " + reservationId +
                " | Room Type: " + roomType);
    }

    public void showRollbackHistory() {

        System.out.println("Recently Cancelled Reservations:");

        Stack<String> temp = (Stack<String>) releasedRoomIds.clone();

        while (!temp.isEmpty()) {
            System.out.println(temp.pop());
        }
    }
}

public class BookMyStayApp {

    public static void main(String[] args) {

        CancellationService service = new CancellationService();

        service.registerBooking("R101", "Single");
        service.registerBooking("R102", "Double");
        service.registerBooking("R103", "Suite");

        service.cancelBooking("R102");
        service.cancelBooking("R101");

        service.showRollbackHistory();
    }
}