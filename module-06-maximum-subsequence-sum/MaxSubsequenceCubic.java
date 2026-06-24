public class MaxSubsequenceCubic {
    public static int maxSubsequenceSum(int[] values) {
        // O(n^3): choose every start/end pair, then sum that range.
        int best = 0;
        for (int start = 0; start < values.length; start++) {
            for (int end = start; end < values.length; end++) {
                int sum = 0;
                for (int k = start; k <= end; k++) {
                    sum += values[k];
                }
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
