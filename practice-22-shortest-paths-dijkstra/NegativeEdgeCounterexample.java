/**
 * NegativeEdgeCounterexample
 *
 * Demonstrates why Dijkstra requires non-negative edge weights. Dijkstra
 * finalizes a vertex the moment it is popped, assuming no later path can be
 * cheaper. A negative edge can violate this, producing a wrong answer. The demo
 * walks a tiny graph where Dijkstra commits to a vertex too early.
 *
 * Time complexity: O(1) for the worked example. Space complexity: O(1).
 *
 * Teaching note: graphs with negative edges (but no negative cycle) call for
 * Bellman-Ford, which relaxes all edges V-1 times instead of finalizing greedily.
 */
public class NegativeEdgeCounterexample {

    public void demonstrate() {
        System.out.println("Graph: 0->1 (weight 2), 0->2 (weight 5), 2->1 (weight -4)");
        System.out.println();
        System.out.println("True shortest 0 -> 1: take 0->2->1 = 5 + (-4) = 1.");
        System.out.println();
        System.out.println("Dijkstra's mistake:");
        System.out.println("  pops vertex 0 (dist 0), relaxes: dist[1]=2, dist[2]=5");
        System.out.println("  pops vertex 1 next (dist 2 is smallest) and FINALIZES it");
        System.out.println("  later edge 2->1 with weight -4 could give dist[1]=1,");
        System.out.println("  but vertex 1 is already locked, so the improvement is missed");
        System.out.println();
        System.out.println("Result: Dijkstra reports dist[1]=2, but the correct answer is 1.");
        System.out.println("Negative edges break the greedy finalize-once invariant; use Bellman-Ford.");
    }
}
