import java.util.Scanner;

class Customer {
    private String name, email, mobile;
    private final String customerId;
    Customer(String id, String name, String email, String mobile) {
        customerId=id; this.name=name; this.email=email; this.mobile=mobile;
    }
    String getName() { return name; }
    String getCustomerId() { return customerId; }
}
class Account {
    private final String number;
    private String owner;
    private long balance;
    Account(String number, String owner, long balance) {
        this.number=number; this.owner=owner; this.balance=balance;
    }
    void deposit(long amount) { if(amount>0) balance+=amount; }
    boolean withdraw(long amount) {
        if(amount>0 && amount<=balance) { balance-=amount; return true; }
        return false;
    }
    long getBalance() { return balance; }
}
public class AccountDemo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Customer name: "); String name=sc.nextLine();
        System.out.print("Email: "); String email=sc.nextLine();
        System.out.print("Mobile: "); String mobile=sc.nextLine();
        Customer c=new Customer("CUST101",name,email,mobile);
        System.out.print("Opening balance: "); long amount=sc.nextLong();
        Account a=new Account("ACC101",c.getName(),amount);
        System.out.print("Deposit amount: "); a.deposit(sc.nextLong());
        System.out.println("Customer ID: "+c.getCustomerId());
        System.out.println("Account holder: "+c.getName());
        System.out.println("Current balance: Rs. "+a.getBalance());
    }
}
