/**
 * SelectionProblemHeapDemo
 *
 * Solves the selection problem (find the kth smallest element) with a heap. The
 * demo shows the standard trick: build a min-heap in O(n), then deleteMin k
 * times, giving O(n + k log n) without fully sorting the data.
 *
 * Time complexity: O(n + k log n).
 */
public class SelectionProblemHeapDemo {

    public void demonstrate() {
        int[] data = {23, 4, 67, 1, 88, 12, 45, 9, 30, 16};
        int k = 4;
        System.out.println("Data: " + java.util.Arrays.toString(data));
        System.out.println("Finding the " + k + "th smallest element.");

        BinaryMinHeap heap = new BinaryMinHeap();
        heap.buildHeap(data);                  // O(n)

        int kth = -1;
        for (int i = 0; i < k; i++) {          // k deleteMin operations
            kth = heap.deleteMin();
            System.out.println("  removed minimum #" + (i + 1) + " = " + kth);
        }
        System.out.println("The " + k + "th smallest element is " + kth + ".");
        System.out.println("No full sort was needed, only k extractions from the heap.");
    }
}
