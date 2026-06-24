import java.util.HashMap;
import java.util.Map;

public class FibonacciMemoization {
    public static int fibonacci(int n, Map<Integer, Integer> memo) {
        // Memoization stores answers so each subproblem is solved once.
        if (n <= 1) {
            return n;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int answer = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
        memo.put(n, answer);
        return answer;
    }

    public static void main(String[] args) {
        System.out.println("fib(20) = " + fibonacci(20, new HashMap<>()));
    }
}
