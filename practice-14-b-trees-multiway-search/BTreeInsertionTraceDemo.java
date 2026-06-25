/**
 * BTreeInsertionTraceDemo
 *
 * Inserts keys one at a time and prints the tree level by level after each
 * insertion. The trace makes node splitting and median promotion visible: as
 * keys accumulate, full nodes split and the tree grows in width before it grows
 * in height.
 *
 * Time complexity: O(n log_t n) for the full traced sequence.
 */
public class BTreeInsertionTraceDemo {

    public void demonstrate() {
        BTreeEducational tree = new BTreeEducational(2);   // 2-3-4 behaviour
        int[] keys = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int k : keys) {
            tree.insert(k);
            System.out.println("After inserting " + k + ":");
            tree.printByLevel();
            System.out.println();
        }
        System.out.println("With minimum degree 2 each node holds 1 to 3 keys, like a (2,4)-tree.");
    }
}
