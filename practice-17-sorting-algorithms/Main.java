/** Main driver for Practice 17: Sorting Algorithms. */
public class Main {
    public static void main(String[] args) {
        System.out.println("CS 3345 Practice 17: Sorting Algorithms");
        System.out.println("Related Course Module: Module 5");
        System.out.println("Weiss topic: Chapter 7, Sorting");
        System.out.println("Goal: trace complete plain-Java examples for live teaching.\n");
        InsertionSort.run();
        InversionCountingDemo.run();
        ShellSort.run();
        HeapSort.run();
        MergeSort.run();
        QuickSort.run();
        MedianOfThreeQuickSort.run();
        QuickSelect.run();
        RadixSortIntro.run();
        BucketSortIntro.run();
        SortingStabilityDemo.run();
        SortingTimingComparison.run();
        SortingLowerBoundIntuitionDemo.run();
        System.out.println("End of Practice 17. Re-run after changing input values to experiment.");
    }
}
