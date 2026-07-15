/**
 * HeapSort
 *
 * Sorts in place by first building a max-heap, then repeatedly swapping the
 * root (the maximum) to the end and shrinking the heap. Uses 0-based array
 * indexing with children at 2i+1 and 2i+2.
 *
 * Invariant: after k extractions, the last k array slots hold the k largest
 * values in sorted order, and the prefix is a valid max-heap.
 *
 * Time complexity: O(n log n) in all cases. Space complexity: O(1).
 */
public class HeapSort {

    public static void sort(int[] a) {
        int n = a.length;
        // Build a max-heap bottom-up in O(n).
        for (int i = n / 2 - 1; i >= 0; i--) {
            siftDown(a, i, n);
        }
        // Repeatedly move the max to the end.
        for (int end = n - 1; end > 0; end--) {
            swap(a, 0, end);
            siftDown(a, 0, end);
        }
    }

    private static void siftDown(int[] a, int i, int heapSize) {
        while (true) {
            int largest = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if (left < heapSize && a[left] > a[largest]) {
                largest = left;
            }
            if (right < heapSize && a[right] > a[largest]) {
                largest = right;
            }
            if (largest == i) {
                break;
            }
            swap(a, i, largest);
            i = largest;
        }
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public void demonstrate() {
        int[] a = {12, 4, 17, 9, 1, 20, 6};
        System.out.println("Before: " + java.util.Arrays.toString(a));
        sort(a);
        System.out.println("After : " + java.util.Arrays.toString(a));
        System.out.println("A max-heap places the largest element last on each extraction.");
    }
}
