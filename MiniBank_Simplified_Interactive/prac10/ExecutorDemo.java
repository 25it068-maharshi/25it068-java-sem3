import java.util.Scanner;
import java.util.concurrent.*;

public class ExecutorDemo {
    public static void main(String[] args)throws Exception{
        Scanner sc=new Scanner(System.in);
        System.out.print("How many transactions? "); int n=sc.nextInt();
        ExecutorService pool=Executors.newFixedThreadPool(2);
        for(int i=1;i<=n;i++){
            System.out.print("Enter transaction amount "+i+": ");
            int amount=sc.nextInt();
            final int number=i;
            pool.submit(()->System.out.println("Transaction "+number+" processed: Rs. "+amount));
        }
        pool.shutdown();
        pool.awaitTermination(5,TimeUnit.SECONDS);
        System.out.println("All transactions completed.");
    }
}
