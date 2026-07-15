/**
 * AdjacencyMatrixGraph
 *
 * Represents:
 *   A graph stored as a V-by-V matrix where entry [u][v] records the edge from
 *   u to v (weight, or 0 / INF for "no edge"). This gives O(1) edge lookup at
 *   the cost of O(V^2) space regardless of how few edges exist.
 *
 * Invariant:
 *   matrix is V-by-V; for an undirected graph the matrix is symmetric.
 *
 * Main operations: addEdge, hasEdge (O(1)), neighbour scan (O(V)).
 *
 * Edge cases: the 'directed' flag controls symmetry; self-loops sit on the
 *   diagonal.
 *
 * Time complexity: addEdge and hasEdge O(1); enumerating a vertex's neighbours
 *   O(V). Space complexity: O(V^2), best suited to dense graphs.
 */
public class AdjacencyMatrixGraph {

    private final int vertices;
    private final boolean directed;
    private final int[][] matrix;

    public AdjacencyMatrixGraph(int vertices, boolean directed) {
        this.vertices = vertices;
        this.directed = directed;
        this.matrix = new int[vertices][vertices];
    }

    public void addEdge(int from, int to) {
        addEdge(from, to, 1);
    }

    public void addEdge(int from, int to, int weight) {
        matrix[from][to] = weight;
        if (!directed) {
            matrix[to][from] = weight;
        }
    }

    public boolean hasEdge(int from, int to) {
        return matrix[from][to] != 0;
    }

    public int vertexCount() {
        return vertices;
    }

    public void print() {
        System.out.print("     ");
        for (int v = 0; v < vertices; v++) {
            System.out.printf("%3d", v);
        }
        System.out.println();
        for (int u = 0; u < vertices; u++) {
            System.out.printf("  %2d ", u);
            for (int v = 0; v < vertices; v++) {
                System.out.printf("%3d", matrix[u][v]);
            }
            System.out.println();
        }
    }
}
