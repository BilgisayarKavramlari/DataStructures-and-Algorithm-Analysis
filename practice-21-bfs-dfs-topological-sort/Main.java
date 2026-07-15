/**
 * Main - Practice 21: BFS, DFS, and Topological Sort
 *
 * Demonstrates breadth-first search, recursive and iterative depth-first
 * search, connected-component labeling, directed cycle detection, two
 * topological-sort methods (scan and Kahn's queue), DAG validation, and a
 * side-by-side BFS/DFS trace.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("==== Practice 21: BFS, DFS, and Topological Sort ====");
        run("Breadth-first search", new BFS()::demonstrate);
        run("Depth-first search (recursive)", new DFSRecursive()::demonstrate);
        run("Depth-first search (iterative)", new DFSIterative()::demonstrate);
        run("Connected components", new ConnectedComponents()::demonstrate);
        run("Cycle detection", new CycleDetectionDemo()::demonstrate);
        run("Topological sort (scan)", new TopologicalSortIndegreeScan()::demonstrate);
        run("Topological sort (queue)", new TopologicalSortQueue()::demonstrate);
        run("DAG validation", new DAGValidationDemo()::demonstrate);
        run("Traversal trace", new TraversalTraceDemo()::demonstrate);
        System.out.println();
        System.out.println("Traversal and ordering study complete.");
    }

    private static void run(String title, Runnable demo) {
        System.out.println();
        System.out.println("--- " + title + " ---");
        demo.run();
    }
}
