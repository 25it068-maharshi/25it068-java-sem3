import java.util.Objects;
import java.util.Scanner;

class Account {
    String number, owner;
    long balance;
    Account(String n,String o,long b){number=n;owner=o;balance=b;}
    public String toString(){return number+" "+owner+" Rs."+balance;}
    public boolean equals(Object obj){
        if(!(obj instanceof Account)) return false;
        Account other=(Account)obj;
        return number.equals(other.number);
    }
    public int hashCode(){return Objects.hash(number);}
}
class Customer {
    static class Address {
        String city;
        Address(String city){this.city=city;}
    }
}
public class AccountObjects {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter account number: "); String no=sc.nextLine();
        System.out.print("Enter owner name: "); String owner=sc.nextLine();
        System.out.print("Enter balance: "); long balance=sc.nextLong();
        Account a=new Account(no,owner,balance);
        Account b=new Account(no,"Another Name",100);
        System.out.println("Account: "+a);
        System.out.println("Same account number? "+a.equals(b));
        sc.nextLine();
        System.out.print("Enter city: "); String city=sc.nextLine();
        Customer.Address address=new Customer.Address(city);
        System.out.println("Customer city: "+address.city);
    }
}
