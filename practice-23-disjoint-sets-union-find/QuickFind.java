/**
 * QuickFind
 *
 * The simplest disjoint-set structure: an array id[] where id[x] is the set
 * label of element x. Two elements are connected exactly when their labels are
 * equal, so find is O(1). Union, however, must relabel every member of one set,
 * costing O(n).
 *
 * Invariant: all elements of the same set share one id value.
 *
 * Time complexity: find O(1); union O(n). Space complexity: O(n).
 */
public class QuickFind {

    private final int[] id;

    public QuickFind(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public int find(int x) {
        return id[x];
    }

    public boolean connected(int a, int b) {
        return id[a] == id[b];
    }

    public void union(int a, int b) {
        int labelA = id[a];
        int labelB = id[b];
        if (labelA == labelB) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (id[i] == labelA) {
                id[i] = labelB;
            }
        }
    }

    public void demonstrate() {
        System.out.println("Quick-find: find is O(1), union relabels a whole set (O(n)).");
        QuickFind qf = new QuickFind(6);
        qf.union(0, 1);
        qf.union(2, 3);
        qf.union(1, 3);
        System.out.println("  after union(0,1), union(2,3), union(1,3):");
        System.out.print("  labels: ");
        for (int i = 0; i < 6; i++) {
            System.out.print(i + "->" + qf.find(i) + " ");
        }
        System.out.println();
        System.out.println("  connected(0,3)? " + qf.connected(0, 3));
        System.out.println("  connected(0,5)? " + qf.connected(0, 5));
    }
}
