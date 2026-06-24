public class FactorialRecursive {
    public static long factorial(int n) {
        // Base case: 0! and 1! are both 1.
        if (n <= 1) {
            return 1;
        }

        // Recursive case: solve a smaller version of the same problem.
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("5! = " + factorial(5));
    }
}
