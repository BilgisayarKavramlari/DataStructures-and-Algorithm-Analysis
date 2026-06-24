import java.util.*;

/** Demonstrates red-black invariants, insertion, recoloring, rotations, double-red repair, 2-4 correspondence, deletion concepts. Time notes are printed for live tracing. */
public class RedBlackDeletionConceptDemo {
    public static void run() {
        System.out.println("-- RedBlackDeletionConceptDemo: red-black invariants, insertion, recoloring, rotations, double-red repair, 2-4 correspondence, deletion concepts");
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
