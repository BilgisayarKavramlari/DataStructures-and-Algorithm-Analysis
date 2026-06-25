import java.util.ArrayList;
import java.util.List;

/**
 * DisconnectedGraphMSTDemo
 *
 * A minimum spanning tree exists only for a connected graph. On a disconnected
 * graph the analogous result is a minimum spanning FOREST: one MST per connected
 * component. Kruskal naturally produces this, ending with fewer than V-1 edges.
 *
 * Time complexity: O(E log E). Space complexity: O(V + E).
 */
public class DisconnectedGraphMSTDemo {

    public void demonstrate() {
        int n = 6;
        WeightedGraphForMST g = new WeightedGraphForMST(n);
        g.addEdge(0, 1, 2);
        g.addEdge(1, 2, 3);
        g.addEdge(3, 4, 1);
        g.addEdge(4, 5, 4);

        System.out.println("Graph with two components: {0,1,2} and {3,4,5}.");
        List<WeightedGraphForMST.Edge> edges = new ArrayList<>(g.edges());
        edges.sort((a, b) -> Integer.compare(a.weight, b.weight));
        UnionFindForKruskal uf = new UnionFindForKruskal(n);

        int totalWeight = 0;
        int chosen = 0;
        for (WeightedGraphForMST.Edge e : edges) {
            if (uf.union(e.u, e.v)) {
                totalWeight += e.weight;
                chosen++;
                System.out.println("  take " + e);
            }
        }

        int components = 0;
        boolean[] seenRoot = new boolean[n];
        for (int v = 0; v < n; v++) {
            int r = uf.find(v);
            if (!seenRoot[r]) {
                seenRoot[r] = true;
                components++;
            }
        }

        System.out.println("  edges chosen: " + chosen + " (less than V-1 = " + (n - 1) + ")");
        System.out.println("  spanning forest has " + components + " trees, one per component.");
        System.out.println("  total forest weight: " + totalWeight);
    }
}
