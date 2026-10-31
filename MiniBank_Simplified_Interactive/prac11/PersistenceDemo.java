import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

class Account implements Serializable {
    String owner; long balance;
    Account(String owner,long balance){this.owner=owner;this.balance=balance;}
}
public class PersistenceDemo {
    public static void main(String[] args)throws Exception{
        Scanner sc=new Scanner(System.in);
        System.out.print("Account holder: "); String owner=sc.nextLine();
        System.out.print("Account balance: "); long balance=sc.nextLong();
        Account a=new Account(owner,balance);
        Path file=Paths.get("account.dat");
        try(ObjectOutputStream out=new ObjectOutputStream(Files.newOutputStream(file))){
            out.writeObject(a);
        }
        try(ObjectInputStream in=new ObjectInputStream(Files.newInputStream(file))){
            Account copy=(Account)in.readObject();
            System.out.println("Restored owner: "+copy.owner);
            System.out.println("Restored balance: Rs. "+copy.balance);
        }
        Files.deleteIfExists(file);
    }
}
