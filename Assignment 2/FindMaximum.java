
public class FindMaximum {
    public static void main(String[] args) {
        // Check if command line arguments are passed
        if (args.length == 0) {
            System.out.println("Please provide numbers as command line arguments.");
            System.out.println("Example: java FindMaximum 12 45 8 99 23");
            return;
        }

        // Initialize maximum with the first argument
        int max = Integer.valueOf(args[0]);

        // Loop through the remaining arguments to find the maximum
        for (int i = 1; i < args.length; i++) {
            int num = Integer.valueOf(args[i]);
            if (num > max) {
                max = num;
            }
        }

        // Display input numbers
        System.out.print("Input Numbers: ");
        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i] + (i < args.length - 1 ? ", " : ""));
        }
        System.out.println();

        // Print maximum number
        System.out.println("Maximum Number: " + max);
    }
}

/*
Output (Example: java FindMaximum 12 45 8 99 23):
Input Numbers: 12, 45, 8, 99, 23
Maximum Number: 99
*/

