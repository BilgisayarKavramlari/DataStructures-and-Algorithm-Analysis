import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * PrimMST
 *
 * Prim's algorithm grows one tree from a start vertex, repeatedly adding the
 * cheapest edge that connects a new vertex to the tree. A priority queue keyed
 * by edge weight supplies the next cheapest crossing edge in O(log V).
 *
 * Invariant: the chosen edges always form a single connected tree; the cheapest
 * edge leaving that tree is safe to add (the cut property).
 *
 * Time complexity: O((V + E) log V) with a binary heap. Space complexity:
 *   O(V + E).
 */
public class PrimMST {

    private static final int INF = Integer.MAX_VALUE;

    public void demonstrate() {
        WeightedGraphForMST g = SampleMSTGraph.build();
        int n = g.vertexCount();
        boolean[] inTree = new boolean[n];
        int[] bestEdge = new int[n];
        int[] parent = new int[n];
        Arrays.fill(bestEdge, INF);
        Arrays.fill(parent, -1);
        bestEdge[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[] { 0, 0 });

        System.out.println("Prim's algorithm growing the tree from vertex 0:");
        int totalWeight = 0;

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int u = top[0];
            if (inTree[u]) {
                continue;
            }
            inTree[u] = true;
            if (parent[u] != -1) {
                totalWeight += bestEdge[u];
                System.out.println("  add edge " + parent[u] + "-" + u
                        + " (weight " + bestEdge[u] + ")");
            }
            for (WeightedGraphForMST.Neighbour nb : g.neighbours(u)) {
                if (!inTree[nb.to] && nb.weight < bestEdge[nb.to]) {
                    bestEdge[nb.to] = nb.weight;
                    parent[nb.to] = u;
                    pq.add(new int[] { nb.to, nb.weight });
                }
            }
        }

        System.out.println("  total MST weight: " + totalWeight);
    }
}
