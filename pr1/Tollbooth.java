package pr1;
import java.util.Scanner;

// (a) Define a record Vehicle
record Vehicle(String number, String type) {}

public class TollBooth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // (b) Running toll total and counters
        int totalToll = 0;
        int bikeCount = 0;
        int carCount = 0;
        int truckCount = 0;

        // (c) Loop until the user types “done” for the number
        while (true) {
            System.out.print("Enter vehicle number (or 'done' to exit): ");
            String number = scanner.next();
            
            if (number.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter vehicle type (bike, car, truck): ");
            String type = scanner.next().toLowerCase();

            // Build a Vehicle object
            Vehicle vehicle = new Vehicle(number, type);

            // Switch expression on type for the toll
            int toll = switch (vehicle.type()) {
                case "bike" -> 20;
                case "car" -> 50;
                case "truck" -> 150;
                default -> {
                    System.out.println("Unknown vehicle type! Applied 0 toll.");
                    yield 0;
                }
            };

            totalToll += toll;

            // Increment type's counter
            switch (vehicle.type()) {
                case "bike" -> bikeCount++;
                case "car" -> carCount++;
                case "truck" -> truckCount++;
            }
        }

        // (d) Print the total toll and the type with the highest count
        System.out.println("Total toll: " + totalToll);

        String mostFrequent = "none";
        int max = Math.max(bikeCount, Math.max(carCount, truckCount));

        if (max > 0) {
            if (max == carCount) mostFrequent = "car";
            else if (max == bikeCount) mostFrequent = "bike";
            else mostFrequent = "truck";
        }

        System.out.println("Most frequent: " + mostFrequent);
        scanner.close();
    }
}

