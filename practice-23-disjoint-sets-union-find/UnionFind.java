/**
 * UnionFind
 *
 * The production-quality disjoint-set structure combining union by rank with
 * path compression, used by the experiment and maze demos. This is the version
 * to reach for in practice (and the one Kruskal's MST relies on).
 *
 * Invariant: each set is a tree whose root is its representative; rank bounds
 * height; compression keeps paths short.
 *
 * Time complexity: amortized inverse-Ackermann (effectively constant) per
 *   operation. Space complexity: O(n).
 */
public class UnionFind {

    private final int[] parent;
    private final int[] rank;
    private int componentCount;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        componentCount = n;
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
        componentCount--;
        return true;
    }

    public boolean connected(int a, int b) {
        return find(a) == find(b);
    }

    public int componentCount() {
        return componentCount;
    }
}
