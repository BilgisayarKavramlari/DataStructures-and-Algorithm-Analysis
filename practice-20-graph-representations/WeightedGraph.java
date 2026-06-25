import java.util.ArrayList;
import java.util.List;

/**
 * WeightedGraph
 *
 * Represents:
 *   An adjacency-list graph whose edges carry weights, used to show that the
 *   list representation extends naturally to weighted problems. This is the
 *   structure that the shortest-path and MST practices build upon.
 *
 * Invariant: adj has one neighbour list per vertex; weights are stored on each
 *   Edge object.
 *
 * Time complexity: addEdge O(1); neighbour scan O(deg(v)).
 * Space complexity: O(V + E).
 */
public class WeightedGraph {

    private final int vertices;
    private final List<List<Edge>> adj;

    public WeightedGraph(int vertices) {
        this.vertices = vertices;
        this.adj = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addUndirectedEdge(int u, int v, int weight) {
        adj.get(u).add(new Edge(v, weight));
        adj.get(v).add(new Edge(u, weight));
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
