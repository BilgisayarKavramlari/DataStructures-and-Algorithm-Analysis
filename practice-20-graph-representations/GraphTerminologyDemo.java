/**
 * GraphTerminologyDemo
 *
 * Introduces the vocabulary used throughout the graph practices: vertices,
 * edges, directed versus undirected, weighted versus unweighted, paths, cycles,
 * degree, adjacency, density, and connectivity. The demo prints worked
 * definitions against one concrete small graph so the terms are anchored to an
 * example rather than left abstract.
 *
 * Time complexity: O(1) printing. Space complexity: O(1).
 */
public class GraphTerminologyDemo {

    public void demonstrate() {
        System.out.println("Reference graph (undirected): vertices {0,1,2,3}, edges:");
        System.out.println("  0 - 1, 0 - 2, 1 - 2, 2 - 3");
        System.out.println();

        System.out.println("Vertex: a node of the graph. Here there are 4 vertices.");
        System.out.println("Edge: a connection between two vertices. Here there are 4 edges.");
        System.out.println("Undirected edge: symmetric, so 0 - 1 means 0 reaches 1 and 1 reaches 0.");
        System.out.println("Directed edge (arc): one-way, written u -> v.");
        System.out.println("Adjacent: 0 and 1 are adjacent because edge 0 - 1 exists.");
        System.out.println("Degree: number of incident edges. deg(2) = 3 (to 0, 1, 3).");
        System.out.println("Path: a sequence of edges, e.g. 0 - 1 - 2 - 3.");
        System.out.println("Cycle: a path returning to its start, e.g. 0 - 1 - 2 - 0.");
        System.out.println("Connected: every vertex is reachable from every other; this graph is connected.");
        System.out.println("Weighted: each edge carries a numeric cost (not present in this example).");
        System.out.println();

        int vertices = 4;
        int edges = 4;
        int maxEdges = vertices * (vertices - 1) / 2;
        double density = (double) edges / maxEdges;
        System.out.printf("Density = edges / maxPossibleEdges = %d / %d = %.2f%n",
                edges, maxEdges, density);
        System.out.println("Low density favours adjacency lists; high density favours a matrix.");
    }
}
