/**
 * PathHalvingDemo
 *
 * Path halving is a one-pass alternative to full path compression: during find,
 * make every node point to its grandparent. This halves the path length in a
 * single traversal without the second pass, and achieves the same near-constant
 * amortized complexity in practice.
 *
 * Invariant: find returns the true root; halving only shortens paths.
 *
 * Time complexity: amortized near O(1) with a balancing rule. Space complexity:
 *   O(n).
 */
public class PathHalvingDemo {

    private final int[] parent;

    public PathHalvingDemo(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public PathHalvingDemo() {
        this(8);
    }

    private int findWithHalving(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public void demonstrate() {
        System.out.println("Path halving points each node to its grandparent during find.");
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i - 1;
        }
        System.out.print("  chain 7->6->...->0. parent: ");
        printParent();

        int root = findWithHalving(7);
        System.out.println("  find(7) with halving returns root " + root + ".");
        System.out.print("  parent after one halving pass: ");
        printParent();
        System.out.println("  the path length is roughly halved in a single traversal.");
    }

    private void printParent() {
        for (int i = 0; i < parent.length; i++) {
            System.out.print(i + "->" + parent[i] + " ");
        }
        System.out.println();
    }
}
