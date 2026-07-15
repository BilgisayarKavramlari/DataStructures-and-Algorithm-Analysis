/**
 * MultiwaySearchDemo
 *
 * Introduces the idea of multiway search before the full B-tree: a single node
 * may hold several sorted keys and therefore have several child pointers. The
 * search picks one of (keys + 1) intervals at each node, so a node with k keys
 * shrinks the search to one of k+1 ranges in a single step.
 *
 * Time complexity: O(k) comparisons per node for a k-key node.
 */
public class MultiwaySearchDemo {

    public void demonstrate() {
        int[] separators = {10, 20, 30};   // a 4-way node with three keys
        System.out.println("A node with keys " + java.util.Arrays.toString(separators)
                + " defines four child intervals:");
        System.out.println("  child 0: keys < 10");
        System.out.println("  child 1: 10 < keys < 20");
        System.out.println("  child 2: 20 < keys < 30");
        System.out.println("  child 3: keys > 30");
        System.out.println();

        int[] queries = {5, 15, 25, 42};
        for (int q : queries) {
            int branch = chooseBranch(separators, q);
            System.out.println("Searching for " + q + " -> follow child " + branch);
        }
        System.out.println();
        System.out.println("One comparison sweep selects among many children, lowering tree height.");
    }

    private int chooseBranch(int[] keys, int query) {
        int i = 0;
        while (i < keys.length && query > keys[i]) {
            i++;
        }
        return i;
    }
}
