/**
 * DynamicArray
 *
 * Represents:
 *   A growable array (the core idea behind java.util.ArrayList) that starts
 *   with a small backing array and doubles its capacity whenever it fills up.
 *
 * Invariant:
 *   size <= capacity, and elements [0, size) of the backing array hold the
 *   logical contents in order.
 *
 * Main operation (add):
 *   Append at the end. If there is room it costs O(1). If the array is full it
 *   first allocates a new array of double the capacity and copies every
 *   element, costing O(size) for that one operation.
 *
 * Why amortized O(1):
 *   Doubling makes expensive copies rare. Over n appends the total copy work is
 *   n + n/2 + n/4 + ... < 2n, so the average (amortized) cost per append is
 *   O(1) even though individual appends can cost O(n).
 *
 * Edge cases:
 *   Growing from the initial capacity; get with bounds checking.
 *
 * Time complexity: add is amortized O(1), worst case O(n) on a resize; get is
 *   O(1). Space complexity: O(capacity).
 */
public class DynamicArray {

    private int[] data;
    private int size;
    private int resizeCount;
    private long totalCopies;

    public DynamicArray(int initialCapacity) {
        this.data = new int[Math.max(1, initialCapacity)];
        this.size = 0;
    }

    /** Appends value, reporting the unit cost of this single operation. */
    public int add(int value) {
        int cost;
        if (size == data.length) {
            grow();
            cost = size + 1;
        } else {
            cost = 1;
        }
        data[size++] = value;
        return cost;
    }

    private void grow() {
        int newCapacity = data.length * 2;
        int[] bigger = new int[newCapacity];
        for (int i = 0; i < size; i++) {
            bigger[i] = data[i];
        }
        totalCopies += size;
        resizeCount++;
        data = bigger;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index " + index + " for size " + size);
        }
        return data[index];
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return data.length;
    }

    public int resizeCount() {
        return resizeCount;
    }

    public long totalCopies() {
        return totalCopies;
    }
}
