abstract class Employee {
    String name;
    int id;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    abstract double monthlySalary();
}

class FullTime extends Employee {
    double fixedSalary;

    FullTime(String name, int id, double fixedSalary) {
        super(name, id);
        this.fixedSalary = fixedSalary;
    }

    double monthlySalary() {
        return fixedSalary;
    }
}

class PartTime extends Employee {
    int hours;
    double rate;

    PartTime(String name, int id, int hours, double rate) {
        super(name, id);
        this.hours = hours;
        this.rate = rate;
    }

    double monthlySalary() {
        return hours * rate;
    }
}

class Intern extends Employee {
    double stipend;

    Intern(String name, int id, double stipend) {
        super(name, id);
        this.stipend = stipend;
    }

    double monthlySalary() {
        return stipend;
    }
}

public class PayrollDemo {
    public static void main(String[] args) {

        Employee[] employees = {
            new FullTime("Maharshi", 101, 50000),
            new PartTime("Rahul", 102, 80, 250),
            new Intern("Priya", 103, 12000),
            new FullTime("Amit", 104, 60000)
        };

        double totalPayroll = 0;

        System.out.println("Employee Payroll:");

        for (Employee emp : employees) {
            double salary = emp.monthlySalary(); // polymorphism

            System.out.println(
                "ID: " + emp.id +
                ", Name: " + emp.name +
                ", Salary: ₹" + salary
            );

            if (emp instanceof Intern) {
                System.out.println("   Note: Intern receives a stipend.");
            }

            totalPayroll += salary;
        }

        System.out.println("\nTotal Payroll = ₹" + totalPayroll);
    }
}