import java.util.Arrays;

/**
 * DijkstraWithoutPriorityQueue
 *
 * Dijkstra's algorithm in its simplest form: at each step linearly scan all
 * vertices for the unfinished one with the smallest tentative distance, finalize
 * it, and relax its outgoing edges. Relaxation means: if going through u reaches
 * v more cheaply, lower v's distance.
 *
 * Invariant: once a vertex is marked done, its recorded distance is the true
 * shortest distance from the source (valid because all weights are non-negative).
 *
 * Time complexity: O(V^2) due to the linear minimum scan, which is actually
 *   preferable for dense graphs. Space complexity: O(V).
 */
public class DijkstraWithoutPriorityQueue {

    private static final int INF = Integer.MAX_VALUE;

    public void demonstrate() {
        WeightedGraphForShortestPath g = SampleGraph.build();
        int n = g.vertexCount();
        int source = 0;

        int[] dist = new int[n];
        boolean[] done = new boolean[n];
        Arrays.fill(dist, INF);
        dist[source] = 0;

        System.out.println("Dijkstra with a linear-scan minimum (no priority queue), source "
                + source + ":");

        for (int iteration = 0; iteration < n; iteration++) {
            int u = -1;
            int best = INF;
            for (int v = 0; v < n; v++) {
                if (!done[v] && dist[v] < best) {
                    best = dist[v];
                    u = v;
                }
            }
            if (u == -1) {
                break;
            }
            done[u] = true;
            System.out.println("  finalize " + u + " with distance " + dist[u]);
            for (WeightedGraphForShortestPath.Arc arc : g.neighbours(u)) {
                if (dist[u] + arc.weight < dist[arc.to]) {
                    dist[arc.to] = dist[u] + arc.weight;
                    System.out.println("    relax " + u + " -> " + arc.to
                            + " sets dist[" + arc.to + "] = " + dist[arc.to]);
                }
            }
        }

        System.out.print("  final distances: ");
        for (int v = 0; v < n; v++) {
            System.out.print(v + ":" + dist[v] + " ");
        }
        System.out.println();
    }
}
