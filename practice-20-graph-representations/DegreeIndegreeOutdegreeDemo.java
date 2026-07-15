/**
 * DegreeIndegreeOutdegreeDemo
 *
 * Shows how to compute vertex degrees from an adjacency-list graph. For an
 * undirected graph each vertex has a single degree; for a directed graph each
 * vertex has an in-degree (incoming arcs) and an out-degree (outgoing arcs).
 * In-degrees are central to topological sorting, covered in a later practice.
 *
 * Time complexity: O(V + E) to scan every adjacency list. Space complexity:
 *   O(V) for the degree counters.
 */
public class DegreeIndegreeOutdegreeDemo {

    public void demonstrate() {
        demonstrateUndirected();
        System.out.println();
        demonstrateDirected();
    }

    private void demonstrateUndirected() {
        System.out.println("Undirected graph degrees:");
        AdjacencyListGraph g = new AdjacencyListGraph(5, false);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.print();
        for (int v = 0; v < g.vertexCount(); v++) {
            System.out.println("  deg(" + v + ") = " + g.neighbours(v).size());
        }
    }

    private void demonstrateDirected() {
        System.out.println("Directed graph in-degree and out-degree:");
        int n = 5;
        AdjacencyListGraph g = new AdjacencyListGraph(n, true);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.print();

        int[] indegree = new int[n];
        for (int u = 0; u < n; u++) {
            for (Edge e : g.neighbours(u)) {
                indegree[e.to]++;
            }
        }
        for (int v = 0; v < n; v++) {
            System.out.println("  vertex " + v + ": out-degree = "
                    + g.neighbours(v).size() + ", in-degree = " + indegree[v]);
        }
    }
}
