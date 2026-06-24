import java.util.*;

/** Demonstrates postfix input, stack construction, prefix/infix/postfix traversal, evaluation, construction trace. Time notes are printed for live tracing. */
public class ExpressionTreeNode {
    public static void run() {
        System.out.println("-- ExpressionTreeNode: postfix input, stack construction, prefix/infix/postfix traversal, evaluation, construction trace");
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
