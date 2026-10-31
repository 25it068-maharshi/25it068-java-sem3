import java.util.Scanner;
interface Transactable {
    void deposit(long amount);
    boolean withdraw(long amount);
}
@FunctionalInterface
interface WithdrawRule {
    boolean allow(long balance,long amount);
}
class SimpleAccount implements Transactable {
    long balance;
    SimpleAccount(long balance){this.balance=balance;}
    public void deposit(long amount){if(amount>0)balance+=amount;}
    public boolean withdraw(long amount){
        if(amount>0 && amount<=balance){balance-=amount;return true;}
        return false;
    }
}
public class InterfacesDemo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Opening balance: "); long opening=sc.nextLong();
        SimpleAccount a=new SimpleAccount(opening);
        System.out.print("Deposit amount: "); a.deposit(sc.nextLong());
        System.out.print("Withdrawal amount: "); long amount=sc.nextLong();
        WithdrawRule rule=(balance,value)->value>0 && value<=balance;
        System.out.println("Withdrawal allowed: "+rule.allow(a.balance,amount));
        if(rule.allow(a.balance,amount)) a.withdraw(amount);
        System.out.println("Final balance: Rs. "+a.balance);
    }
}
