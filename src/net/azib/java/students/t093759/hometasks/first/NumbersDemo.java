package net.azib.java.students.t093759.hometasks.first;

/**
 * Shows how to use Fibonacci and Factorial classes.
 *
 * @author dionis
 */
public class NumbersDemo {
    public static void main(String[] args) {
        new NumbersDemo().run();
    }

    private void run() {
        try {
            System.out.println(new Fibonacci(100));
            System.out.println(new Factorial(100));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
