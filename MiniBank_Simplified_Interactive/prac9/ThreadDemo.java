import java.util.Scanner;
class Account {
    private int balance;
    Account(int balance){this.balance=balance;}
    synchronized void deposit(int amount){balance+=amount;}
    int getBalance(){return balance;}
}
class Worker extends Thread {
    Account account; int amount;
    Worker(Account a,int amount){account=a;this.amount=amount;}
    public void run(){account.deposit(amount);}
}
public class ThreadDemo {
    public static void main(String[] args)throws Exception{
        Scanner sc=new Scanner(System.in);
        System.out.print("Opening balance: "); Account a=new Account(sc.nextInt());
        System.out.print("Deposit by thread 1: "); int x=sc.nextInt();
        System.out.print("Deposit by thread 2: "); int y=sc.nextInt();
        Worker t1=new Worker(a,x),t2=new Worker(a,y);
        t1.start();t2.start();t1.join();t2.join();
        System.out.println("Both threads completed.");
        System.out.println("Final balance: Rs. "+a.getBalance());
    }
}
