/*
 * Question: Write a Java program to calculate the factorial of a given number using a loop.
 */

public class factorial{
    public static void main(String[] args){
        int num=10;
        long factorial=1;
        for(int i=1;i<=num;i++){
            factorial *=i;
            }
            System.out.printf("factorial of %d = %d%n", num, factorial);
    }
}

/*
Output:
factorial of 10 = 3628800
*/

