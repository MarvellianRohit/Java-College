/*
 * Q1: Create a person inherit two classes from it politician & sportsman provide constructors &
 * calculate salary & display functions.
 */

class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    void display() {
        System.out.println("Name: " + name);
    }
}

class Politician extends Person {
    double baseSalary;
    double allowance;

    Politician(String name, double baseSalary, double allowance) {
        super(name);
        this.baseSalary = baseSalary;
        this.allowance = allowance;
    }

    double calculateSalary() {
        return baseSalary + allowance;
    }

    @Override
    void display() {
        super.display();
        System.out.println("Role: Politician");
        System.out.println("Total Salary: Rs. " + calculateSalary());
    }
}

class Sportsman extends Person {
    double matchFee;
    int matchesPlayed;

    Sportsman(String name, double matchFee, int matchesPlayed) {
        super(name);
        this.matchFee = matchFee;
        this.matchesPlayed = matchesPlayed;
    }

    double calculateSalary() {
        return matchFee * matchesPlayed;
    }

    @Override
    void display() {
        super.display();
        System.out.println("Role: Sportsman");
        System.out.println("Total Salary: Rs. " + calculateSalary());
    }
}

public class Q1_PersonInheritance {
    public static void main(String[] args) {
        Politician p = new Politician("Rajesh Sharma", 50000, 15000);
        Sportsman s = new Sportsman("Virat Verma", 20000, 5);

        p.display();
        System.out.println();
        s.display();
    }
}

/*
Output:
Name: Rajesh Sharma
Role: Politician
Total Salary: Rs. 65000.0

Name: Virat Verma
Role: Sportsman
Total Salary: Rs. 100000.0
*/

