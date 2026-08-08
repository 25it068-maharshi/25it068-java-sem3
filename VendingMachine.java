package pr1;
import java.util.Scanner;

// (a) Define an enum Coin with constants
enum Coin {
    ONE, TWO, FIVE, TEN
}

public class VendingMachine {
    public static void main(String[] args) {
        // (b) Set snack price, running total, and Scanner
        int snackPrice = 15;
        int total = 0;
        Scanner scanner = new Scanner(System.in);

        // (d) Stop the loop once the total reaches 15 or more
        while (total < snackPrice) {
            System.out.print("Enter coin name (ONE, TWO, FIVE, TEN): ");
            String input = scanner.next().toUpperCase();

            try {
                Coin coin = Coin.valueOf(input);

                // (c) Switch expression to convert Coin to value
                int value = switch (coin) {
                    case ONE -> 1;
                    case TWO -> 2;
                    case FIVE -> 5;
                    case TEN -> 10;
                };

                total += value;
                System.out.println("Total so far: " + total);

            } catch (IllegalArgumentException e) {
                System.out.println("Invalid coin name! Try again.");
            }
        }

        // (e) Print the change to return
        System.out.println("Paid. Change: " + (total - snackPrice));
        scanner.close();
    }
}
