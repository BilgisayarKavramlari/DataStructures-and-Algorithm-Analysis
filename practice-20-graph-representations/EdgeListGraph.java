import java.util.ArrayList;
import java.util.List;

/**
 * EdgeListGraph
 *
 * Represents:
 *   A graph stored simply as a flat list of (from, to, weight) triples. This is
 *   the most compact representation and is exactly what algorithms like Kruskal
 *   want, since they process edges in sorted order rather than by vertex.
 *
 * Invariant: every stored triple references valid vertices.
 *
 * Main operations: addEdge O(1); answering "is u adjacent to v" requires
 *   scanning all edges, which is O(E).
 *
 * Time complexity: addEdge O(1), adjacency query O(E). Space complexity: O(E).
 */
public class EdgeListGraph {

    public static class Triple {
        public final int from;
        public final int to;
        public final int weight;

        public Triple(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "(" + from + " - " + to + ", w=" + weight + ")";
        }
    }

    private final int vertices;
    private final List<Triple> edges = new ArrayList<>();

    public EdgeListGraph(int vertices) {
        this.vertices = vertices;
    }

    public void addEdge(int from, int to, int weight) {
        edges.add(new Triple(from, to, weight));
    }

    public List<Triple> edges() {
        return edges;
    }

    public int vertexCount() {
        return vertices;
    }

    public void print() {
        for (Triple t : edges) {
            System.out.println("  " + t);
        }
    }
}
