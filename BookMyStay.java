import java.util.*;

class BookingHistory {

    private List<String> confirmedReservations;

    public BookingHistory() {
        confirmedReservations = new ArrayList<>();
    }

    public void addReservation(String reservation) {
        confirmedReservations.add(reservation);
    }

    public List<String> getConfirmedReservations() {
        return confirmedReservations;
    }
}

class BookingReportService {

    public void generateReport(BookingHistory history) {

        List<String> reservations = history.getConfirmedReservations();

        System.out.println("Booking History Report");

        for (String r : reservations) {
            System.out.println(r);
        }
    }
}

public class BookMyStayApp {

    public static void main(String[] args) {

        BookingHistory history = new BookingHistory();

        history.addReservation("Abhi - Single");
        history.addReservation("Subha - Double");
        history.addReservation("Vanmathi - Suite");

        BookingReportService reportService = new BookingReportService();
        reportService.generateReport(history);
    }
}