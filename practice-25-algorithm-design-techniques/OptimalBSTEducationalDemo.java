/**
 * OptimalBSTEducationalDemo
 *
 * Given keys with access frequencies, build the binary search tree that
 * minimizes expected search cost. Frequently accessed keys should sit near the
 * root. A dynamic-programming table cost[i][j] holds the best expected cost for
 * the keys in range i..j, trying each key as the subtree root.
 *
 * Invariant: cost[i][j] adds the total frequency of the range (every key sinks
 * one level deeper under any chosen root) to the best left and right subtree
 * costs.
 *
 * Time complexity: O(n^3). Space complexity: O(n^2).
 */
public class OptimalBSTEducationalDemo {

    public void demonstrate() {
        String[] keys = { "and", "for", "the", "with" };
        int[] freq = { 8, 3, 10, 2 };
        int n = keys.length;

        System.out.println("Keys with access frequencies:");
        for (int i = 0; i < n; i++) {
            System.out.println("  \"" + keys[i] + "\" accessed " + freq[i] + " times");
        }
        System.out.println();

        int[][] cost = new int[n][n];
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + freq[i];
        }
        for (int i = 0; i < n; i++) {
            cost[i][i] = freq[i];
        }

        for (int length = 2; length <= n; length++) {
            for (int i = 0; i + length - 1 < n; i++) {
                int j = i + length - 1;
                cost[i][j] = Integer.MAX_VALUE;
                int rangeFreq = prefix[j + 1] - prefix[i];
                for (int r = i; r <= j; r++) {
                    int left = (r > i) ? cost[i][r - 1] : 0;
                    int right = (r < j) ? cost[r + 1][j] : 0;
                    int total = left + right + rangeFreq;
                    if (total < cost[i][j]) {
                        cost[i][j] = total;
                    }
                }
            }
        }

        System.out.println("  minimum weighted search cost: " + cost[0][n - 1]);
        System.out.println("  high-frequency keys are placed nearer the root to lower expected depth.");
    }
}
