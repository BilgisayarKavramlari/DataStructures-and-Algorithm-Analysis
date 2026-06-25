import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * DAGShortestPathDemo
 *
 * On a directed acyclic graph, shortest paths can be found faster than Dijkstra:
 * relax edges in topological order. Because every predecessor of a vertex is
 * finalized before the vertex itself, a single pass suffices and negative edge
 * weights are allowed (there can be no negative cycle in a DAG).
 *
 * Invariant: when a vertex is processed in topological order, its distance is
 * already final.
 *
 * Time complexity: O(V + E). Space complexity: O(V).
 */
public class DAGShortestPathDemo {

    private static final int INF = Integer.MAX_VALUE;

    public void demonstrate() {
        int n = 6;
        WeightedGraphForShortestPath g = new WeightedGraphForShortestPath(n);
        g.addArc(0, 1, 5);
        g.addArc(0, 2, 3);
        g.addArc(1, 3, 6);
        g.addArc(2, 3, 7);
        g.addArc(2, 4, 4);
        g.addArc(4, 5, -2);
        g.addArc(3, 5, 1);

        int[] indegree = new int[n];
        for (int u = 0; u < n; u++) {
            for (WeightedGraphForShortestPath.Arc arc : g.neighbours(u)) {
                indegree[arc.to]++;
            }
        }
        Queue<Integer> ready = new ArrayDeque<>();
        for (int v = 0; v < n; v++) {
            if (indegree[v] == 0) {
                ready.add(v);
            }
        }
        int[] order = new int[n];
        int idx = 0;
        while (!ready.isEmpty()) {
            int v = ready.poll();
            order[idx++] = v;
            for (WeightedGraphForShortestPath.Arc arc : g.neighbours(v)) {
                if (--indegree[arc.to] == 0) {
                    ready.add(arc.to);
                }
            }
        }

        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[0] = 0;

        System.out.println("DAG shortest paths by relaxing edges in topological order:");
        System.out.println("  topological order: " + Arrays.toString(order));
        for (int i = 0; i < n; i++) {
            int u = order[i];
            if (dist[u] == INF) {
                continue;
            }
            for (WeightedGraphForShortestPath.Arc arc : g.neighbours(u)) {
                if (dist[u] + arc.weight < dist[arc.to]) {
                    dist[arc.to] = dist[u] + arc.weight;
                }
            }
        }

        System.out.print("  distances from 0: ");
        for (int v = 0; v < n; v++) {
            System.out.print(v + ":" + (dist[v] == INF ? "INF" : dist[v]) + " ");
        }
        System.out.println();
        System.out.println("  note the negative edge 4->5 is handled correctly on a DAG.");
    }
}
