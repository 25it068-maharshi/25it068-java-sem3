import java.util.*;
import java.util.Scanner;

class Repository<T> {
    private Map<String,T> data=new HashMap<>();
    void save(String id,T item){data.put(id,item);}
    T find(String id){return data.get(id);}
    int size(){return data.size();}
}
public class RepositoryDemo {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Repository<String> customers=new Repository<>();
        System.out.print("How many customers? "); int n=sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.print("Customer ID: "); String id=sc.next();
            System.out.print("Customer name: "); String name=sc.next();
            customers.save(id,name);
        }
        System.out.print("Search customer ID: "); String search=sc.next();
        System.out.println("Customer found: "+customers.find(search));
        System.out.println("Total saved: "+customers.size());
    }
}
