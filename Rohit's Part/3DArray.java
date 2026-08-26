class Main {
    public static void main(String args[]) {
        int[][][] number = new int[2][3][4];
        int value = 1;

        for (int i = 0; i < number.length; i++) {
            for (int j = 0; j < number[i].length; j++) {
                for (int k = 0; k < number[i][j].length; k++) {
                    number[i][j][k] = value++;
                }
            }
        }

        System.out.println("Output: ");

        for (int i = 0; i < number.length; i++) {
            System.out.println("Part 1:  " + i);
            for (int j = 0; j < number[i].length; j++) {
                for (int k = 0; k < number[i][j].length; k++) {
                    System.out.print(number[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}

/*
Output:
Output: 
Part 1:  0
1 2 3 4 
5 6 7 8 
9 10 11 12 

Part 1:  1
13 14 15 16 
17 18 19 20 
21 22 23 24 
*/

