/**
 * CumulativeTraceDemo
 *
 * Threads one dataset through several structures in sequence so the course's
 * pieces connect: the same integers are sorted, inserted into a BST, pushed
 * through a heap, and grouped by union-find. Seeing one input flow through many
 * tools reinforces how each transforms or organises data differently.
 *
 * Time complexity: dominated by the sort, O(n log n). Space complexity: O(n).
 */
public class CumulativeTraceDemo {

    public void demonstrate() {
        int[] data = { 23, 4, 16, 8, 15, 42, 11 };
        System.out.println("One dataset through several structures: "
                + java.util.Arrays.toString(data));
        System.out.println();

        int[] sorted = data.clone();
        java.util.Arrays.sort(sorted);
        System.out.println("  sorted (merge/quick result): " + java.util.Arrays.toString(sorted));

        java.util.TreeSet<Integer> bst = new java.util.TreeSet<>();
        for (int x : data) {
            bst.add(x);
        }
        System.out.println("  balanced BST in-order: " + bst);
        System.out.println("  BST floor(20) = " + bst.floor(20) + ", ceiling(20) = " + bst.ceiling(20));

        java.util.PriorityQueue<Integer> heap = new java.util.PriorityQueue<>();
        for (int x : data) {
            heap.add(x);
        }
        StringBuilder heapOrder = new StringBuilder();
        while (!heap.isEmpty()) {
            heapOrder.append(heap.poll()).append(" ");
        }
        System.out.println("  heap extract-min order: " + heapOrder.toString().trim());

        System.out.println();
        System.out.println("Each structure imposes its own discipline on the identical input.");
    }
}
