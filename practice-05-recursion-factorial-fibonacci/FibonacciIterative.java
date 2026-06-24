public class FibonacciIterative {
    public static int fibonacci(int n) {
        // Iterative Fibonacci avoids repeated recursive calls.
        int previous = 0;
        int current = 1;

        for (int i = 0; i < n; i++) {
            int next = previous + current;
            previous = current;
            current = next;
        }

        return previous;
    }

    public static void main(String[] args) {
        System.out.println("fib(8) = " + fibonacci(8));
    }
}
