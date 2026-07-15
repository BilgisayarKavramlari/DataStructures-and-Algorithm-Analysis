/**
 * SampleMSTGraph
 *
 * Builds the shared weighted graph used by the Prim and Kruskal demos so both
 * algorithms can be shown producing the same minimum spanning tree.
 *
 * Graph (vertices 0..5), weights chosen to make the MST unique:
 *   0-1(4) 0-2(3) 1-2(1) 1-3(2) 2-3(4) 3-4(2) 4-5(6) 3-5(8)
 *
 * Time complexity: O(1). Space complexity: O(V + E).
 */
public final class SampleMSTGraph {

    private SampleMSTGraph() {
    }

    public static WeightedGraphForMST build() {
        WeightedGraphForMST g = new WeightedGraphForMST(6);
        g.addEdge(0, 1, 4);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 2, 1);
        g.addEdge(1, 3, 2);
        g.addEdge(2, 3, 4);
        g.addEdge(3, 4, 2);
        g.addEdge(4, 5, 6);
        g.addEdge(3, 5, 8);
        return g;
    }
}
