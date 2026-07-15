/**
 * BTreeSearchDemo
 *
 * Builds a B-tree and reports how many nodes a search visits. Because the tree
 * is shallow, even a large key set is found after visiting only a handful of
 * nodes, which is the property that makes B-trees suited to disk storage where
 * each node visit is an expensive block read.
 *
 * Time complexity: O(log_t n) node visits per search.
 */
public class BTreeSearchDemo {

    public void demonstrate() {
        BTreeEducational tree = new BTreeEducational(3);   // minimum degree 3
        for (int k = 1; k <= 40; k++) {
            tree.insert(k * 2);             // insert even numbers 2..80
        }
        System.out.println("Built a B-tree (min degree 3) holding 40 keys.");
        System.out.println("Tree height (edges from root to leaf): " + tree.height());
        System.out.println();

        int[] queries = {2, 40, 79, 80};
        for (int q : queries) {
            boolean found = tree.search(q);
            int visits = tree.searchVisitCount(q);
            System.out.println("search(" + q + ") found=" + found
                    + " after visiting " + visits + " node(s)");
        }
        System.out.println();
        System.out.println("A shallow tree means few block reads, the central advantage of B-trees.");
    }
}
