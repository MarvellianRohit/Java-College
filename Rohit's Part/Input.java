import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value for Integer Variable: ");
        int r = sc.nextInt();
        System.out.println("Enter the value for the Float Variable: ");
        float a = sc.nextFloat();
        System.out.println("Enter the value for the Double Variable: ");
        double b = sc.nextDouble();
        System.out.println("Enter the value for Character Variable: ");
        char c = sc.next().charAt(0);

        System.out.println("Enter the value for String Variable: ");
        String d = sc.nextLine();
        System.out.println("Enter the value of Boolean Variable: ");
        boolean e = sc.nextBoolean();

        System.out.println("The Integer Value is: " + r);
        System.out.println("The Float value is: " + a);
        System.out.println("The Double value is: " + b);
        System.out.println("The Character Value is: " + c);
        System.out.println("The  String Value is: " + d);
        System.out.println("The  Boolean Value is: " + e);

    }
}
