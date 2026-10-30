/*
 * Q2: Create an abstract class employee, having its properties & abstract function for calculating net
 * salary and displaying the information. Drive manager & clerk class from this abstract class &
 * implement the abstract method net salary and override the display method.
 */

abstract class AbstractEmployee {
    int id;
    String name;
    double basicSalary;

    AbstractEmployee(int id, String name, double basicSalary) {
        this.id = id;
        this.name = name;
        this.basicSalary = basicSalary;
    }

    abstract double calculateNetSalary();

    void display() {
        System.out.println("ID: " + id + ", Name: " + name);
    }
}

class ManagerEmp extends AbstractEmployee {
    double allowance;

    ManagerEmp(int id, String name, double basicSalary, double allowance) {
        super(id, name, basicSalary);
        this.allowance = allowance;
    }

    @Override
    double calculateNetSalary() {
        return basicSalary + allowance;
    }

    @Override
    void display() {
        super.display();
        System.out.println("Designation: Manager");
        System.out.println("Net Salary: Rs. " + calculateNetSalary());
    }
}

class Clerk extends AbstractEmployee {
    double overtimePay;

    Clerk(int id, String name, double basicSalary, double overtimePay) {
        super(id, name, basicSalary);
        this.overtimePay = overtimePay;
    }

    @Override
    double calculateNetSalary() {
        return basicSalary + overtimePay;
    }

    @Override
    void display() {
        super.display();
        System.out.println("Designation: Clerk");
        System.out.println("Net Salary: Rs. " + calculateNetSalary());
    }
}

public class Q2_AbstractEmployee {
    public static void main(String[] args) {
        ManagerEmp m = new ManagerEmp(101, "Amit", 60000, 12000);
        Clerk c = new Clerk(102, "Rohan", 25000, 3000);

        m.display();
        System.out.println();
        c.display();
    }
}

/*
Output:
ID: 101, Name: Amit
Designation: Manager
Net Salary: Rs. 72000.0

ID: 102, Name: Rohan
Designation: Clerk
Net Salary: Rs. 28000.0
*/

