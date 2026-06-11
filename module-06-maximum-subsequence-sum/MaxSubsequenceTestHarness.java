public class MaxSubsequenceTestHarness {
    public static int cubic(int[] values) {
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

    public static int linear(int[] values) {
        int best = 0;
        int current = 0;
        for (int value : values) {
            current = Math.max(0, current + value);
            best = Math.max(best, current);
        }
        return best;
    }

    public static void main(String[] args) {
        // A small harness checks that two implementations agree on sample inputs.
        int[][] tests = {
            {-2, 11, -4, 13, -5, 2},
            {-5, -1, -8},
            {4, -1, 2, 1}
        };

        for (int[] test : tests) {
            System.out.println("cubic = " + cubic(test) + ", linear = " + linear(test));
        }
    }
}
