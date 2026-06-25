/**
 * UnionByRank
 *
 * An alternative balancing rule to union-by-size: attach the tree of smaller
 * rank (an upper bound on height) under the larger. When ranks are equal, the
 * surviving root's rank increases by one. Like union-by-size this guarantees
 * O(log n) trees.
 *
 * Invariant: rank[root] is an upper bound on the height of that root's tree.
 *
 * Time complexity: find and union O(log n) (near O(1) once combined with path
 *   compression). Space complexity: O(n).
 */
public class UnionByRank {

    private final int[] parent;
    private final int[] rank;

    public UnionByRank(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        while (parent[x] != x) {
            x = parent[x];
        }
        return x;
    }

    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) {
            return;
        }
        if (rank[rootA] < rank[rootB]) {
            parent[rootA] = rootB;
        } else if (rank[rootA] > rank[rootB]) {
            parent[rootB] = rootA;
        } else {
            parent[rootB] = rootA;
            rank[rootA]++;
        }
    }

    public void demonstrate() {
        System.out.println("Union by rank: lower-rank tree hangs under higher; ties bump rank.");
        UnionByRank uf = new UnionByRank(7);
        uf.union(0, 1);
        uf.union(2, 3);
        uf.union(0, 2);
        uf.union(4, 5);
        uf.union(6, 4);
        uf.union(0, 4);
        System.out.print("  parent: ");
        for (int i = 0; i < 7; i++) {
            System.out.print(i + "->" + uf.parent[i] + " ");
        }
        System.out.println();
        System.out.print("  rank:   ");
        for (int i = 0; i < 7; i++) {
            System.out.print(i + ":" + uf.rank[i] + " ");
        }
        System.out.println();
        System.out.println("  root of 5 = " + uf.find(5));
    }
}
