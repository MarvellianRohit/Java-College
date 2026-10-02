/*
 * Lab Assignment 4 - Question 1
 * 
 * Title: Declaration, Initialization, and Accessing Elements
 * Objective: Practice declaring and initializing single-dimensional and 2D arrays, and accessing individual elements.
 * 
 * Tasks:
 * 1. Declare a single-dimensional integer array of size 5 and initialize it with values {10, 20, 30, 40, 50}.
 * 2. Declare a 2D integer array of size 3x3 and initialize it with values:
 *    1 2 3
 *    4 5 6
 *    7 8 9
 * 3. Access and print:
 *    - The 3rd element of the 1D array.
 *    - The element at row 2, column 3 of the 2D array.
 */

public class Q1_ArrayDeclarationAccess {
    public static void main(String[] args) {
        // Task 1: Declare and initialize 1D array of size 5
        int[] oneDArray = {10, 20, 30, 40, 50};

        // Task 2: Declare and initialize 2D array of size 3x3
        int[][] twoDArray = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // Displaying the 1D Array
        System.out.println("--- 1D Array Elements ---");
        for (int i = 0; i < oneDArray.length; i++) {
            System.out.print(oneDArray[i] + " ");
        }
        System.out.println("\n");

        // Displaying the 2D Array (Matrix)
        System.out.println("--- 2D Array (3x3 Matrix) ---");
        for (int i = 0; i < twoDArray.length; i++) {
            for (int j = 0; j < twoDArray[i].length; j++) {
                System.out.print(twoDArray[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        // Task 3: Access and print specified elements
        System.out.println("--- Accessing Specific Elements ---");
        // 3rd element of 1D array (index 2 in 0-based indexing)
        int thirdElement = oneDArray[2];
        System.out.println("3rd element of the 1D array (index 2): " + thirdElement);

        // Element at row 2, column 3 of 2D array (row index 1, column index 2 in 0-based indexing)
        int matrixElement = twoDArray[1][2];
        System.out.println("Element at row 2, column 3 of the 2D array (matrix[1][2]): " + matrixElement);
    }
}

/*
 * Sample Output:
 * 
 * --- 1D Array Elements ---
 * 10 20 30 40 50 
 * 
 * --- 2D Array (3x3 Matrix) ---
 * 1 2 3 
 * 4 5 6 
 * 7 8 9 
 * 
 * --- Accessing Specific Elements ---
 * 3rd element of the 1D array (index 2): 30
 * Element at row 2, column 3 of the 2D array (matrix[1][2]): 6
 */
