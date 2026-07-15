/**
 * TreeHeapHashReview
 *
 * Consolidates the three workhorse families: search trees (ordered, O(log n)),
 * heaps (priority access, partial order), and hash tables (unordered, O(1)
 * expected). The demo exercises each on the same keys to make their differing
 * guarantees and outputs concrete.
 *
 * Time complexity: O(n log n) overall from the tree and heap operations. Space
 *   complexity: O(n).
 */
public class TreeHeapHashReview {

    public void demonstrate() {
        int[] keys = { 40, 10, 30, 20, 50 };
        System.out.println("Same keys through a search tree, a heap, and a hash set: "
                + java.util.Arrays.toString(keys));
        System.out.println();

        java.util.TreeSet<Integer> tree = new java.util.TreeSet<>();
        for (int k : keys) {
            tree.add(k);
        }
        System.out.println("  search tree (sorted, supports range): " + tree);
        System.out.println("    first=" + tree.first() + ", last=" + tree.last());

        java.util.PriorityQueue<Integer> heap = new java.util.PriorityQueue<>();
        for (int k : keys) {
            heap.add(k);
        }
        System.out.println("  heap peek (smallest only): " + heap.peek());

        java.util.HashSet<Integer> hash = new java.util.HashSet<>();
        for (int k : keys) {
            hash.add(k);
        }
        System.out.println("  hash set (unordered, fast membership): contains 30? "
                + hash.contains(30));
        System.out.println();
        System.out.println("Trees give order, heaps give priority, hashes give speed without order.");
    }
}
