
// FibonacciDemo.java
import java.util.Scanner;

// Class 1: Contains method to generate Fibonacci series
class FibonacciGenerator {

    // Method to print Fibonacci series up to n terms
    public void printFibonacci(int n) {
        int first = 0, second = 1;

        System.out.print("Fibonacci Series: ");

        for (int i = 1; i <= n; i++) {
            System.out.print(first + " ");

            // Calculate next term
            int next = first + second;
            first = second;
            second = next;
        }
        System.out.println();
    }
}

// Class 2: Main class
public class FibonacciClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create object of FibonacciGenerator class
        FibonacciGenerator fg = new FibonacciGenerator();

        System.out.print("Enter number of terms: ");
        int terms = sc.nextInt();

        // Call method using object
        fg.printFibonacci(terms);

        sc.close();
    }
}
