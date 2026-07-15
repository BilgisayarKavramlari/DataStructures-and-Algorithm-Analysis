/**
 * SortingLowerBoundIntuitionDemo
 *
 * Explains why any comparison-based sort needs Omega(n log n) comparisons. A
 * comparison sort must distinguish all n! possible orderings, and a binary
 * decision tree of height h has at most 2^h leaves. Therefore 2^h >= n!, which
 * gives h >= log2(n!) = Theta(n log n).
 *
 * Time complexity: O(n) to compute the illustrative bounds for small n.
 */
public class SortingLowerBoundIntuitionDemo {

    public void demonstrate() {
        System.out.println("A comparison sort is a decision tree; each leaf is one permutation.");
        System.out.println("To sort n items it must separate all n! orderings.");
        System.out.println();
        System.out.printf("%3s %12s %18s %14s%n", "n", "n!", "log2(n!) (min cmp)", "n*log2(n)");
        for (int n = 2; n <= 10; n++) {
            double factorial = 1;
            for (int i = 2; i <= n; i++) {
                factorial *= i;
            }
            double log2Fact = Math.log(factorial) / Math.log(2);
            double nLogN = n * (Math.log(n) / Math.log(2));
            System.out.printf("%3d %12.0f %18.1f %14.1f%n", n, factorial, log2Fact, nLogN);
        }
        System.out.println();
        System.out.println("log2(n!) tracks n*log2(n), so no comparison sort beats O(n log n).");
        System.out.println("Radix and bucket sort escape this only by not comparing keys.");
    }
}
