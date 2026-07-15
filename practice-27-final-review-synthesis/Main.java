/**
 * Main - Practice 27: Final Review and Synthesis
 *
 * Synthesises the whole course: one dataset traced through several structures, a
 * complexity-classification review, data-structure selection review, the
 * tree/heap/hash families compared, a combined graph shortest-path and MST
 * review, a sorting review, and exam-style practice questions with worked
 * answers.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("==== Practice 27: Final Review and Synthesis ====");
        run("Cumulative trace", new CumulativeTraceDemo()::demonstrate);
        run("Complexity classification review", new ComplexityClassificationReview()::demonstrate);
        run("Data structure selection review", new DataStructureSelectionReview()::demonstrate);
        run("Tree, heap, hash review", new TreeHeapHashReview()::demonstrate);
        run("Graph path and MST review", new GraphPathMSTReview()::demonstrate);
        run("Sorting review", new SortingReview()::demonstrate);
        run("Final exam style practice", new FinalExamStylePractice()::demonstrate);
        System.out.println();
        System.out.println("Final review and synthesis complete. Good luck on the exam.");
    }

    private static void run(String title, Runnable demo) {
        System.out.println();
        System.out.println("--- " + title + " ---");
        demo.run();
    }
}
