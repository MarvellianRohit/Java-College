public class JaggedArray {
    public static void main(String[] args) {
        // Dynamically initialize 2D array with 4 rows
        int[][] arr = new int[4][];

        // Dynamically allocate memory for each row with decreasing lengths (4, 3, 2, 1)
        for (int i = 0; i < 4; i++) {
            arr[i] = new int[4 - i];
        }

        // Store the values into the array
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (i + 1) * (j + 1);
            }
        }

        // Display the array elements
        System.out.println("Output:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}

/*
Output:
1 2 3 4 
2 4 6 
3 6 
4 
*/

