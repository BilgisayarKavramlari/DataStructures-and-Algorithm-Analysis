/**
 * SkewHeapEducational
 *
 * A skew heap is a self-adjusting leftist heap with no npl bookkeeping. After
 * merging along the right spine it unconditionally swaps the children of every
 * node it touched. This simple rule gives O(log n) amortized operations.
 *
 * Invariant: heap order holds; balance is maintained only in an amortized sense.
 *
 * Time complexity: O(log n) amortized for merge, insert, and deleteMin.
 */
public class SkewHeapEducational {

    static class Node {
        int key;
        Node left;
        Node right;

        Node(int key) {
            this.key = key;
        }
    }

    private Node root;

    private Node merge(Node a, Node b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        if (a.key > b.key) {
            Node t = a;
            a = b;
            b = t;
        }
        a.right = merge(a.right, b);
        // Unconditional child swap: the skew heap's only balancing rule.
        Node tmp = a.left;
        a.left = a.right;
        a.right = tmp;
        return a;
    }

    public void insert(int key) {
        root = merge(root, new Node(key));
    }

    public int deleteMin() {
        int min = root.key;
        root = merge(root.left, root.right);
        return min;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void demonstrate() {
        SkewHeapEducational heap = new SkewHeapEducational();
        int[] data = {18, 6, 24, 3, 15, 9, 27, 1};
        for (int x : data) {
            heap.insert(x);
        }
        System.out.println("Inserted: " + java.util.Arrays.toString(data));
        StringBuilder sb = new StringBuilder();
        while (!heap.isEmpty()) {
            sb.append(heap.deleteMin()).append(" ");
        }
        System.out.println("Extraction order: " + sb.toString().trim());
        System.out.println("No height fields are stored; the swap rule keeps it balanced on average.");
    }
}
