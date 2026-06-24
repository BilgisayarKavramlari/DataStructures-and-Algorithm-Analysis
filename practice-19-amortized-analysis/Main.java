/** Main driver for Practice 19: Amortized Analysis. */
public class Main {
    public static void main(String[] args) {
        System.out.println("CS 3345 Practice 19: Amortized Analysis");
        System.out.println("Related Course Module: Module 6");
        System.out.println("Weiss topic: Chapter 11, Amortized Analysis");
        System.out.println("Goal: trace complete plain-Java examples for live teaching.\n");
        DynamicArray.run();
        DynamicArrayResizeTraceDemo.run();
        AggregateAnalysisDemo.run();
        AccountingMethodDemo.run();
        PotentialMethodIntuitionDemo.run();
        RehashingAmortizedDemo.run();
        SplayAmortizedIntuitionDemo.run();
        BinomialQueueAmortizedDemo.run();
        SkewHeapAmortizedDemo.run();
        FibonacciHeapConceptDemo.run();
        System.out.println("End of Practice 19. Re-run after changing input values to experiment.");
    }
}
