/**
 * BTreeDeletionConceptDemo
 *
 * Demonstrates the concept of B-tree deletion with an executable accounting
 * model. The challenge mirrors insertion in reverse: a node may fall below the
 * minimum of t-1 keys (underflow), which is repaired by borrowing a key from a
 * sibling or by merging two siblings and pulling a key down from the parent.
 *
 * Time complexity: O(t * log_t n) per deletion in a full implementation.
 */
public class BTreeDeletionConceptDemo {

    public void demonstrate() {
        int t = 3;
        int minKeys = t - 1;
        System.out.println("Minimum degree t = " + t
                + ", so every non-root node must keep at least " + minKeys + " keys.");
        System.out.println();

        int nodeKeys = 2;           // a node currently at the minimum
        System.out.println("A node sits at the minimum with " + nodeKeys + " keys.");
        System.out.println("Deleting one key would drop it to " + (nodeKeys - 1)
                + ", an underflow.");
        System.out.println();

        int siblingKeys = 3;
        if (siblingKeys > minKeys) {
            System.out.println("Repair by BORROWING: the sibling has " + siblingKeys
                    + " keys (a spare).");
            System.out.println("Rotate one key through the parent into the deficient node.");
            nodeKeys = minKeys;     // restored
            siblingKeys--;
            System.out.println("Node now has " + nodeKeys + " keys; sibling has "
                    + siblingKeys + ". Balance restored.");
        }
        System.out.println();

        int leanSibling = minKeys;
        System.out.println("If instead the sibling also has only " + leanSibling
                + " keys, borrowing is impossible.");
        System.out.println("Repair by MERGING: combine the two nodes plus one parent key");
        System.out.println("into a single node of " + (leanSibling + minKeys + 1)
                + " keys, which may cause the parent to underflow in turn.");
        System.out.println();
        System.out.println("Borrow-or-merge propagates upward, the exact inverse of split propagation.");
    }
}
