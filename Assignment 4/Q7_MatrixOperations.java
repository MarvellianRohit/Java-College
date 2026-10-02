/*
 * Lab Assignment 4 - Question 7
 * 
 * Title: Matrix Operations on 2D Arrays
 * Objective: Perform operations on multi-dimensional arrays.
 * 
 * Tasks:
 * 1. Input two `3x3` matrices from the user.
 * 2. Compute and display:
 *    - Sum of the two matrices.
 *    - Transpose of the first matrix.
 * 3. Traverse and print the diagonal elements of the first matrix.
 */

import java.util.Scanner;

public class Q7_MatrixOperations {

    // Utility function to print a 3x3 matrix
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix1 = new int[3][3];
        int[][] matrix2 = new int[3][3];

        // Task 1: Input two 3x3 matrices
        System.out.println("=== Enter elements for Matrix 1 (3x3) ===");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Matrix1[" + i + "][" + j + "]: ");
                matrix1[i][j] = scanner.nextInt();
            }
        }

        System.out.println("\n=== Enter elements for Matrix 2 (3x3) ===");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Matrix2[" + i + "][" + j + "]: ");
                matrix2[i][j] = scanner.nextInt();
            }
        }

        System.out.println("\n--- Matrix 1 ---");
        printMatrix(matrix1);

        System.out.println("\n--- Matrix 2 ---");
        printMatrix(matrix2);

        // Task 2a: Sum of the two matrices
        int[][] sumMatrix = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sumMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        System.out.println("\n=== 1. Sum of Matrix 1 and Matrix 2 ===");
        printMatrix(sumMatrix);

        // Task 2b: Transpose of the first matrix
        int[][] transposeMatrix = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                transposeMatrix[i][j] = matrix1[j][i];
            }
        }
        System.out.println("\n=== 2. Transpose of Matrix 1 ===");
        printMatrix(transposeMatrix);

        // Task 3: Diagonal elements of the first matrix
        System.out.println("\n=== 3. Diagonal Elements of Matrix 1 ===");
        System.out.print("Principal / Main Diagonal (i == j): ");
        for (int i = 0; i < 3; i++) {
            System.out.print(matrix1[i][i] + " ");
        }
        System.out.println();

        System.out.print("Secondary / Anti-Diagonal (i + j == 2): ");
        for (int i = 0; i < 3; i++) {
            System.out.print(matrix1[i][2 - i] + " ");
        }
        System.out.println();

        scanner.close();
    }
}

/*
 * Sample Output:
 * 
 * === Enter elements for Matrix 1 (3x3) ===
 * Matrix1[0][0]: 1
 * Matrix1[0][1]: 2
 * Matrix1[0][2]: 3
 * Matrix1[1][0]: 4
 * Matrix1[1][1]: 5
 * Matrix1[1][2]: 6
 * Matrix1[2][0]: 7
 * Matrix1[2][1]: 8
 * Matrix1[2][2]: 9
 * 
 * === Enter elements for Matrix 2 (3x3) ===
 * Matrix2[0][0]: 9
 * Matrix2[0][1]: 8
 * Matrix2[0][2]: 7
 * Matrix2[1][0]: 6
 * Matrix2[1][1]: 5
 * Matrix2[1][2]: 4
 * Matrix2[2][0]: 3
 * Matrix2[2][1]: 2
 * Matrix2[2][2]: 1
 * 
 * --- Matrix 1 ---
 * 1	2	3	
 * 4	5	6	
 * 7	8	9	
 * 
 * --- Matrix 2 ---
 * 9	8	7	
 * 6	5	4	
 * 3	2	1	
 * 
 * === 1. Sum of Matrix 1 and Matrix 2 ===
 * 10	10	10	
 * 10	10	10	
 * 10	10	10	
 * 
 * === 2. Transpose of Matrix 1 ===
 * 1	4	7	
 * 2	5	8	
 * 3	6	9	
 * 
 * === 3. Diagonal Elements of Matrix 1 ===
 * Principal / Main Diagonal (i == j): 1 5 9 
 * Secondary / Anti-Diagonal (i + j == 2): 3 5 7 
 */
