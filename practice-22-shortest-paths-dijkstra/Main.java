/** Main driver for Practice 22: Shortest Paths Dijkstra. */
public class Main {
    public static void main(String[] args) {
        System.out.println("CS 3345 Practice 22: Shortest Paths Dijkstra");
        System.out.println("Related Course Module: Module 8");
        System.out.println("Weiss topic: Chapter 9, Shortest Paths");
        System.out.println("Goal: trace complete plain-Java examples for live teaching.\n");
        UnweightedShortestPathBFS.run();
        WeightedGraphForShortestPath.run();
        DijkstraWithoutPriorityQueue.run();
        DijkstraWithPriorityQueue.run();
        RelaxationTraceDemo.run();
        PathReconstructionDemo.run();
        NegativeEdgeCounterexample.run();
        DAGShortestPathDemo.run();
        AllPairsShortestPathDemo.run();
        System.out.println("End of Practice 22. Re-run after changing input values to experiment.");
    }
}
