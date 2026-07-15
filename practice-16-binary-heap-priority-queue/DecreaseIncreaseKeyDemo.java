/**
 * DecreaseIncreaseKeyDemo
 *
 * Demonstrates decreaseKey and increaseKey. Lowering a value may break heap
 * order upward, so the element percolates up; raising a value may break it
 * downward, so the element percolates down. decreaseKey is the operation
 * Dijkstra's algorithm relies on.
 *
 * Time complexity: O(log n) for each adjustment.
 */
public class DecreaseIncreaseKeyDemo {

    public void demonstrate() {
        BinaryMinHeap heap = new BinaryMinHeap();
        int[] data = {10, 20, 30, 40, 50, 60};
        heap.buildHeap(data);
        System.out.println("Initial heap: " + heap);

        System.out.println("decreaseKey at position 6 (value " + heap.valueAt(6) + ") to 5");
        heap.decreaseKey(6, 5);
        System.out.println("Result: " + heap + " (5 rose toward the root)");
        System.out.println();

        System.out.println("increaseKey at position 1 (value " + heap.valueAt(1) + ") to 100");
        heap.increaseKey(1, 100);
        System.out.println("Result: " + heap + " (100 sank toward the leaves)");
        System.out.println();
        System.out.println("decreaseKey moves a node up; increaseKey moves it down.");
    }
}
