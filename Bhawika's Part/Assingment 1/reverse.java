public class reverse {
    public static void main(String[] args) {
        for (int i = args.length - 1; i >= 0; i--) {
            System.out.print(args[i] + " ");
        }
        System.out.println();
    }
}

/*
Output (Example: java reverse i am a student):
student a am i 
*/


