public class MaxSubsequenceDivideConquer {
    public static int maxSubsequenceSum(int[] values) {
        // Divide and conquer splits the array, solves each half, and checks crossing sums.
        return maxSubsequenceSum(values, 0, values.length - 1);
    }

    private static int maxSubsequenceSum(int[] values, int left, int right) {
        if (left > right) {
            return 0;
        }
        if (left == right) {
            return Math.max(0, values[left]);
        }

        int middle = (left + right) / 2;
        int bestLeft = maxSubsequenceSum(values, left, middle);
        int bestRight = maxSubsequenceSum(values, middle + 1, right);

        int leftBorder = 0;
        int bestLeftBorder = 0;
        for (int i = middle; i >= left; i--) {
            leftBorder += values[i];
            bestLeftBorder = Math.max(bestLeftBorder, leftBorder);
        }

        int rightBorder = 0;
        int bestRightBorder = 0;
        for (int i = middle + 1; i <= right; i++) {
            rightBorder += values[i];
            bestRightBorder = Math.max(bestRightBorder, rightBorder);
        }

        int bestCrossing = bestLeftBorder + bestRightBorder;
        return Math.max(Math.max(bestLeft, bestRight), bestCrossing);
    }

    public static void main(String[] args) {
        int[] values = {-2, 11, -4, 13, -5, 2};
        System.out.println(maxSubsequenceSum(values));
    }
}
