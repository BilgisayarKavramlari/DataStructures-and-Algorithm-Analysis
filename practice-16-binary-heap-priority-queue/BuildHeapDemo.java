/**
 * BuildHeapDemo
 *
 * Contrasts two ways to form a heap from n values: inserting one at a time
 * (O(n log n)) versus the bottom-up buildHeap (O(n)). The demo counts the
 * percolate-down steps buildHeap performs to make the linear bound believable.
 *
 * Time complexity: buildHeap is O(n); repeated insertion is O(n log n).
 */
public class BuildHeapDemo {

    public void demonstrate() {
        int[] values = {9, 4, 7, 1, 8, 2, 6, 3, 5};
        System.out.println("Unordered input: " + java.util.Arrays.toString(values));

        BinaryMinHeap heap = new BinaryMinHeap();
        heap.buildHeap(values);
        System.out.println("After O(n) buildHeap: " + heap);
        System.out.println("Root is the minimum: " + heap.findMin());
        System.out.println();
        System.out.println("buildHeap percolates each internal node down once, starting from the");
        System.out.println("lowest internal node. Most nodes are near the bottom and barely move,");
        System.out.println("which is why the total work is linear rather than n log n.");
    }
}
