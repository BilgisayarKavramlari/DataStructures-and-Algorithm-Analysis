/**
 * CycleDetectionDemo
 *
 * Detects cycles in a directed graph using depth-first search with three vertex
 * colours: white (undiscovered), gray (on the current recursion path), and
 * black (fully finished). Reaching a gray vertex means an edge points back into
 * the active path, which is a cycle (a back edge).
 *
 * Invariant: a vertex is gray exactly while it sits on the active DFS path.
 *
 * Time complexity: O(V + E). Space complexity: O(V) for the colour array and
 *   recursion stack.
 */
public class CycleDetectionDemo {

    private static final int WHITE = 0;
    private static final int GRAY = 1;
    private static final int BLACK = 2;

    private Graph graph;
    private int[] colour;
    private boolean cycleFound;

    public void demonstrate() {
        System.out.println("Graph A (acyclic): 0->1, 0->2, 1->3, 2->3");
        runOn(buildAcyclic());

        System.out.println();
        System.out.println("Graph B (cyclic): 0->1, 1->2, 2->0");
        runOn(buildCyclic());
    }

    private Graph buildAcyclic() {
        Graph g = new Graph(4, true);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        return g;
    }

    private Graph buildCyclic() {
        Graph g = new Graph(3, true);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        return g;
    }

    private void runOn(Graph g) {
        graph = g;
        colour = new int[g.vertexCount()];
        cycleFound = false;
        for (int v = 0; v < g.vertexCount() && !cycleFound; v++) {
            if (colour[v] == WHITE) {
                visit(v);
            }
        }
        System.out.println("  contains a cycle: " + cycleFound);
    }

    private void visit(int vertex) {
        colour[vertex] = GRAY;
        for (int next : graph.neighbours(vertex)) {
            if (colour[next] == GRAY) {
                System.out.println("  back edge " + vertex + " -> " + next + " closes a cycle");
                cycleFound = true;
                return;
            }
            if (colour[next] == WHITE) {
                visit(next);
                if (cycleFound) {
                    return;
                }
            }
        }
        colour[vertex] = BLACK;
    }
}
