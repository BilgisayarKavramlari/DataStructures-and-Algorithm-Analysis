/**
 * ComplexityClassificationReview
 *
 * Reviews how to classify a function's growth rate and order common complexity
 * classes. Confirms by computing concrete operation counts at several input
 * sizes so the dramatic separation between classes is visible numerically rather
 * than only symbolically.
 *
 * Time complexity: O(number of sizes) printing. Space complexity: O(1).
 */
public class ComplexityClassificationReview {

    public void demonstrate() {
        System.out.println("Ordering growth classes from slowest- to fastest-growing:");
        System.out.println("  O(1) < O(log n) < O(n) < O(n log n) < O(n^2) < O(2^n) < O(n!)");
        System.out.println();

        int[] sizes = { 8, 16, 32, 64 };
        System.out.printf("  %-8s %-8s %-10s %-12s %-12s%n",
                "n", "log n", "n log n", "n^2", "2^n");
        for (int n : sizes) {
            double logN = Math.log(n) / Math.log(2);
            double nLogN = n * logN;
            long nSquared = (long) n * n;
            double twoToN = Math.pow(2, n);
            System.out.printf("  %-8d %-8.1f %-10.1f %-12d %-12.2e%n",
                    n, logN, nLogN, nSquared, twoToN);
        }

        System.out.println();
        System.out.println("Doubling n barely moves log n but squares n^2 and squares 2^n,");
        System.out.println("which is why exponential algorithms are infeasible beyond tiny inputs.");
    }
}
