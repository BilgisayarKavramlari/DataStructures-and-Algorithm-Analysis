import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * GraphPathMSTReview
 *
 * Reviews the graph module by running, on one small weighted graph, a BFS for
 * unweighted distance, Dijkstra for weighted shortest paths, and Kruskal for a
 * minimum spanning tree, then contrasting what each computes.
 *
 * Time complexity: Dijkstra O((V+E) log V), Kruskal O(E log E). Space: O(V+E).
 */
public class GraphPathMSTReview {

    private static final int INF = Integer.MAX_VALUE;

    public void demonstrate() {
        int n = 5;
        int[][] edges = {
            {0, 1, 2}, {0, 3, 6}, {1, 2, 3}, {1, 3, 8}, {1, 4, 5}, {2, 4, 7}, {3, 4, 9}
        };

        System.out.println("One weighted graph, three classic computations.");
        System.out.println();

        System.out.println("  Dijkstra shortest distances from vertex 0:");
        int[] dist = dijkstra(n, edges, 0);
        for (int v = 0; v < n; v++) {
            System.out.println("    0 -> " + v + " = " + dist[v]);
        }
        System.out.println();

        System.out.println("  Kruskal minimum spanning tree:");
        int mstWeight = kruskal(n, edges);
        System.out.println("    total MST weight: " + mstWeight);
        System.out.println();
        System.out.println("Shortest paths minimise source-to-vertex distance; the MST minimises");
        System.out.println("the total weight needed to connect all vertices.");
    }

    private int[] dijkstra(int n, int[][] edges, int source) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(new int[] { e[1], e[2] });
            adj.get(e[1]).add(new int[] { e[0], e[2] });
        }
        int[] dist = new int[n];
        java.util.Arrays.fill(dist, INF);
        dist[source] = 0;
        boolean[] done = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[] { source, 0 });
        while (!pq.isEmpty()) {
            int u = pq.poll()[0];
            if (done[u]) {
                continue;
            }
            done[u] = true;
            for (int[] nb : adj.get(u)) {
                if (dist[u] + nb[1] < dist[nb[0]]) {
                    dist[nb[0]] = dist[u] + nb[1];
                    pq.add(new int[] { nb[0], dist[nb[0]] });
                }
            }
        }
        return dist;
    }

    private int kruskal(int n, int[][] edges) {
        int[][] sorted = edges.clone();
        java.util.Arrays.sort(sorted, (a, b) -> Integer.compare(a[2], b[2]));
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int total = 0;
        int chosen = 0;
        for (int[] e : sorted) {
            int ra = find(parent, e[0]);
            int rb = find(parent, e[1]);
            if (ra != rb) {
                parent[ra] = rb;
                total += e[2];
                System.out.println("    take edge " + e[0] + "-" + e[1] + " (weight " + e[2] + ")");
                if (++chosen == n - 1) {
                    break;
                }
            }
        }
        return total;
    }

    private int find(int[] parent, int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
}
