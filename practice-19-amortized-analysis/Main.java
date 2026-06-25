/**
 * Main - Practice 19: Amortized Analysis
 *
 * Demonstrates amortized analysis through the doubling dynamic array, then the
 * three standard analysis techniques (aggregate, accounting, potential), and
 * applies the same reasoning to rehashing, splay trees, binomial queues, skew
 * heaps, and the Fibonacci heap.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("==== Practice 19: Amortized Analysis ====");
        run("Dynamic array resize trace", new DynamicArrayResizeTraceDemo()::demonstrate);
        run("Aggregate method", new AggregateAnalysisDemo()::demonstrate);
        run("Accounting method", new AccountingMethodDemo()::demonstrate);
        run("Potential method", new PotentialMethodIntuitionDemo()::demonstrate);
        run("Rehashing amortized", new RehashingAmortizedDemo()::demonstrate);
        run("Splay amortized intuition", new SplayAmortizedIntuitionDemo()::demonstrate);
        run("Binomial queue amortized", new BinomialQueueAmortizedDemo()::demonstrate);
        run("Skew heap amortized", new SkewHeapAmortizedDemo()::demonstrate);
        run("Fibonacci heap concept", new FibonacciHeapConceptDemo()::demonstrate);
        System.out.println();
        System.out.println("Amortized analysis study complete.");
    }

    private static void run(String title, Runnable demo) {
        System.out.println();
        System.out.println("--- " + title + " ---");
        demo.run();
    }
}
