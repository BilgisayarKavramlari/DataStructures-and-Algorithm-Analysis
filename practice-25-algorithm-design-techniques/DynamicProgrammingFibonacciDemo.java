/**
 * DynamicProgrammingFibonacciDemo
 *
 * Contrasts naive recursion against dynamic programming on the Fibonacci
 * numbers. Naive recursion recomputes the same subproblems exponentially often;
 * DP stores each result once (memoization, top-down) or fills a table from the
 * base cases up (tabulation, bottom-up), reducing the cost to linear.
 *
 * Time complexity: naive O(phi^n); DP O(n). Space complexity: O(n) for the
 *   table, reducible to O(1).
 */
public class DynamicProgrammingFibonacciDemo {

    private long naiveCalls = 0;

    public void demonstrate() {
        int n = 12;
        System.out.println("Computing Fibonacci(" + n + ") three ways.");
        System.out.println();

        naiveCalls = 0;
        long naive = naiveFib(n);
        System.out.println("  naive recursion result " + naive
                + " with " + naiveCalls + " calls (exponential).");

        long[] memo = new long[n + 1];
        java.util.Arrays.fill(memo, -1);
        long memoized = memoFib(n, memo);
        System.out.println("  memoized (top-down) result " + memoized
                + " with each subproblem solved once.");

        long tabulated = tabulationFib(n);
        System.out.println("  tabulation (bottom-up) result " + tabulated
                + " filling a table from base cases up.");
        System.out.println();
        System.out.println("Overlapping subproblems plus optimal substructure make this");
        System.out.println("a textbook dynamic-programming target.");
    }

    private long naiveFib(int n) {
        naiveCalls++;
        if (n < 2) {
            return n;
        }
        return naiveFib(n - 1) + naiveFib(n - 2);
    }

    private long memoFib(int n, long[] memo) {
        if (n < 2) {
            return n;
        }
        if (memo[n] != -1) {
            return memo[n];
        }
        memo[n] = memoFib(n - 1, memo) + memoFib(n - 2, memo);
        return memo[n];
    }

    private long tabulationFib(int n) {
        long[] table = new long[n + 1];
        table[0] = 0;
        if (n >= 1) {
            table[1] = 1;
        }
        for (int i = 2; i <= n; i++) {
            table[i] = table[i - 1] + table[i - 2];
        }
        return table[n];
    }
}
