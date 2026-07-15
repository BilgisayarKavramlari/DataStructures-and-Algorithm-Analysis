/**
 * QuickUnion
 *
 * Represents each set as a tree stored in a parent[] array; the root is the set
 * representative. Union links one root under another in O(1) plus the cost of
 * finding the roots. Without balancing the trees can grow tall, making find
 * O(n) in the worst case.
 *
 * Invariant: following parent links from any element eventually reaches its set
 * root (a self-parent).
 *
 * Time complexity: find O(tree height); union O(height). Space complexity: O(n).
 */
public class QuickUnion {

    private final int[] parent;

    public QuickUnion(int n) {
        parent = new int[n];
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
        if (rootA != rootB) {
            parent[rootA] = rootB;
        }
    }

    public void demonstrate() {
        System.out.println("Quick-union: sets are trees; union links roots in O(1) after find.");
        QuickUnion qu = new QuickUnion(6);
        qu.union(0, 1);
        qu.union(1, 2);
        qu.union(3, 4);
        qu.union(2, 4);
        System.out.print("  parent array: ");
        for (int i = 0; i < 6; i++) {
            System.out.print(i + "->" + qu.parent[i] + " ");
        }
        System.out.println();
        System.out.println("  find(0) root = " + qu.find(0));
        System.out.println("  find(3) root = " + qu.find(3));
        System.out.println("  without balancing, repeated unions can build a tall chain.");
    }
}
