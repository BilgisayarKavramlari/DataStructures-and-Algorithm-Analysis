import java.util.ArrayList;
import java.util.List;

/**
 * KruskalMST
 *
 * Kruskal's algorithm sorts all edges by weight and adds each edge that does not
 * form a cycle, using union-find to test connectivity. It grows a forest that
 * merges into a single tree once V-1 edges are chosen.
 *
 * Invariant: chosen edges never form a cycle; the cheapest cycle-free edge is
 * always safe (the cut property applied to forests).
 *
 * Time complexity: O(E log E) dominated by the sort. Space complexity: O(V + E).
 */
public class KruskalMST {

    public void demonstrate() {
        WeightedGraphForMST g = SampleMSTGraph.build();
        int n = g.vertexCount();

        List<WeightedGraphForMST.Edge> edges = new ArrayList<>(g.edges());
        edges.sort((a, b) -> Integer.compare(a.weight, b.weight));

        UnionFindForKruskal uf = new UnionFindForKruskal(n);
        System.out.println("Kruskal's algorithm scanning edges in nondecreasing weight:");
        int totalWeight = 0;
        int chosen = 0;

        for (WeightedGraphForMST.Edge e : edges) {
            if (chosen == n - 1) {
                break;
            }
            if (uf.union(e.u, e.v)) {
                totalWeight += e.weight;
                chosen++;
                System.out.println("  take " + e + " (joins two components)");
            } else {
                System.out.println("  skip " + e + " (would form a cycle)");
            }
        }

        System.out.println("  total MST weight: " + totalWeight);
    }
}
