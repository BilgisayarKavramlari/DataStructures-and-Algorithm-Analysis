/** Main driver for Practice 23: Disjoint Sets Union Find. */
public class Main {
    public static void main(String[] args) {
        System.out.println("CS 3345 Practice 23: Disjoint Sets Union Find");
        System.out.println("Related Course Module: Module 9");
        System.out.println("Weiss topic: Chapter 8, Disjoint Sets");
        System.out.println("Goal: trace complete plain-Java examples for live teaching.\n");
        QuickFind.run();
        QuickUnion.run();
        UnionBySize.run();
        UnionByRank.run();
        PathCompressionDemo.run();
        PathHalvingDemo.run();
        EquivalenceClassDisplay.run();
        UnionFindComplexityExperiment.run();
        MazeGenerationDemo.run();
        System.out.println("End of Practice 23. Re-run after changing input values to experiment.");
    }
}
