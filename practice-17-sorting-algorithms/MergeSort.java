/**
 * MergeSort
 *
 * A divide-and-conquer sort: split the array in half, sort each half
 * recursively, then merge the two sorted halves. It is stable and has a
 * guaranteed O(n log n) bound, at the cost of O(n) auxiliary space.
 *
 * Recurrence: T(n) = 2 T(n/2) + O(n), which solves to O(n log n).
 *
 * Time complexity: O(n log n) in all cases. Space complexity: O(n).
 */
public class MergeSort {

    public static void sort(int[] a) {
        int[] temp = new int[a.length];
        sort(a, temp, 0, a.length - 1);
    }

    private static void sort(int[] a, int[] temp, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        sort(a, temp, left, mid);
        sort(a, temp, mid + 1, right);
        merge(a, temp, left, mid, right);
    }

    // Merges the two sorted runs a[left..mid] and a[mid+1..right].
    private static void merge(int[] a, int[] temp, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = a[i];
        }
        int i = left;
        int j = mid + 1;
        int k = left;
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                a[k++] = temp[i++];      // <= preserves stability
            } else {
                a[k++] = temp[j++];
            }
        }
        while (i <= mid) {
            a[k++] = temp[i++];
        }
        while (j <= right) {
            a[k++] = temp[j++];
        }
    }

    public void demonstrate() {
        int[] a = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Before: " + java.util.Arrays.toString(a));
        sort(a);
        System.out.println("After : " + java.util.Arrays.toString(a));
        System.out.println("Halves are sorted recursively, then merged in linear time.");
    }
}
