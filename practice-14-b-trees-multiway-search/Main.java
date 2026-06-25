/**
 * Main - Practice 14: B-Trees and Multi-Way Search
 *
 * Demonstrates multiway search, B-tree search depth, a step-by-step insertion
 * trace with node splitting, a focused split event, and the concept behind
 * B-tree deletion.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("==== Practice 14: B-Trees and Multi-Way Search ====");
        run("Multiway search", new MultiwaySearchDemo()::demonstrate);
        run("B-tree search depth", new BTreeSearchDemo()::demonstrate);
        run("Insertion trace", new BTreeInsertionTraceDemo()::demonstrate);
        run("Node split", new BTreeSplitDemo()::demonstrate);
        run("Deletion concept", new BTreeDeletionConceptDemo()::demonstrate);
        System.out.println();
        System.out.println("B-tree study complete.");
    }

    private static void run(String title, Runnable demo) {
        System.out.println();
        System.out.println("--- " + title + " ---");
        demo.run();
    }
}
