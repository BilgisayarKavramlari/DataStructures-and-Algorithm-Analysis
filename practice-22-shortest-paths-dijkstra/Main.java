/**
 * Main - Practice 22: Shortest Paths and Dijkstra
 *
 * Demonstrates unweighted shortest paths via BFS, Dijkstra both with a linear
 * scan and with a binary-heap priority queue, the relaxation primitive, path
 * reconstruction via predecessors, why negative edges break Dijkstra, linear
 * DAG shortest paths, and Floyd-Warshall all-pairs shortest paths.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("==== Practice 22: Shortest Paths and Dijkstra ====");
        run("Unweighted shortest path (BFS)", new UnweightedShortestPathBFS()::demonstrate);
        run("Dijkstra (no priority queue)", new DijkstraWithoutPriorityQueue()::demonstrate);
        run("Dijkstra (priority queue)", new DijkstraWithPriorityQueue()::demonstrate);
        run("Relaxation trace", new RelaxationTraceDemo()::demonstrate);
        run("Path reconstruction", new PathReconstructionDemo()::demonstrate);
        run("Negative edge counterexample", new NegativeEdgeCounterexample()::demonstrate);
        run("DAG shortest path", new DAGShortestPathDemo()::demonstrate);
        run("All-pairs shortest path", new AllPairsShortestPathDemo()::demonstrate);
        System.out.println();
        System.out.println("Shortest-path study complete.");
    }

    private static void run(String title, Runnable demo) {
        System.out.println();
        System.out.println("--- " + title + " ---");
        demo.run();
    }
}
