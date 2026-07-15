import java.util.ArrayDeque;
import java.util.Queue;

/**
 * UnweightedShortestPathBFS
 *
 * On an unweighted graph the fewest-edge path is found by breadth-first search,
 * because BFS visits vertices in nondecreasing distance order. This demo
 * establishes the baseline that Dijkstra later generalises to weighted edges.
 *
 * Invariant: a vertex's distance is set exactly once, when it is first reached.
 *
 * Time complexity: O(V + E). Space complexity: O(V).
 */
public class UnweightedShortestPathBFS {

    public void demonstrate() {
        int n = 6;
        java.util.List<java.util.List<Integer>> adj = new java.util.ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new java.util.ArrayList<>());
        }
        addUndirected(adj, 0, 1);
        addUndirected(adj, 0, 2);
        addUndirected(adj, 1, 3);
        addUndirected(adj, 2, 3);
        addUndirected(adj, 3, 4);
        addUndirected(adj, 4, 5);

        int source = 0;
        int[] distance = new int[n];
        java.util.Arrays.fill(distance, -1);
        Queue<Integer> queue = new ArrayDeque<>();
        distance[source] = 0;
        queue.add(source);

        System.out.println("Unweighted shortest paths from " + source + " via BFS:");
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int next : adj.get(v)) {
                if (distance[next] == -1) {
                    distance[next] = distance[v] + 1;
                    queue.add(next);
                }
            }
        }
        for (int v = 0; v < n; v++) {
            System.out.println("  dist(" + source + " -> " + v + ") = " + distance[v] + " edges");
        }
    }

    private void addUndirected(java.util.List<java.util.List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
