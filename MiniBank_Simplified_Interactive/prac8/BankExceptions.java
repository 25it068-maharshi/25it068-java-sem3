import java.util.Scanner;
class InsufficientFundsException extends Exception {
    InsufficientFundsException(String message){super(message);}
}
class Account {
    long balance;
    Account(long balance){this.balance=balance;}
    void withdraw(long amount)throws InsufficientFundsException{
        if(amount<=0) throw new IllegalArgumentException("Amount must be positive");
        if(amount>balance) throw new InsufficientFundsException("Not enough balance");
        balance-=amount;
    }
}
public class BankExceptions {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Opening balance: "); Account a=new Account(sc.nextLong());
        System.out.print("Withdrawal amount: "); long amount=sc.nextLong();
        try{
            a.withdraw(amount);
            System.out.println("Withdrawal successful.");
        }catch(InsufficientFundsException e){
            System.out.println(e.getMessage());
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Remaining balance: Rs. "+a.balance);
    }
}
