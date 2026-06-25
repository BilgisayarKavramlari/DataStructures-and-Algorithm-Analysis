/**
 * TopologicalSortIndegreeScan
 *
 * Produces a topological ordering of a directed acyclic graph by repeatedly
 * selecting a vertex whose in-degree has dropped to zero, without using a
 * queue. This is the simplest form of Kahn's idea: scan for an available
 * vertex each round.
 *
 * Invariant: a vertex is emitted only after all its predecessors are emitted.
 *
 * Time complexity: O(V^2) because each round rescans for a zero in-degree
 *   vertex; the queue-based version improves this to O(V + E).
 * Space complexity: O(V) for the in-degree and emitted arrays.
 */
public class TopologicalSortIndegreeScan {

    public void demonstrate() {
        int n = 6;
        Graph g = new Graph(n, true);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        int[] indegree = new int[n];
        for (int u = 0; u < n; u++) {
            for (int v : g.neighbours(u)) {
                indegree[v]++;
            }
        }

        System.out.println("Topological sort by repeated zero-in-degree scan:");
        boolean[] emitted = new boolean[n];
        StringBuilder order = new StringBuilder();

        for (int round = 0; round < n; round++) {
            int chosen = -1;
            for (int v = 0; v < n; v++) {
                if (!emitted[v] && indegree[v] == 0) {
                    chosen = v;
                    break;
                }
            }
            if (chosen == -1) {
                System.out.println("  no zero-in-degree vertex left: graph has a cycle");
                return;
            }
            emitted[chosen] = true;
            order.append(chosen).append(" ");
            System.out.println("  emit " + chosen + ", then decrement its successors");
            for (int v : g.neighbours(chosen)) {
                indegree[v]--;
            }
        }
        System.out.println("  topological order: " + order.toString().trim());
    }
}
