/**
 * Hotel Booking Management System
 *
 * <p>This class represents the entry point of the Book My Stay application.
 * It demonstrates how a Java program begins execution using the main() method
 * and displays a welcome message to the console.</p>
 *
 * <p>This is the first use case in the incremental development of the
 * Hotel Booking Management System.</p>
 *
 * @author Student
 * @version 1.0
 */

public class UseCase1HotelBookingApp {

    /**
     * Entry point of the application.
     * The JVM starts execution from this method.
     *
     * @param args command-line arguments passed during program execution
     */
    public static void main(String[] args) {

        // Application name and version
        String appName = "Book My Stay";
        String version = "v1.0";

        // Welcome message
        System.out.println("====================================");
        System.out.println("      Welcome to " + appName);
        System.out.println("      Hotel Booking System " + version);
        System.out.println("====================================");
        System.out.println("Application started successfully.");
        System.out.println("Thank you for using Book My Stay.");
    }
}