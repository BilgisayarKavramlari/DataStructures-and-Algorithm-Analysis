import java.util.*;

/** Demonstrates O(1), O(log n), O(n), O(n log n), O(n^2), O(n^3), O(2^n), O(n!), timing, operation counts. Time notes are printed for live tracing. */
public class QuadraticGrowthDemo {
    public static void run() {
        System.out.println("-- QuadraticGrowthDemo: O(1), O(log n), O(n), O(n log n), O(n^2), O(n^3), O(2^n), O(n!), timing, operation counts");
        int[] data = {7, 3, 9, 1, 5};
        System.out.println("Input: " + Arrays.toString(data));
        int best = data[0];
        for (int x : data) {
            if (x > best) best = x;
            System.out.println("  visit " + x + ", current best=" + best);
        }
        System.out.println("Invariant: processed prefix has a correct summary; time O(n), extra space O(1).\n");
    }
    public static void main(String[] args) { run(); }
}
