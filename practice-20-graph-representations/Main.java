/**
 * Main - Practice 20: Graph Representations
 *
 * Demonstrates graph terminology and the three standard representations
 * (adjacency list, adjacency matrix, edge list), a weighted adjacency list,
 * degree / in-degree / out-degree computation, and a space comparison of the
 * sparse versus dense regimes.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("==== Practice 20: Graph Representations ====");
        run("Terminology", new GraphTerminologyDemo()::demonstrate);
        run("Adjacency list", Main::adjacencyListDemo);
        run("Adjacency matrix", Main::adjacencyMatrixDemo);
        run("Edge list", Main::edgeListDemo);
        run("Weighted graph", Main::weightedGraphDemo);
        run("Degrees", new DegreeIndegreeOutdegreeDemo()::demonstrate);
        run("Sparse vs dense", new SparseDenseGraphComparison()::demonstrate);
        System.out.println();
        System.out.println("Graph representation study complete.");
    }

    private static void adjacencyListDemo() {
        AdjacencyListGraph g = new AdjacencyListGraph(4, false);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        System.out.println("Undirected graph as adjacency list:");
        g.print();
    }

    private static void adjacencyMatrixDemo() {
        AdjacencyMatrixGraph g = new AdjacencyMatrixGraph(4, false);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        System.out.println("Same graph as adjacency matrix (1 = edge):");
        g.print();
    }

    private static void edgeListDemo() {
        EdgeListGraph g = new EdgeListGraph(4);
        g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 3, 8);
        System.out.println("Same graph as a flat edge list (weighted):");
        g.print();
    }

    private static void weightedGraphDemo() {
        WeightedGraph g = new WeightedGraph(4);
        g.addUndirectedEdge(0, 1, 5);
        g.addUndirectedEdge(0, 2, 3);
        g.addUndirectedEdge(2, 3, 8);
        System.out.println("Weighted adjacency list:");
        g.print();
    }

    private static void run(String title, Runnable demo) {
        System.out.println();
        System.out.println("--- " + title + " ---");
        demo.run();
    }
}
