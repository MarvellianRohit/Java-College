/*
 * Q3: Using methods charAt() & length() of the String class, write a program to print the frequency
 * of each character in a string.
 * Input: "Hello friend"
 * Output: H-: 1, d-: 1, e-: 2, f-: 1 (continued for all character in the string).
 */

public class Q3_CharacterFrequency {
    public static void main(String[] args) {
        String str = "Hello friend";
        int[] freq = new int[256];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != ' ') {
                freq[ch]++;
            }
        }

        boolean first = true;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                if (!first) {
                    System.out.print(", ");
                }
                System.out.print((char) i + "-: " + freq[i]);
                first = false;
            }
        }
        System.out.println();
    }
}

/*
Output:
H-: 1, d-: 1, e-: 2, f-: 1, i-: 1, l-: 2, n-: 1, o-: 1, r-: 1
*/

