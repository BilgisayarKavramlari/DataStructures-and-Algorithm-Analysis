import java.util.ArrayList;
import java.util.List;

/**
 * WeightedGraphForShortestPath
 *
 * A directed, weighted adjacency-list graph shared by the shortest-path demos.
 * Each neighbour entry carries the edge weight, which the relaxation step uses.
 *
 * Invariant: adj has one neighbour list per vertex; weights are non-negative
 * unless a demo explicitly constructs a counterexample.
 *
 * Time complexity: addEdge O(1); neighbour scan O(deg(v)).
 * Space complexity: O(V + E).
 */
public class WeightedGraphForShortestPath {

    public static class Arc {
        public final int to;
        public final int weight;

        public Arc(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    private final int vertices;
    private final List<List<Arc>> adj;

    public WeightedGraphForShortestPath(int vertices) {
        this.vertices = vertices;
        this.adj = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addArc(int from, int to, int weight) {
        adj.get(from).add(new Arc(to, weight));
    }

    public void addUndirected(int u, int v, int weight) {
        adj.get(u).add(new Arc(v, weight));
        adj.get(v).add(new Arc(u, weight));
    }

    public List<Arc> neighbours(int vertex) {
        return adj.get(vertex);
    }

    public int vertexCount() {
        return vertices;
    }
}
