/**
 * MedianOfThreeQuickSort
 *
 * Improves QuickSort's pivot choice by taking the median of the first, middle,
 * and last elements. This avoids the O(n^2) trap on already-sorted or
 * reverse-sorted input, where a fixed-end pivot performs worst. Uses Hoare-style
 * partitioning around the chosen median.
 *
 * Time complexity: O(n log n) average with a much smaller chance of the worst
 * case. Space complexity: O(log n) recursion depth.
 */
public class MedianOfThreeQuickSort {

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int pivot = medianOfThree(a, lo, hi);
        int i = lo - 1;
        int j = hi + 1;
        while (true) {
            do {
                i++;
            } while (a[i] < pivot);
            do {
                j--;
            } while (a[j] > pivot);
            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        sort(a, lo, j);
        sort(a, j + 1, hi);
    }

    // Returns the median value of a[lo], a[mid], a[hi].
    private static int medianOfThree(int[] a, int lo, int hi) {
        int mid = (lo + hi) / 2;
        int x = a[lo];
        int y = a[mid];
        int z = a[hi];
        if ((x <= y && y <= z) || (z <= y && y <= x)) {
            return y;
        }
        if ((y <= x && x <= z) || (z <= x && x <= y)) {
            return x;
        }
        return z;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public void demonstrate() {
        int[] sorted = {1, 2, 3, 4, 5, 6, 7, 8};   // worst case for a naive pivot
        System.out.println("Already-sorted input is the naive-pivot worst case.");
        System.out.println("Before: " + java.util.Arrays.toString(sorted));
        sort(sorted);
        System.out.println("After : " + java.util.Arrays.toString(sorted));
        System.out.println("Median-of-three keeps partitions balanced even on sorted input.");
    }
}
