/*
 * Q4: Write a program to create two threads, one prints "HELLO" and other prints "HI".
 */

class HelloThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("HELLO");
        }
    }
}

class HiThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("HI");
        }
    }
}

public class Q4_TwoThreads {
    public static void main(String[] args) {
        HelloThread t1 = new HelloThread();
        HiThread t2 = new HiThread();

        t1.start();
        t2.start();
    }
}

/*
Output:
HELLO
HELLO
HELLO
HI
HI
HI
*/

