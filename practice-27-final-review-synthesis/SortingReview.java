/**
 * SortingReview
 *
 * Reviews the sorting module by running several algorithms on the same array and
 * summarising their stability and complexity. Reinforces choosing a sort by its
 * guarantees: comparison sorts at O(n log n), linear-time sorts for bounded
 * integer keys.
 *
 * Time complexity: O(n log n) for the comparison sorts shown. Space: O(n).
 */
public class SortingReview {

    public void demonstrate() {
        int[] data = { 5, 2, 9, 1, 5, 6, 3 };
        System.out.println("Sorting review on " + java.util.Arrays.toString(data));
        System.out.println();

        System.out.println("  insertion sort result: "
                + java.util.Arrays.toString(insertionSort(data.clone())));
        System.out.println("  merge sort result:     "
                + java.util.Arrays.toString(mergeSort(data.clone())));
        System.out.println("  quicksort result:      "
                + java.util.Arrays.toString(quickSort(data.clone(), 0, data.length - 1)));
        System.out.println();

        System.out.println("  guarantees:");
        System.out.println("    insertion: O(n^2) worst, O(n) on nearly sorted, stable");
        System.out.println("    merge:     O(n log n) always, stable, O(n) extra space");
        System.out.println("    quicksort: O(n log n) expected, in place, not stable");
        System.out.println("    counting/radix: O(n) for bounded integer keys");
    }

    private int[] insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
        return a;
    }

    private int[] mergeSort(int[] a) {
        if (a.length <= 1) {
            return a;
        }
        int mid = a.length / 2;
        int[] left = mergeSort(java.util.Arrays.copyOfRange(a, 0, mid));
        int[] right = mergeSort(java.util.Arrays.copyOfRange(a, mid, a.length));
        int[] result = new int[a.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            result[k++] = (left[i] <= right[j]) ? left[i++] : right[j++];
        }
        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }
        return result;
    }

    private int[] quickSort(int[] a, int low, int high) {
        if (low < high) {
            int pivot = a[high];
            int p = low;
            for (int j = low; j < high; j++) {
                if (a[j] < pivot) {
                    int t = a[p];
                    a[p] = a[j];
                    a[j] = t;
                    p++;
                }
            }
            int t = a[p];
            a[p] = a[high];
            a[high] = t;
            quickSort(a, low, p - 1);
            quickSort(a, p + 1, high);
        }
        return a;
    }
}
