/**
 * FibonacciHeapConceptDemo
 *
 * Conceptual overview of the Fibonacci heap, the structure that gives the best
 * known amortized bounds for the priority-queue operations used by Dijkstra and
 * Prim. It is presented at the level of behaviour and amortized costs rather
 * than a full pointer implementation, which is appropriate for an introductory
 * data-structures course.
 *
 * Core ideas demonstrated in narrative form:
 *   - insert and decrease-key are amortized O(1); delete-min is amortized
 *     O(log n).
 *   - Work is deferred: insert just adds a tree to a root list and does no
 *     consolidation; the cleanup happens lazily during delete-min.
 *   - decrease-key may cut a node from its parent; cascading cuts keep trees
 *     from becoming too thin, and the analysis ties tree sizes to Fibonacci
 *     numbers, which is the source of the name.
 *
 * Time complexity (amortized): insert O(1), decrease-key O(1),
 *   delete-min O(log n). Space complexity: O(n).
 */
public class FibonacciHeapConceptDemo {

    public void demonstrate() {
        System.out.println("Fibonacci heap: amortized bounds and the lazy strategy behind them.");
        System.out.println();

        System.out.println("Amortized costs:");
        System.out.printf("  %-16s %-12s%n", "operation", "amortized");
        System.out.printf("  %-16s %-12s%n", "insert", "O(1)");
        System.out.printf("  %-16s %-12s%n", "find-min", "O(1)");
        System.out.printf("  %-16s %-12s%n", "decrease-key", "O(1)");
        System.out.printf("  %-16s %-12s%n", "merge", "O(1)");
        System.out.printf("  %-16s %-12s%n", "delete-min", "O(log n)");
        System.out.println();

        System.out.println("Why these hold:");
        System.out.println("  1. insert adds a single-node tree to a root list and stops; no");
        System.out.println("     restructuring is done, so the actual cost is constant.");
        System.out.println("  2. delete-min pays the deferred bill: it consolidates trees of equal");
        System.out.println("     degree, an O(log n) amortized cleanup charged against earlier inserts.");
        System.out.println("  3. decrease-key cuts the node and moves it to the root list. If its");
        System.out.println("     parent had already lost a child, a cascading cut propagates upward.");
        System.out.println("  4. Marking and cascading cuts guarantee a node of degree d roots a");
        System.out.println("     subtree of at least Fibonacci(d+2) nodes, bounding degrees by O(log n).");
        System.out.println();

        System.out.println("Relevant Fibonacci sizes (minimum subtree size by degree):");
        int a = 1, b = 2;
        System.out.println("  degree 0 -> min size 1");
        System.out.println("  degree 1 -> min size 2");
        for (int degree = 2; degree <= 8; degree++) {
            int next = a + b;
            System.out.println("  degree " + degree + " -> min size " + next);
            a = b;
            b = next;
        }

        System.out.println();
        System.out.println("Because subtree sizes grow at least as fast as Fibonacci numbers,");
        System.out.println("the maximum degree stays O(log n), which bounds delete-min.");
    }
}
