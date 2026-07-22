import java.util.Scanner;

public class DivisionInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter dividend: ");
        float dividend = scanner.nextFloat();

        System.out.print("Enter divisor: ");
        float divisor = scanner.nextFloat();

        if (divisor == 0) {
            System.out.println("Error: Division by zero is not allowed.");
        } else {
            float quotient = dividend / divisor;
            float remainder = dividend % divisor;

            System.out.println("Quotient: " + quotient);
            System.out.println("Remainder: " + remainder);
        }

    }
}
