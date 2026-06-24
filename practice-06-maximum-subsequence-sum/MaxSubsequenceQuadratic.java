public class MaxSubsequenceQuadratic {
    public static int maxSubsequenceSum(int[] values) {
        // O(n^2): reuse a running sum instead of recomputing each range.
        int best = 0;
        for (int start = 0; start < values.length; start++) {
            int sum = 0;
            for (int end = start; end < values.length; end++) {
                sum += values[end];
                best = Math.max(best, sum);
            }
        }
        return best;
    }

    public static void main(String[] args) {
        int[] values = {-2, 11, -4, 13, -5, 2};
        System.out.println(maxSubsequenceSum(values));
    }
}
