/** Main driver for Practice 20: Graph Representations. */
public class Main {
    public static void main(String[] args) {
        System.out.println("CS 3345 Practice 20: Graph Representations");
        System.out.println("Related Course Module: Module 7");
        System.out.println("Weiss topic: Chapter 9, Graph Definitions and Representations");
        System.out.println("Goal: trace complete plain-Java examples for live teaching.\n");
        GraphTerminologyDemo.run();
        Edge.run();
        AdjacencyListGraph.run();
        AdjacencyMatrixGraph.run();
        EdgeListGraph.run();
        WeightedGraph.run();
        DegreeIndegreeOutdegreeDemo.run();
        SparseDenseGraphComparison.run();
        System.out.println("End of Practice 20. Re-run after changing input values to experiment.");
    }
}
