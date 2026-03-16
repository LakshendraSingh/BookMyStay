import java.util.*;

class ConcurrentBookingProcessor implements Runnable {

    private Queue<String> bookingQueue;
    private Map<String, Integer> inventory;

    public ConcurrentBookingProcessor(Queue<String> bookingQueue, Map<String, Integer> inventory) {
        this.bookingQueue = bookingQueue;
        this.inventory = inventory;
    }

    @Override
    public void run() {

        while (true) {

            String reservation;

            synchronized (bookingQueue) {
                if (bookingQueue.isEmpty()) {
                    break;
                }
                reservation = bookingQueue.poll();
            }

            String[] data = reservation.split("-");
            String guestName = data[0];
            String roomType = data[1];

            synchronized (inventory) {

                int available = inventory.getOrDefault(roomType, 0);

                if (available > 0) {
                    inventory.put(roomType, available - 1);
                    System.out.println(Thread.currentThread().getName() +
                            " allocated " + roomType + " room to " + guestName);
                } else {
                    System.out.println("No " + roomType + " rooms available for " + guestName);
                }
            }
        }
    }
}

public class BookMyStayApp {

    public static void main(String[] args) {

        Queue<String> bookingQueue = new LinkedList<>();
        Map<String, Integer> inventory = new HashMap<>();

        inventory.put("Single", 2);
        inventory.put("Double", 1);
        inventory.put("Suite", 1);

        bookingQueue.offer("Abhi-Single");
        bookingQueue.offer("Subha-Double");
        bookingQueue.offer("Vanmathi-Suite");
        bookingQueue.offer("Kiran-Single");

        Thread t1 = new Thread(new ConcurrentBookingProcessor(bookingQueue, inventory));
        Thread t2 = new Thread(new ConcurrentBookingProcessor(bookingQueue, inventory));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread execution interrupted.");
        }
    }
}