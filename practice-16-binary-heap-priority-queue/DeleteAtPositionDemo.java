/**
 * DeleteAtPositionDemo
 *
 * Demonstrates removing an element from an arbitrary heap position (not just the
 * root). The vacated slot is filled by the last element, which then percolates
 * up or down depending on its value relative to its new neighbours.
 *
 * Time complexity: O(log n) per deletion.
 */
public class DeleteAtPositionDemo {

    public void demonstrate() {
        BinaryMinHeap heap = new BinaryMinHeap();
        int[] data = {5, 9, 11, 14, 18, 19, 21, 33, 17};
        heap.buildHeap(data);
        System.out.println("Heap: " + heap);

        int pos = 3;
        System.out.println("Deleting element at position " + pos
                + " (value " + heap.valueAt(pos) + ")");
        heap.deleteAt(pos);
        System.out.println("Result: " + heap);
        System.out.println();
        System.out.println("The last element replaced the hole, then restored order in one direction.");
    }
}
