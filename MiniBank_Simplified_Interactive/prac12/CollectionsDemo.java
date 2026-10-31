import java.util.*;
import java.util.Scanner;

public class CollectionsDemo {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Map<String,Integer> accounts=new HashMap<>();
        System.out.print("How many accounts? "); int n=sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.print("Account number: "); String id=sc.next();
            System.out.print("Balance: "); int balance=sc.nextInt();
            accounts.put(id,balance);
        }
        List<Map.Entry<String,Integer>> list=new ArrayList<>(accounts.entrySet());
        list.sort((a,b)->b.getValue()-a.getValue());
        System.out.println("Accounts sorted by balance:");
        for(Map.Entry<String,Integer> e:list)
            System.out.println(e.getKey()+" Rs. "+e.getValue());
    }
}
