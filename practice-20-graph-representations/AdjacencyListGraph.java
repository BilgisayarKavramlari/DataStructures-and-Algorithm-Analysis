import java.util.ArrayList;
import java.util.List;

/**
 * AdjacencyListGraph
 *
 * Represents:
 *   A graph stored as one list of neighbours per vertex. This is the workhorse
 *   representation for sparse graphs and underlies the traversal and
 *   shortest-path practices.
 *
 * Invariant:
 *   adj has one entry per vertex; for an undirected graph each edge {u,v} is
 *   recorded in both adj[u] and adj[v].
 *
 * Main operations: addEdge, neighbours iteration.
 *
 * Edge cases: self-loops and the distinction between directed and undirected
 *   insertion are handled by the 'directed' flag.
 *
 * Time complexity: addEdge O(1); listing neighbours of v is O(deg(v));
 *   total space O(V + E). This is far better than O(V^2) for sparse graphs.
 */
public class AdjacencyListGraph {

    private final int vertices;
    private final boolean directed;
    private final List<List<Edge>> adj;

    public AdjacencyListGraph(int vertices, boolean directed) {
        this.vertices = vertices;
        this.directed = directed;
        this.adj = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int from, int to) {
        addEdge(from, to, 1);
    }

    public void addEdge(int from, int to, int weight) {
        adj.get(from).add(new Edge(to, weight));
        if (!directed) {
            adj.get(to).add(new Edge(from, weight));
        }
    }

    public List<Edge> neighbours(int vertex) {
        return adj.get(vertex);
    }

    public int vertexCount() {
        return vertices;
    }

    public void print() {
        for (int v = 0; v < vertices; v++) {
            System.out.println("  " + v + " -> " + adj.get(v));
        }
    }
}
