import java.util.ArrayList;
import java.util.List;

/**
 * WeightedGraphForMST
 *
 * An undirected weighted graph for the minimum-spanning-tree demos, offered in
 * two views: an adjacency list (used by Prim) and an edge list (used by
 * Kruskal). Building both from the same construction keeps the algorithms
 * comparable on identical input.
 *
 * Invariant: every undirected edge {u,v,w} appears in both adjacency lists and
 * once in the edge list.
 *
 * Time complexity: addEdge O(1). Space complexity: O(V + E).
 */
public class WeightedGraphForMST {

    public static class Edge {
        public final int u;
        public final int v;
        public final int weight;

        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return u + "-" + v + "(" + weight + ")";
        }
    }

    public static class Neighbour {
        public final int to;
        public final int weight;

        public Neighbour(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    private final int vertices;
    private final List<List<Neighbour>> adj;
    private final List<Edge> edges = new ArrayList<>();

    public WeightedGraphForMST(int vertices) {
        this.vertices = vertices;
        this.adj = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v, int weight) {
        adj.get(u).add(new Neighbour(v, weight));
        adj.get(v).add(new Neighbour(u, weight));
        edges.add(new Edge(u, v, weight));
    }

    public List<Neighbour> neighbours(int vertex) {
        return adj.get(vertex);
    }

    public List<Edge> edges() {
        return edges;
    }

    public int vertexCount() {
        return vertices;
    }
}
