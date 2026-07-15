/**
 * QuickSort
 *
 * A divide-and-conquer sort that partitions the array around a pivot so that
 * smaller elements precede it and larger elements follow, then recurses on each
 * side. This implementation uses Lomuto partitioning around the last element and
 * genuinely rearranges the array (it does not delegate to a library sort).
 *
 * Invariant (Lomuto): during partitioning, a[lo..i] holds elements <= pivot and
 * a[i+1..j-1] holds elements > pivot.
 *
 * Time complexity: O(n log n) average, O(n^2) worst (already-sorted input with a
 * fixed end pivot). Space complexity: O(log n) average recursion depth.
 */
public class QuickSort {

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int p = partition(a, lo, hi);
        sort(a, lo, p - 1);
        sort(a, p + 1, hi);
    }

    // Lomuto partition: returns the final resting index of the pivot.
    private static int partition(int[] a, int lo, int hi) {
        int pivot = a[hi];
        int i = lo - 1;
        for (int j = lo; j < hi; j++) {
            if (a[j] <= pivot) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i + 1, hi);
        return i + 1;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public void demonstrate() {
        int[] a = {29, 10, 14, 37, 13, 8, 25};
        System.out.println("Before: " + java.util.Arrays.toString(a));
        sort(a);
        System.out.println("After : " + java.util.Arrays.toString(a));
        System.out.println("Partitioning physically moves elements around the pivot; no library sort used.");
    }
}
