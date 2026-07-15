/**
 * MatrixChainMultiplicationDemo
 *
 * A classic dynamic-programming problem: parenthesize a chain of matrix
 * multiplications to minimize the total scalar multiplications. Matrix
 * multiplication is associative, so the result is identical regardless of
 * grouping, but the cost varies hugely. We fill a DP table where m[i][j] is the
 * best cost to multiply matrices i..j.
 *
 * Invariant: m[i][j] considers every split point k between i and j and keeps the
 * cheapest, relying on subproblems m[i][k] and m[k+1][j] already being solved.
 *
 * Time complexity: O(n^3). Space complexity: O(n^2).
 */
public class MatrixChainMultiplicationDemo {

    public void demonstrate() {
        int[] dims = { 30, 35, 15, 5, 10, 20 };
        int n = dims.length - 1;
        System.out.println("Matrix chain with dimensions:");
        for (int i = 0; i < n; i++) {
            System.out.println("  A" + (i + 1) + " is " + dims[i] + " x " + dims[i + 1]);
        }
        System.out.println();

        int[][] m = new int[n + 1][n + 1];
        int[][] split = new int[n + 1][n + 1];

        for (int length = 2; length <= n; length++) {
            for (int i = 1; i + length - 1 <= n; i++) {
                int j = i + length - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = m[i][k] + m[k + 1][j] + dims[i - 1] * dims[k] * dims[j];
                    if (cost < m[i][j]) {
                        m[i][j] = cost;
                        split[i][j] = k;
                    }
                }
            }
            System.out.println("  filled DP entries for chains of length " + length);
        }

        System.out.println();
        System.out.println("  minimum scalar multiplications: " + m[1][n]);
        System.out.print("  optimal parenthesization: ");
        System.out.println(buildParenthesization(split, 1, n));
    }

    private String buildParenthesization(int[][] split, int i, int j) {
        if (i == j) {
            return "A" + i;
        }
        int k = split[i][j];
        return "(" + buildParenthesization(split, i, k)
                + " x " + buildParenthesization(split, k + 1, j) + ")";
    }
}
