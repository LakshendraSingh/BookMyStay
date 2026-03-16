import java.util.*;

class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) {
        super(message);
    }
}

class ReservationValidator {

    public void validate(String guestName, String roomType) throws InvalidBookingException {

        if (guestName == null || guestName.trim().isEmpty()) {
            throw new InvalidBookingException("Guest name cannot be empty");
        }

        if (roomType == null || roomType.trim().isEmpty()) {
            throw new InvalidBookingException("Room type cannot be empty");
        }

        if (!roomType.equalsIgnoreCase("Single") &&
                !roomType.equalsIgnoreCase("Double") &&
                !roomType.equalsIgnoreCase("Suite")) {

            throw new InvalidBookingException("Invalid room type selected");
        }
    }
}

public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Booking Validation");

        Scanner scanner = new Scanner(System.in);
        ReservationValidator validator = new ReservationValidator();

        try {

            System.out.print("Enter Guest Name: ");
            String guestName = scanner.nextLine();

            System.out.print("Enter Room Type (Single/Double/Suite): ");
            String roomType = scanner.nextLine();

            validator.validate(guestName, roomType);

            System.out.println("Booking request accepted for " + guestName +
                    " - " + roomType + " room.");

        } catch (InvalidBookingException e) {

            System.out.println("Booking failed: " + e.getMessage());

        } finally {
            scanner.close();
        }
    }
}