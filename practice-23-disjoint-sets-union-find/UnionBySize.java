/**
 * UnionBySize
 *
 * Improves quick-union by always attaching the smaller tree under the larger
 * one's root, tracked via a size[] array. This keeps trees shallow: heights stay
 * O(log n), so find and union both become O(log n).
 *
 * Invariant: size[root] holds the number of elements in that root's tree.
 *
 * Time complexity: find and union O(log n). Space complexity: O(n).
 */
public class UnionBySize {

    private final int[] parent;
    private final int[] size;

    public UnionBySize(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
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
        if (size[rootA] < size[rootB]) {
            int temp = rootA;
            rootA = rootB;
            rootB = temp;
        }
        parent[rootB] = rootA;
        size[rootA] += size[rootB];
    }

    public void demonstrate() {
        System.out.println("Union by size: smaller tree hangs under larger, keeping height O(log n).");
        UnionBySize uf = new UnionBySize(7);
        uf.union(0, 1);
        uf.union(2, 3);
        uf.union(0, 2);
        uf.union(4, 5);
        uf.union(0, 4);
        System.out.print("  parent: ");
        for (int i = 0; i < 7; i++) {
            System.out.print(i + "->" + uf.parent[i] + " ");
        }
        System.out.println();
        System.out.println("  root of 5 = " + uf.find(5) + ", size of that set = " + uf.size[uf.find(5)]);
    }
}
