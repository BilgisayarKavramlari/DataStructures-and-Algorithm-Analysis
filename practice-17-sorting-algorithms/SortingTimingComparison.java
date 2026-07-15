import java.util.Arrays;
import java.util.Random;

/**
 * SortingTimingComparison
 *
 * Times insertion sort, shell sort, merge sort, heap sort, and quicksort on the
 * same random input, and validates every result against Arrays.sort used purely
 * as a correctness baseline (never as a sorting implementation). The measured
 * times illustrate the gap between the O(n^2) and O(n log n) methods.
 *
 * Time complexity: dominated by the O(n^2) insertion sort on the chosen size.
 */
public class SortingTimingComparison {

    public void demonstrate() {
        int n = 20000;
        Random rng = new Random(42);
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = rng.nextInt(1_000_000);
        }
        int[] reference = data.clone();
        Arrays.sort(reference);              // baseline for correctness only

        time("Insertion sort", data, reference, InsertionSort::sort);
        time("Shell sort", data, reference, ShellSort::sort);
        time("Merge sort", data, reference, MergeSort::sort);
        time("Heap sort", data, reference, HeapSort::sort);
        time("Quicksort", data, reference, QuickSort::sort);
        System.out.println();
        System.out.println("The O(n log n) sorts finish far faster than the O(n^2) insertion sort.");
    }

    private void time(String name, int[] original, int[] reference, SortFn fn) {
        int[] copy = original.clone();
        long start = System.nanoTime();
        fn.sort(copy);
        long elapsed = System.nanoTime() - start;
        boolean correct = Arrays.equals(copy, reference);
        System.out.printf("  %-15s %6.1f ms  correct=%b%n",
                name, elapsed / 1_000_000.0, correct);
    }

    private interface SortFn {
        void sort(int[] a);
    }
}
