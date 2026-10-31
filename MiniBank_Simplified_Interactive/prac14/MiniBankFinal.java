import java.util.*;
import java.util.Scanner;

class Account {
    String owner; long balance;
    Account(String owner,long balance){this.owner=owner;this.balance=balance;}
    void deposit(long amount){
        if(amount<=0) throw new IllegalArgumentException("Amount must be positive");
        balance+=amount;
    }
    void withdraw(long amount){
        if(amount<=0 || amount>balance) throw new IllegalArgumentException("Invalid withdrawal");
        balance-=amount;
    }
}
class BankService {
    private List<Account> accounts=new ArrayList<>();
    void add(Account a){accounts.add(a);}
    Account find(String owner){
        for(Account a:accounts) if(a.owner.equalsIgnoreCase(owner)) return a;
        return null;
    }
}
public class MiniBankFinal {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        BankService bank=new BankService();
        System.out.print("Customer name: "); String name=sc.nextLine();
        System.out.print("Opening balance: "); long opening=sc.nextLong();
        bank.add(new Account(name,opening));
        System.out.print("Deposit amount: "); long amount=sc.nextLong();
        Account a=bank.find(name);
        try{a.deposit(amount);System.out.println("Deposit successful.");}
        catch(IllegalArgumentException e){System.out.println(e.getMessage());}
        System.out.println("Accounts: 1");
        System.out.println(a.owner+" balance: Rs. "+a.balance);
    }
}
