/**
 * UnionFindForKruskal
 *
 * The disjoint-set structure Kruskal's algorithm uses to test, in nearly
 * constant time, whether adding an edge would create a cycle. Two endpoints in
 * the same set mean a cycle, so the edge is skipped. Uses union by rank and path
 * compression.
 *
 * Invariant: vertices in one set are already connected by chosen tree edges.
 *
 * Time complexity: amortized inverse-Ackermann per operation. Space: O(V).
 */
public class UnionFindForKruskal {

    private final int[] parent;
    private final int[] rank;

    public UnionFindForKruskal(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        int root = x;
        while (parent[root] != root) {
            root = parent[root];
        }
        while (parent[x] != root) {
            int next = parent[x];
            parent[x] = root;
            x = next;
        }
        return root;
    }

    public boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) {
            return false;
        }
        if (rank[rootA] < rank[rootB]) {
            int temp = rootA;
            rootA = rootB;
            rootB = temp;
        }
        parent[rootB] = rootA;
        if (rank[rootA] == rank[rootB]) {
            rank[rootA]++;
        }
        return true;
    }
}
