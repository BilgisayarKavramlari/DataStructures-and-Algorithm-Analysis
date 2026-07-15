/**
 * Main - Practice 16: Binary Heap and Priority Queue
 *
 * Demonstrates the array index layout, insert/deleteMin tracing, O(n) buildHeap,
 * decreaseKey/increaseKey, deletion at an arbitrary position, heap-based
 * selection, event simulation, a d-ary heap, mergeable leftist and skew heaps,
 * the binomial-queue carry analogy, and the standard java.util.PriorityQueue.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("==== Practice 16: Binary Heap and Priority Queue ====");
        run("Array index layout", new HeapArrayIndexDemo()::demonstrate);
        run("Insert and deleteMin", new HeapInsertDeleteMinDemo()::demonstrate);
        run("buildHeap in O(n)", new BuildHeapDemo()::demonstrate);
        run("decreaseKey / increaseKey", new DecreaseIncreaseKeyDemo()::demonstrate);
        run("Delete at position", new DeleteAtPositionDemo()::demonstrate);
        run("Selection with a heap", new SelectionProblemHeapDemo()::demonstrate);
        run("Event simulation", new EventSimulationDemo()::demonstrate);
        run("d-ary heap", new DHeapEducationalDemo()::demonstrate);
        run("Leftist heap (mergeable)", new LeftistHeapEducational()::demonstrate);
        run("Skew heap (mergeable)", new SkewHeapEducational()::demonstrate);
        run("Binomial queue intuition", new BinomialQueueEducationalDemo()::demonstrate);
        run("java.util.PriorityQueue", new JavaPriorityQueueDemo()::demonstrate);
        System.out.println();
        System.out.println("Heap and priority queue study complete.");
    }

    private static void run(String title, Runnable demo) {
        System.out.println();
        System.out.println("--- " + title + " ---");
        demo.run();
    }
}
