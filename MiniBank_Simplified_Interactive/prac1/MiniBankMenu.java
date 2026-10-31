import java.util.Scanner;

public class MiniBankMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1. Open Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = sc.next();
                    System.out.print("Enter opening balance: ");
                    long balance = sc.nextLong();
                    System.out.println("Account created for " + name);
                    System.out.println("Opening balance: Rs. " + balance);
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    long deposit = sc.nextLong();
                    System.out.println("Deposit request received: Rs. " + deposit);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    long withdrawal = sc.nextLong();
                    System.out.println("Withdrawal request received: Rs. " + withdrawal);
                    break;
                case 4:
                    System.out.println("Thank you for using MiniBank.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);
        sc.close();
    }
}
