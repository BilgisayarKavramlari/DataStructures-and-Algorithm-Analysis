public class FactorialIterative {
    public static long factorial(int n) {
        // Iterative factorial uses a loop to multiply 1 * 2 * ... * n.
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("5! = " + factorial(5));
    }
}
