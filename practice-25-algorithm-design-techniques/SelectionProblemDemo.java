/**
 * SelectionProblemDemo
 *
 * The selection problem asks for the kth smallest element without fully sorting.
 * Quickselect adapts quicksort's partition: after partitioning, the pivot lands
 * in its final sorted position, so we recurse into only the side that contains
 * rank k. Average time is linear, far cheaper than an O(n log n) full sort.
 *
 * Invariant: after a partition, elements left of the pivot are smaller and those
 * right are larger, so the pivot's index equals its rank.
 *
 * Time complexity: average O(n), worst O(n^2). Space complexity: O(1) extra
 *   (in place), O(log n) recursion on average.
 */
public class SelectionProblemDemo {

    public void demonstrate() {
        int[] data = { 7, 2, 9, 4, 1, 8, 5, 3, 6 };
        System.out.println("Finding order statistics with quickselect (no full sort).");
        System.out.println("Array: " + java.util.Arrays.toString(data));
        System.out.println();

        for (int k : new int[] { 1, 5, 9 }) {
            int[] copy = data.clone();
            int value = quickselect(copy, 0, copy.length - 1, k - 1);
            System.out.println("  " + ordinal(k) + " smallest = " + value);
        }
        System.out.println();
        System.out.println("Only the partition containing rank k is explored, giving linear average time.");
    }

    private int quickselect(int[] a, int low, int high, int k) {
        while (low < high) {
            int pivotIndex = partition(a, low, high);
            if (pivotIndex == k) {
                return a[pivotIndex];
            } else if (pivotIndex < k) {
                low = pivotIndex + 1;
            } else {
                high = pivotIndex - 1;
            }
        }
        return a[low];
    }

    private int partition(int[] a, int low, int high) {
        int pivot = a[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (a[j] < pivot) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i, high);
        return i;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private String ordinal(int k) {
        if (k == 1) return "1st";
        if (k == 2) return "2nd";
        if (k == 3) return "3rd";
        return k + "th";
    }
}
