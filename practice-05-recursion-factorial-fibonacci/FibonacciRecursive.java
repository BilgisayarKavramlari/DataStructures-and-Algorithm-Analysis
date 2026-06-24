public class FibonacciRecursive {
    public static int fibonacci(int n) {
        // This direct recursive definition is simple but repeats work.
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 8; i++) {
            System.out.println("fib(" + i + ") = " + fibonacci(i));
        }
    }
}
