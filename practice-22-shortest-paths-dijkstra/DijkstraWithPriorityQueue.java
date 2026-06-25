import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * DijkstraWithPriorityQueue
 *
 * The standard efficient Dijkstra: a binary-heap priority queue (Java's
 * PriorityQueue) always yields the unfinished vertex of least tentative
 * distance in O(log V). Each successful relaxation pushes an updated (distance,
 * vertex) pair; stale pairs are skipped when popped. This is the form used in
 * practice on sparse graphs.
 *
 * Invariant: the first time a vertex is popped, its distance is final; later
 * stale entries for it are ignored.
 *
 * Time complexity: O((V + E) log V) with a binary heap. Space complexity:
 *   O(V + E) for the queue entries.
 */
public class DijkstraWithPriorityQueue {

    private static final int INF = Integer.MAX_VALUE;

    private static class Entry {
        final int vertex;
        final int dist;

        Entry(int vertex, int dist) {
            this.vertex = vertex;
            this.dist = dist;
        }
    }

    public void demonstrate() {
        WeightedGraphForShortestPath g = SampleGraph.build();
        int n = g.vertexCount();
        int source = 0;

        int[] dist = new int[n];
        boolean[] done = new boolean[n];
        Arrays.fill(dist, INF);
        dist[source] = 0;

        PriorityQueue<Entry> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));
        pq.add(new Entry(source, 0));

        System.out.println("Dijkstra with a binary-heap priority queue, source " + source + ":");

        while (!pq.isEmpty()) {
            Entry top = pq.poll();
            int u = top.vertex;
            if (done[u]) {
                System.out.println("  skip stale entry for " + u + " (dist " + top.dist + ")");
                continue;
            }
            done[u] = true;
            System.out.println("  pop and finalize " + u + " with distance " + dist[u]);
            for (WeightedGraphForShortestPath.Arc arc : g.neighbours(u)) {
                int candidate = dist[u] + arc.weight;
                if (candidate < dist[arc.to]) {
                    dist[arc.to] = candidate;
                    pq.add(new Entry(arc.to, candidate));
                    System.out.println("    relax " + u + " -> " + arc.to
                            + ", push (dist " + candidate + ")");
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
