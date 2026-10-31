import java.util.Scanner;
abstract class Account {
    long balance;
    Account(long b){balance=b;}
    abstract double interestRate();
    abstract boolean canWithdraw(long amount);
}
class SavingsAccount extends Account {
    SavingsAccount(long b){super(b);}
    double interestRate(){return 4.0;}
    boolean canWithdraw(long amount){return balance-amount>=500;}
}
class CurrentAccount extends Account {
    CurrentAccount(long b){super(b);}
    double interestRate(){return 0.0;}
    boolean canWithdraw(long amount){return balance-amount>=-1000;}
}
class FixedDepositAccount extends Account {
    FixedDepositAccount(long b){super(b);}
    double interestRate(){return 7.0;}
    boolean canWithdraw(long amount){return false;}
}
public class AccountTypes {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter savings balance: "); long s=sc.nextLong();
        System.out.print("Enter current account balance: "); long c=sc.nextLong();
        System.out.print("Enter fixed deposit balance: "); long f=sc.nextLong();
        Account[] accounts={new SavingsAccount(s),new CurrentAccount(c),new FixedDepositAccount(f)};
        String[] names={"Savings","Current","Fixed Deposit"};
        for(int i=0;i<accounts.length;i++)
            System.out.println(names[i]+": interest "+accounts[i].interestRate()+"%, can withdraw Rs.100? "+accounts[i].canWithdraw(100));
    }
}
