/**
 * InsertionSort
 *
 * Builds the sorted result one element at a time by inserting each new element
 * into its correct place among the already-sorted prefix. It is stable and
 * efficient on nearly-sorted input.
 *
 * Invariant: after processing index i, the subarray a[0..i] is sorted.
 *
 * Time complexity: O(n^2) worst and average, O(n) on already-sorted input.
 * Space complexity: O(1), sorting in place.
 */
public class InsertionSort {

    public static void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            // Shift larger elements one position to the right.
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    public void demonstrate() {
        int[] a = {5, 2, 9, 1, 7, 3};
        System.out.println("Before: " + java.util.Arrays.toString(a));
        sort(a);
        System.out.println("After : " + java.util.Arrays.toString(a));
        System.out.println("Each element is inserted into the growing sorted prefix.");
    }
}
