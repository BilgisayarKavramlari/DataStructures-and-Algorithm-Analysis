/**
 * BTreeSplitDemo
 *
 * Focuses on a single split event. A node is filled to its maximum of 2t-1 keys,
 * and the next insertion forces a split: the median key moves up to the parent
 * and the remaining keys divide into two nodes of t-1 keys each.
 *
 * Time complexity: O(t) to move keys during one split.
 */
public class BTreeSplitDemo {

    public void demonstrate() {
        int t = 3;
        BTreeEducational tree = new BTreeEducational(t);
        System.out.println("Minimum degree t = " + t
                + ", so a node holds at most " + (2 * t - 1) + " keys before splitting.");

        // Fill the root exactly to capacity.
        int[] fill = {10, 20, 30, 40, 50};
        for (int k : fill) {
            tree.insert(k);
        }
        System.out.println("Root filled to capacity:");
        tree.printByLevel();
        System.out.println();

        System.out.println("Inserting 60 overflows the root and forces a split...");
        tree.insert(60);
        tree.printByLevel();
        System.out.println();
        System.out.println("The median key was promoted, creating a new root and increasing height.");
        System.out.println("New tree height: " + tree.height());
    }
}
