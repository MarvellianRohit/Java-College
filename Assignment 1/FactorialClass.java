
/*
 * Question: Write a Java program using an OOP approach (creating a separate class FactorialCalculator 
 * and object) to calculate the factorial of a user-given number.
 */

import java.util.Scanner;

// Class 1: Contains method to calculate factorial
class FactorialCalculator {

    // Method to find factorial of a number
    public long findFactorial(int n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }
}

// Class 2: Main class
public class FactorialClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create object of FactorialCalculator class
        FactorialCalculator calc = new FactorialCalculator();

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        // Call method using object
        long result = calc.findFactorial(num);

        System.out.println("Factorial of " + num + " is: " + result);

        sc.close();
    }
}

/*
Output:
Enter a number: 5
Factorial of 5 is: 120
*/

