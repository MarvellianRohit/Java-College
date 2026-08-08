// StarPattern.java

// Class 1: Contains method to print pattern
class PatternPrinter {

    // Method to display star pattern
    public void printPattern() {
        // Upper half (1 to 4 stars)
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Lower half (3 down to 1 star)
        for (int i = 3; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

// Class 2: Main class
public class StarPattern {
    public static void main(String[] args) {
        PatternPrinter printer = new PatternPrinter();
        printer.printPattern();
    }
}
