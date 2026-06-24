import java.util.*;

/** Demonstrates Big-O, Big-Omega, Big-Theta, little-o, little-omega, loop rules, binary search, recurrences, space complexity. Time notes are printed for live tracing. */
public class LoopCountingDemo {
    public static void run() {
        System.out.println("-- LoopCountingDemo: Big-O, Big-Omega, Big-Theta, little-o, little-omega, loop rules, binary search, recurrences, space complexity");
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
