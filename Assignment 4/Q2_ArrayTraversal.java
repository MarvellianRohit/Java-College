/*
 * Lab Assignment 4 - Question 2
 * 
 * Title: Traversing Arrays Using Loops
 * Objective: Traverse and display all elements of 1D and 2D arrays using loops.
 * 
 * Tasks:
 * 1. Input 10 integers from the user into a 1D array.
 * 2. Use a `for` loop to traverse and print all elements with their indices.
 * 3. Input a `3x3` matrix from the user.
 * 4. Use nested `for` loops to traverse and print the matrix in row-column format.
 */

import java.util.Scanner;

public class Q2_ArrayTraversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Task 1: Input 10 integers into a 1D array
        int[] arr1D = new int[10];
        System.out.println("=== 1D Array Input ===");
        System.out.println("Enter 10 integers for the 1D array:");
        for (int i = 0; i < arr1D.length; i++) {
            System.out.print("Element at index [" + i + "]: ");
            arr1D[i] = scanner.nextInt();
        }

        // Task 2: Traverse and print 1D array with indices
        System.out.println("\n=== 1D Array Traversal ===");
        System.out.println("Index\tValue");
        System.out.println("-----\t-----");
        for (int i = 0; i < arr1D.length; i++) {
            System.out.println("[" + i + "]\t" + arr1D[i]);
        }

        // Task 3: Input a 3x3 matrix from the user
        int[][] matrix = new int[3][3];
        System.out.println("\n=== 2D Array (3x3 Matrix) Input ===");
        System.out.println("Enter 9 elements for the 3x3 matrix:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Element at [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Task 4: Nested for loops to traverse and print in row-column format
        System.out.println("\n=== 2D Array (Matrix Format) ===");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        scanner.close();
    }
}

/*
 * Sample Output:
 * 
 * === 1D Array Input ===
 * Enter 10 integers for the 1D array:
 * Element at index [0]: 12
 * Element at index [1]: 25
 * Element at index [2]: 37
 * Element at index [3]: 41
 * Element at index [4]: 59
 * Element at index [5]: 63
 * Element at index [6]: 74
 * Element at index [7]: 88
 * Element at index [8]: 92
 * Element at index [9]: 100
 * 
 * === 1D Array Traversal ===
 * Index	Value
 * -----	-----
 * [0]	12
 * [1]	25
 * [2]	37
 * [3]	41
 * [4]	59
 * [5]	63
 * [6]	74
 * [7]	88
 * [8]	92
 * [9]	100
 * 
 * === 2D Array (3x3 Matrix) Input ===
 * Enter 9 elements for the 3x3 matrix:
 * Element at [0][0]: 1
 * Element at [0][1]: 2
 * Element at [0][2]: 3
 * Element at [1][0]: 4
 * Element at [1][1]: 5
 * Element at [1][2]: 6
 * Element at [2][0]: 7
 * Element at [2][1]: 8
 * Element at [2][2]: 9
 * 
 * === 2D Array (Matrix Format) ===
 * 1	2	3	
 * 4	5	6	
 * 7	8	9	
 */
