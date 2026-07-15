/**
 * Main - Practice 26: Data Structure Selection
 *
 * Focuses on choosing the right structure for a problem: worked selection cases,
 * an operation-cost comparison table, a rule-based use-case classifier, and
 * several specialised structures that broaden the selection toolkit (treap,
 * suffix array, k-d tree, pairing heap), closing with a course-wide complexity
 * summary.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("==== Practice 26: Data Structure Selection ====");
        run("Selection cases", new DataStructureSelectionCases()::demonstrate);
        run("Operation cost comparison", new OperationCostComparison()::demonstrate);
        run("Use-case classifier", new RealWorldUseCaseClassifier()::demonstrate);
        run("Treap", new TreapEducationalDemo()::demonstrate);
        run("Suffix array string index", new SuffixArrayStyleStringIndexDemo()::demonstrate);
        run("k-d tree range search", new KDTreeSimplifiedRangeSearchDemo()::demonstrate);
        run("Pairing heap", new PairingHeapEducationalDemo()::demonstrate);
        run("Complexity summary", new ComplexitySummaryDemo()::demonstrate);
        System.out.println();
        System.out.println("Data structure selection study complete.");
    }

    private static void run(String title, Runnable demo) {
        System.out.println();
        System.out.println("--- " + title + " ---");
        demo.run();
    }
}
