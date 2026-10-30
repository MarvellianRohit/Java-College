/*
 * Q9: Create a base class Employee with attributes id, name, and baseSalary. Derive a subclass
 * Manager that adds bonus. Use the super keyword in the Manager constructor to pass data to the
 * parent constructor and use super to invoke the parent's displayDetails() method.
 */

class Employee {
    int id;
    String name;
    double baseSalary;

    Employee(int id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    void displayDetails() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: Rs. " + baseSalary);
    }
}

class Manager extends Employee {
    double bonus;

    Manager(int id, String name, double baseSalary, double bonus) {
        super(id, name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Bonus: Rs. " + bonus);
        System.out.println("Total Salary: Rs. " + (baseSalary + bonus));
    }
}

public class Q9_SuperKeywordEmployee {
    public static void main(String[] args) {
        Manager mgr = new Manager(201, "Neha Verma", 55000, 10000);
        mgr.displayDetails();
    }
}

/*
Output:
Employee ID: 201
Name: Neha Verma
Base Salary: Rs. 55000.0
Bonus: Rs. 10000.0
Total Salary: Rs. 65000.0
*/

