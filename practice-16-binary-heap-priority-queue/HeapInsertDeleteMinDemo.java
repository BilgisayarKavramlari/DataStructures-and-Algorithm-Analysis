/**
 * HeapInsertDeleteMinDemo
 *
 * Traces insert (percolate up) and deleteMin (percolate down) on a binary min
 * heap, printing the array after each step so the bubbling motion is visible.
 *
 * Time complexity: O(log n) per insert and per deleteMin.
 */
public class HeapInsertDeleteMinDemo {

    public void demonstrate() {
        BinaryMinHeap heap = new BinaryMinHeap();
        int[] data = {15, 8, 20, 3, 12, 9};
        for (int x : data) {
            heap.insert(x);
            System.out.println("insert " + x + " -> " + heap);
        }
        System.out.println();
        System.out.println("Minimum is at the root: " + heap.findMin());
        System.out.println();
        while (!heap.isEmpty()) {
            int min = heap.deleteMin();
            System.out.println("deleteMin " + min + " -> " + heap);
        }
        System.out.println();
        System.out.println("Repeated deleteMin emits the values in ascending order (this is heapsort).");
    }
}
