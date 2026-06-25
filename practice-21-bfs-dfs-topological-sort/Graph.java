import java.util.ArrayList;
import java.util.List;

/**
 * Graph
 *
 * A minimal adjacency-list graph shared by the traversal demos in this folder.
 * Supports both directed and undirected construction.
 *
 * Invariant: adj has one neighbour list per vertex; for undirected graphs each
 * edge is stored in both endpoints' lists.
 *
 * Time complexity: addEdge O(1); neighbour scan O(deg(v)).
 * Space complexity: O(V + E).
 */
public class Graph {

    private final int vertices;
    private final boolean directed;
    private final List<List<Integer>> adj;

    public Graph(int vertices, boolean directed) {
        this.vertices = vertices;
        this.directed = directed;
        this.adj = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int from, int to) {
        adj.get(from).add(to);
        if (!directed) {
            adj.get(to).add(from);
        }
    }

    public List<Integer> neighbours(int vertex) {
        return adj.get(vertex);
    }

    public int vertexCount() {
        return vertices;
    }
}
