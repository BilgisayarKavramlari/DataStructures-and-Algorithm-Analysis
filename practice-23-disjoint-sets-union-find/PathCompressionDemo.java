/**
 * PathCompressionDemo
 *
 * Path compression flattens the tree during find: after locating the root, every
 * node on the path is reattached directly to the root, so future finds on those
 * nodes are nearly O(1). Combined with union by rank, the amortized cost per
 * operation is the inverse Ackermann function, effectively constant.
 *
 * Invariant: find always returns the true root; compression only shortens paths,
 * never changes set membership.
 *
 * Time complexity: amortized near O(1) (inverse Ackermann) with union by rank.
 * Space complexity: O(n).
 */
public class PathCompressionDemo {

    private final int[] parent;

    public PathCompressionDemo(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public PathCompressionDemo() {
        this(7);
    }

    private int findNoCompress(int x) {
        while (parent[x] != x) {
            x = parent[x];
        }
        return x;
    }

    private int findWithCompression(int x) {
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

    public void demonstrate() {
        System.out.println("Path compression flattens the find path toward the root.");
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i - 1;
        }
        System.out.print("  built a chain 6->5->4->3->2->1->0. parent: ");
        printParent();

        int root = findWithCompression(6);
        System.out.println("  find(6) returns root " + root + " and compresses the path.");
        System.out.print("  parent after compression: ");
        printParent();
        System.out.println("  every node on the path now points straight at the root.");
    }

    private void printParent() {
        for (int i = 0; i < parent.length; i++) {
            System.out.print(i + "->" + parent[i] + " ");
        }
        System.out.println();
    }
}
