/**
 * Main - Practice 23: Disjoint Sets and Union-Find
 *
 * Demonstrates quick-find and quick-union, the two balancing rules (union by
 * size and union by rank), path compression and path halving, equivalence-class
 * display, an empirical complexity experiment, and maze generation as an
 * application.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("==== Practice 23: Disjoint Sets and Union-Find ====");
        run("Quick-find", new QuickFind(1)::demonstrate);
        run("Quick-union", new QuickUnion(1)::demonstrate);
        run("Union by size", new UnionBySize(1)::demonstrate);
        run("Union by rank", new UnionByRank(1)::demonstrate);
        run("Path compression", new PathCompressionDemo()::demonstrate);
        run("Path halving", new PathHalvingDemo()::demonstrate);
        run("Equivalence classes", new EquivalenceClassDisplay()::demonstrate);
        run("Complexity experiment", new UnionFindComplexityExperiment()::demonstrate);
        run("Maze generation", new MazeGenerationDemo()::demonstrate);
        System.out.println();
        System.out.println("Disjoint-set study complete.");
    }

    private static void run(String title, Runnable demo) {
        System.out.println();
        System.out.println("--- " + title + " ---");
        demo.run();
    }
}
