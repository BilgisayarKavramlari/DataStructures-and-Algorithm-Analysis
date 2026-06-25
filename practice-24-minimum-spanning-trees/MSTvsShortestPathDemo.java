/**
 * MSTvsShortestPathDemo
 *
 * Clarifies a common confusion: a minimum spanning tree is NOT the same as a
 * shortest-path tree. The MST minimizes total edge weight across the whole tree;
 * a shortest-path tree minimizes distance from one source to each vertex. The
 * demo exhibits a graph where the two trees differ.
 *
 * Time complexity: O(1) for the worked example. Space complexity: O(1).
 */
public class MSTvsShortestPathDemo {

    public void demonstrate() {
        System.out.println("Triangle graph: 0-1 (1), 1-2 (1), 0-2 (1.9 rounded to 2).");
        System.out.println("Edges as integers: 0-1(1), 1-2(1), 0-2(2).");
        System.out.println();
        System.out.println("Minimum spanning tree (minimize total weight):");
        System.out.println("  choose 0-1 (1) and 1-2 (1), total weight 2.");
        System.out.println("  edge 0-2 is excluded.");
        System.out.println();
        System.out.println("Shortest-path tree from source 0 (minimize distance to each vertex):");
        System.out.println("  dist(0->1) = 1 via edge 0-1");
        System.out.println("  dist(0->2) = 2, and BOTH 0-2 direct and 0-1-2 give 2.");
        System.out.println();
        System.out.println("If we raise 0-2 to weight 3, the shortest path to 2 becomes 0-1-2 (2),");
        System.out.println("so the two tree objectives can select different edge sets.");
        System.out.println("Lesson: optimize total tree weight (MST) versus per-vertex distance (SPT).");
    }
}
