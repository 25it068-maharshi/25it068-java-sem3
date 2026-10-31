import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.Scanner;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Positive { }
class Account {
    @Positive private int balance;
    Account(int balance){this.balance=balance;}
}
public class AnnotationDemo {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter account balance: ");
        Account a=new Account(sc.nextInt());
        for(Field f:a.getClass().getDeclaredFields()){
            if(f.isAnnotationPresent(Positive.class)){
                f.setAccessible(true);
                int value=f.getInt(a);
                if(value<0) System.out.println(f.getName()+" must be positive.");
                else System.out.println("Validation passed. Balance: "+value);
            }
        }
    }
}
