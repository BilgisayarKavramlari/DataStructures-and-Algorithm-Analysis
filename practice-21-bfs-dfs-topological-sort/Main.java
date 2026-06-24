/** Main driver for Practice 21: Bfs Dfs Topological Sort. */
public class Main {
    public static void main(String[] args) {
        System.out.println("CS 3345 Practice 21: Bfs Dfs Topological Sort");
        System.out.println("Related Course Module: Module 7");
        System.out.println("Weiss topic: Chapter 9, BFS, DFS, Topological Sort");
        System.out.println("Goal: trace complete plain-Java examples for live teaching.\n");
        BFS.run();
        DFSRecursive.run();
        DFSIterative.run();
        ConnectedComponents.run();
        CycleDetectionDemo.run();
        TopologicalSortIndegreeScan.run();
        TopologicalSortQueue.run();
        DAGValidationDemo.run();
        TraversalTraceDemo.run();
        System.out.println("End of Practice 21. Re-run after changing input values to experiment.");
    }
}
