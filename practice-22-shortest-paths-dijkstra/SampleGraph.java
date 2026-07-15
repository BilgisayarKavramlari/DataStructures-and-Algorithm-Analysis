/**
 * SampleGraph
 *
 * Builds the single weighted directed graph reused across the Dijkstra demos so
 * that the different implementations can be compared on identical input.
 *
 * Graph (vertices 0..4):
 *   0->1 (4), 0->2 (1), 2->1 (2), 1->3 (1), 2->3 (5), 3->4 (3)
 *
 * Time complexity: O(1). Space complexity: O(V + E).
 */
public final class SampleGraph {

    private SampleGraph() {
    }

    public static WeightedGraphForShortestPath build() {
        WeightedGraphForShortestPath g = new WeightedGraphForShortestPath(5);
        g.addArc(0, 1, 4);
        g.addArc(0, 2, 1);
        g.addArc(2, 1, 2);
        g.addArc(1, 3, 1);
        g.addArc(2, 3, 5);
        g.addArc(3, 4, 3);
        return g;
    }
}
