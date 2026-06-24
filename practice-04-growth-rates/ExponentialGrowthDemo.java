import java.util.*;

/**
 * Live teaching demo for ExponentialGrowth.
 * The example executes a small deterministic computation so students can
 * count operations and discuss edge cases.
 */
public class ExponentialGrowthDemo {
    public static void run() {
        System.out.println("-- ExponentialGrowthDemo");
        int[] values = {4, 1, 7, 1, 3};
        int comparisons = 0;
        int matches = 0;
        for (int i = 0; i < values.length; i++) {
            comparisons++;
            if (values[i] == 1) {
                matches++;
                System.out.println("  found target value 1 at index " + i);
            }
        }
        System.out.println("  comparisons=" + comparisons + ", matches=" + matches);
        System.out.println("  Edge case: an empty array would perform zero loop iterations.");
        System.out.println("  Complexity: linear scan uses O(n) time and O(1) extra space.\n");
    }

    public static void main(String[] args) {
        run();
    }
}
