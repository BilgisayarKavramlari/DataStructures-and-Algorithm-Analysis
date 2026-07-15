/**
 * Edge
 *
 * Represents a single edge to a destination vertex, optionally weighted. It is
 * the element stored in adjacency lists and edge lists throughout this folder.
 *
 * Invariant: 'to' is a valid vertex id; 'weight' is meaningful only for
 * weighted graphs and defaults to 1 for unweighted use.
 *
 * Space complexity: O(1) per edge object.
 */
public class Edge {

    public final int to;
    public final int weight;

    public Edge(int to) {
        this(to, 1);
    }

    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return weight == 1 ? String.valueOf(to) : (to + "(w=" + weight + ")");
    }
}
