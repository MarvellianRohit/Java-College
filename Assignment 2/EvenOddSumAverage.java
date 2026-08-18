// Assignment 3/EvenOddSumAverage.java

public class EvenOddSumAverage {
    public static void main(String[] args) {
        // Check if command line arguments are provided
        if (args.length == 0) {
            System.out.println("Please provide numbers as command line arguments.");
            System.out.println("Example: java EvenOddSumAverage 1 2 3 4 5 6 7 8 9 10");
            return;
        }

        int sumEven = 0;
        int countEven = 0;

        int sumOdd = 0;
        int countOdd = 0;

        // Loop through all command line arguments
        for (int i = 0; i < args.length; i++) {
            int num = Integer.valueOf(args[i]);

            if (num % 2 == 0) {
                sumEven += num;
                countEven++;
            } else {
                sumOdd += num;
                countOdd++;
            }
        }

        // Display input numbers
        System.out.print("Input Numbers: ");
        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i] + (i < args.length - 1 ? ", " : ""));
        }
        System.out.println();
        System.out.println("----------------------------------------------");

        // Display Even Numbers Sum and Average
        System.out.println("EVEN NUMBERS:");
        System.out.println("Sum of Even Numbers    : " + sumEven);
        if (countEven > 0) {
            double avgEven = (double) sumEven / countEven;
            System.out.println("Average of Even Numbers: " + avgEven);
        } else {
            System.out.println("Average of Even Numbers: N/A (No even numbers entered)");
        }

        System.out.println("----------------------------------------------");

        // Display Odd Numbers Sum and Average
        System.out.println("ODD NUMBERS:");
        System.out.println("Sum of Odd Numbers     : " + sumOdd);
        if (countOdd > 0) {
            double avgOdd = (double) sumOdd / countOdd;
            System.out.println("Average of Odd Numbers : " + avgOdd);
        } else {
            System.out.println("Average of Odd Numbers : N/A (No odd numbers entered)");
        }

        System.out.println("----------------------------------------------");
    }
}
