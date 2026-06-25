import java.util.ArrayList;
import java.util.List;

/**
 * MSTTraceDemo
 *
 * Runs Prim and Kruskal on the same graph and confirms they agree on the total
 * weight, reinforcing the theorem that every correct MST algorithm yields the
 * same minimum total weight (and the same tree when edge weights are distinct).
 *
 * Time complexity: dominated by the two algorithms, O(E log E). Space: O(V + E).
 */
public class MSTTraceDemo {

    public void demonstrate() {
        WeightedGraphForMST g = SampleMSTGraph.build();
        int primWeight = primWeight(g);
        int kruskalWeight = kruskalWeight(g);

        System.out.println("Comparing the two algorithms on one graph:");
        System.out.println("  Prim total weight:    " + primWeight);
        System.out.println("  Kruskal total weight: " + kruskalWeight);
        System.out.println("  agree: " + (primWeight == kruskalWeight));
        System.out.println();
        System.out.println("Both reach the same minimum total weight, as the MST theory predicts.");
    }

    private int primWeight(WeightedGraphForMST g) {
        int n = g.vertexCount();
        boolean[] inTree = new boolean[n];
        int[] best = new int[n];
        java.util.Arrays.fill(best, Integer.MAX_VALUE);
        best[0] = 0;
        int total = 0;
        for (int iter = 0; iter < n; iter++) {
            int u = -1;
            for (int v = 0; v < n; v++) {
                if (!inTree[v] && (u == -1 || best[v] < best[u])) {
                    u = v;
                }
            }
            inTree[u] = true;
            total += best[u];
            for (WeightedGraphForMST.Neighbour nb : g.neighbours(u)) {
                if (!inTree[nb.to] && nb.weight < best[nb.to]) {
                    best[nb.to] = nb.weight;
                }
            }
        }
        return total;
    }

    private int kruskalWeight(WeightedGraphForMST g) {
        List<WeightedGraphForMST.Edge> edges = new ArrayList<>(g.edges());
        edges.sort((a, b) -> Integer.compare(a.weight, b.weight));
        UnionFindForKruskal uf = new UnionFindForKruskal(g.vertexCount());
        int total = 0;
        int chosen = 0;
        for (WeightedGraphForMST.Edge e : edges) {
            if (uf.union(e.u, e.v)) {
                total += e.weight;
                if (++chosen == g.vertexCount() - 1) {
                    break;
                }
            }
        }
        return total;
    }
}
