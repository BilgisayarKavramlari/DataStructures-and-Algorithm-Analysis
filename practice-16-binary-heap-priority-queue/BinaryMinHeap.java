import java.util.ArrayList;
import java.util.List;

/**
 * BinaryMinHeap
 *
 * Represents a binary min-heap stored in an array. The smallest element is
 * always at the root (index 1 in this 1-based layout). The shape is a complete
 * binary tree, which lets parent/child links be computed by arithmetic instead
 * of stored pointers.
 *
 * Invariant (heap-order): every node is less than or equal to both of its
 * children, so the minimum is always at index 1.
 *
 * Index arithmetic (1-based): parent(i)=i/2, left(i)=2i, right(i)=2i+1.
 *
 * Main operations: insert percolates a new value up; deleteMin removes the root
 * and percolates the last element down.
 *
 * Edge cases: operations on an empty heap throw; duplicate keys are allowed.
 *
 * Time complexity: O(log n) for insert and deleteMin, O(1) for findMin,
 * O(n) for buildHeap. Space complexity: O(n).
 */
public class BinaryMinHeap {

    private final List<Integer> heap = new ArrayList<>();

    public BinaryMinHeap() {
        heap.add(0);            // index 0 unused so children math stays clean
    }

    public boolean isEmpty() {
        return heap.size() == 1;
    }

    public int size() {
        return heap.size() - 1;
    }

    public int findMin() {
        if (isEmpty()) {
            throw new IllegalStateException("heap is empty");
        }
        return heap.get(1);
    }

    /** Inserts a value and restores heap order by percolating up. */
    public void insert(int value) {
        heap.add(value);
        percolateUp(heap.size() - 1);
    }

    private void percolateUp(int i) {
        while (i > 1 && heap.get(i) < heap.get(i / 2)) {
            swap(i, i / 2);
            i = i / 2;
        }
    }

    /** Removes and returns the minimum, restoring order by percolating down. */
    public int deleteMin() {
        if (isEmpty()) {
            throw new IllegalStateException("heap is empty");
        }
        int min = heap.get(1);
        int last = heap.remove(heap.size() - 1);
        if (!isEmpty()) {
            heap.set(1, last);
            percolateDown(1);
        }
        return min;
    }

    private void percolateDown(int i) {
        int n = heap.size() - 1;
        while (2 * i <= n) {
            int child = 2 * i;
            if (child < n && heap.get(child + 1) < heap.get(child)) {
                child++;                 // pick the smaller child
            }
            if (heap.get(child) < heap.get(i)) {
                swap(i, child);
                i = child;
            } else {
                break;
            }
        }
    }

    /** Builds a heap from an arbitrary array in O(n) by bottom-up percolation. */
    public void buildHeap(int[] values) {
        heap.clear();
        heap.add(0);
        for (int v : values) {
            heap.add(v);
        }
        for (int i = (heap.size() - 1) / 2; i >= 1; i--) {
            percolateDown(i);
        }
    }

    /** Decreases the value at a 1-based position and re-establishes order. */
    public void decreaseKey(int position, int newValue) {
        heap.set(position, newValue);
        percolateUp(position);
    }

    /** Increases the value at a 1-based position and re-establishes order. */
    public void increaseKey(int position, int newValue) {
        heap.set(position, newValue);
        percolateDown(position);
    }

    /** Removes the element at a 1-based position. */
    public int deleteAt(int position) {
        int removed = heap.get(position);
        int last = heap.remove(heap.size() - 1);
        if (position <= heap.size() - 1) {
            heap.set(position, last);
            // The replacement may need to move either direction.
            percolateDown(position);
            percolateUp(position);
        }
        return removed;
    }

    public int valueAt(int position) {
        return heap.get(position);
    }

    private void swap(int a, int b) {
        int tmp = heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b, tmp);
    }

    @Override
    public String toString() {
        return heap.subList(1, heap.size()).toString();
    }
}
