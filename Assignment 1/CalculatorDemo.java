// CalculatorDemo.java

// Class with methods for arithmetic operations
class Calculator {

    // Method for addition
    public int add(int a, int b) {
        return a + b;
    }

    // Method for subtraction
    public int subtract(int a, int b) {
        return a - b;
    }

    // Method for multiplication
    public int multiply(int a, int b) {
        return a * b;
    }

    // Method for division
    public double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Cannot divide by zero!");
            return 0;
        }
        return a / b;
    }
}

// Main class
public class CalculatorDemo {
    public static void main(String[] args) {
        // Create object of Calculator class
        Calculator calc = new Calculator();

        int a = 20;
        int b = 5;

        // Calling methods and displaying output
        System.out.println("Addition: " + calc.add(a, b));
        System.out.println("Subtraction: " + calc.subtract(a, b));
        System.out.println("Multiplication: " + calc.multiply(a, b));
        System.out.println("Division: " + calc.divide(a, b));
    }
}

/*
Output:
Addition: 25
Subtraction: 15
Multiplication: 100
Division: 4.0
*/

