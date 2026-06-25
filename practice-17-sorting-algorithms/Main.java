/**
 * Main - Practice 17: Sorting Algorithms
 *
 * Demonstrates insertion sort and its link to inversions, shell sort, heap sort,
 * merge sort, partitioning quicksort, median-of-three quicksort, quickselect,
 * radix and bucket sort, sort stability, a timing comparison validated against a
 * baseline, and the comparison-sort lower bound.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("==== Practice 17: Sorting Algorithms ====");
        run("Insertion sort", new InsertionSort()::demonstrate);
        run("Inversions", new InversionCountingDemo()::demonstrate);
        run("Shell sort", new ShellSort()::demonstrate);
        run("Heap sort", new HeapSort()::demonstrate);
        run("Merge sort", new MergeSort()::demonstrate);
        run("Quicksort (partitioning)", new QuickSort()::demonstrate);
        run("Median-of-three quicksort", new MedianOfThreeQuickSort()::demonstrate);
        run("Quickselect", new QuickSelect()::demonstrate);
        run("Radix sort", new RadixSortIntro()::demonstrate);
        run("Bucket sort", new BucketSortIntro()::demonstrate);
        run("Stability", new SortingStabilityDemo()::demonstrate);
        run("Timing comparison", new SortingTimingComparison()::demonstrate);
        run("Lower bound intuition", new SortingLowerBoundIntuitionDemo()::demonstrate);
        System.out.println();
        System.out.println("Sorting study complete.");
    }

    private static void run(String title, Runnable demo) {
        System.out.println();
        System.out.println("--- " + title + " ---");
        demo.run();
    }
}
