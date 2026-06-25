/**
 * QuickSelect
 *
 * Finds the kth smallest element (1-based) without fully sorting. It partitions
 * like QuickSort but recurses into only the one side that must contain the
 * target rank, discarding the other side entirely.
 *
 * Invariant: after a partition, the pivot is at its final sorted position; the
 * target lies in the side whose index range contains rank k.
 *
 * Time complexity: O(n) average, O(n^2) worst. Space complexity: O(1) with the
 * iterative loop used here.
 */
public class QuickSelect {

    /** Returns the kth smallest element (k is 1-based). Modifies a copy. */
    public static int select(int[] input, int k) {
        int[] a = input.clone();
        int lo = 0;
        int hi = a.length - 1;
        int target = k - 1;                  // convert to 0-based index
        while (lo <= hi) {
            int p = partition(a, lo, hi);
            if (p == target) {
                return a[p];
            } else if (p < target) {
                lo = p + 1;                  // recurse right only
            } else {
                hi = p - 1;                  // recurse left only
            }
        }
        throw new IllegalArgumentException("k out of range");
    }

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
        int[] a = {23, 4, 67, 1, 88, 12, 45, 9, 30, 16};
        System.out.println("Data: " + java.util.Arrays.toString(a));
        for (int k : new int[]{1, 3, 5, 10}) {
            System.out.println("  " + k + "th smallest = " + select(a, k));
        }
        System.out.println("Only one partition side is explored, so no full sort happens.");
    }
}
