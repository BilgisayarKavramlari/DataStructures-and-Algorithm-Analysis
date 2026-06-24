/** Main driver for Practice 07: Formal Algorithm Analysis. */
public class Main {
    public static void main(String[] args) {
        System.out.println("CS 3345 Practice 07: Formal Algorithm Analysis");
        System.out.println("Related Course Module: Module 1 / Module 2");
        System.out.println("Weiss topic: Chapter 2, formal algorithm analysis");
        System.out.println("Goal: trace complete plain-Java examples for live teaching.\n");
        BigONotationExamples.run();
        BigOmegaThetaLittleODemo.run();
        LoopCountingDemo.run();
        NestedLoopAnalysisDemo.run();
        ConsecutiveStatementsDemo.run();
        IfElseAnalysisDemo.run();
        BinarySearchTraceDemo.run();
        RecurrenceTraceDemo.run();
        MergeSortRecurrenceDemo.run();
        SpaceComplexityDemo.run();
        System.out.println("End of Practice 07. Re-run after changing input values to experiment.");
    }
}
