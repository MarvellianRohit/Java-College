import java.util.Scanner;

public class IncomeTaxCalculator {

    // Method to calculate income tax based on specified slab rates
    public static double calculateTax(double earnings) {
        double tax = 0.0;

        if (earnings <= 50000) {
            tax = 0.0;
        } else if (earnings <= 60000) {
            // 10% on additional amount above 50,000
            tax = (earnings - 50000) * 0.10;
        } else if (earnings <= 150000) {
            // 10% on (60,000 - 50,000) + 20% on additional amount above 60,000
            tax = (10000 * 0.10) + (earnings - 60000) * 0.20;
        } else {
            // 10% on (60,000 - 50,000) + 20% on (1,50,000 - 60,000) + 30% on additional
            // amount above 1,50,000
            tax = (10000 * 0.10) + (90000 * 0.20) + (earnings - 150000) * 0.30;
        }

        return tax;
    }

    public static void main(String[] args) {
        // Initialization of employee earnings
        String empName = "Rohit Chandra";
        double earnings = 200000.0; // Initialized earning value

        // Calculate income tax
        double tax = calculateTax(earnings);

        // Display income tax details
        System.out.println("==============================================");
        System.out.println("          EMPLOYEE INCOME TAX DETAILS         ");
        System.out.println("==============================================");
        System.out.println("Employee Name  : " + empName);
        System.out.println("Annual Earnings: Rs. " + earnings);
        System.out.println("Income Tax Due : Rs. " + tax);
        System.out.println("==============================================");

        // Optional input from user using Scanner
        Scanner sc = new Scanner(System.in);
        System.out.print("\nWould you like to calculate for custom input? (y/n): ");
        char input = sc.next().charAt(0);

        if (input == 'y' || input == 'Y') {
            sc.nextLine(); // Consume remaining newline
            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Annual Earnings (Rs): ");
            double customEarnings = sc.nextDouble();

            double customTax = calculateTax(customEarnings);

            System.out.println("\n--- Custom Employee Tax Details ---");
            System.out.println("Employee Name  : " + name);
            System.out.println("Annual Earnings: Rs. " + customEarnings);
            System.out.println("Income Tax Due : Rs. " + customTax);
            System.out.println("----------------------------------------------");
        }

    }
}

/*
Output:
==============================================
          EMPLOYEE INCOME TAX DETAILS         
==============================================
Employee Name  : Rohit Chandra
Annual Earnings: Rs. 200000.0
Income Tax Due : Rs. 34000.0
==============================================
*/

