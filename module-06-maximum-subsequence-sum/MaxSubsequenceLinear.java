public class MaxSubsequenceLinear {
    public static int maxSubsequenceSum(int[] values) {
        // Kadane's algorithm keeps the best sum ending at the current position.
        int best = 0;
        int current = 0;

        for (int value : values) {
            current = Math.max(0, current + value);
            best = Math.max(best, current);
        }

        return best;
    }

    public static void main(String[] args) {
        int[] values = {-2, 11, -4, 13, -5, 2};
        System.out.println(maxSubsequenceSum(values));
    }
}
