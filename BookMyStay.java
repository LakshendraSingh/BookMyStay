import java.io.*;
import java.util.*;

class FilePersistenceService {

    public void saveInventory(Map<String, Integer> inventory, String filePath) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
                writer.write(entry.getKey() + "=" + entry.getValue());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving inventory.");
        }
    }

    public void loadInventory(Map<String, Integer> inventory, String filePath) {

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split("=");
                String roomType = parts[0];
                int count = Integer.parseInt(parts[1]);

                inventory.put(roomType, count);
            }

        } catch (IOException e) {
            System.out.println("Error loading inventory.");
        }
    }
}

public class BookMyStayApp {

    public static void main(String[] args) {

        Map<String, Integer> inventory = new HashMap<>();

        inventory.put("Single", 5);
        inventory.put("Double", 3);
        inventory.put("Suite", 2);

        FilePersistenceService service = new FilePersistenceService();

        String filePath = "inventory.txt";

        service.saveInventory(inventory, filePath);

        inventory.clear();

        service.loadInventory(inventory, filePath);

        System.out.println("Recovered Inventory:");

        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}