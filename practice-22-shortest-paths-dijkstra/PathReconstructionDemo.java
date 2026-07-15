import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * PathReconstructionDemo
 *
 * Distances alone do not tell you the route. By recording a predecessor for
 * each vertex during relaxation, the actual shortest path can be rebuilt by
 * walking predecessors backward from the destination to the source and
 * reversing.
 *
 * Invariant: prev[v] holds the vertex immediately before v on the shortest known
 * known path to v.
 *
 * Time complexity: O((V + E) log V) for the search plus O(path length) to
 *   rebuild. Space complexity: O(V).
 */
public class PathReconstructionDemo {

    private static final int INF = Integer.MAX_VALUE;

    public void demonstrate() {
        WeightedGraphForShortestPath g = SampleGraph.build();
        int n = g.vertexCount();
        int source = 0;
        int target = 4;

        int[] dist = new int[n];
        int[] prev = new int[n];
        boolean[] done = new boolean[n];
        Arrays.fill(dist, INF);
        Arrays.fill(prev, -1);
        dist[source] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[] { source, 0 });

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int u = top[0];
            if (done[u]) {
                continue;
            }
            done[u] = true;
            for (WeightedGraphForShortestPath.Arc arc : g.neighbours(u)) {
                if (dist[u] + arc.weight < dist[arc.to]) {
                    dist[arc.to] = dist[u] + arc.weight;
                    prev[arc.to] = u;
                    pq.add(new int[] { arc.to, dist[arc.to] });
                }
            }
        }

        System.out.println("Shortest path from " + source + " to " + target + ":");
        System.out.println("  total distance: " + dist[target]);

        List<Integer> path = new ArrayList<>();
        for (int at = target; at != -1; at = prev[at]) {
            path.add(at);
        }
        Collections.reverse(path);
        System.out.println("  route (via predecessors): " + path);
    }
}
