/**
 * LeftistHeapEducational
 *
 * A leftist heap is a mergeable min-heap. Each node stores a null-path length
 * (npl), and the leftist property keeps every left subtree at least as "tall"
 * (by npl) as its right subtree. This forces the right spine to be short
 * (O(log n)), and all operations are built on an O(log n) merge.
 *
 * Invariant: heap order holds, and for every node npl(left) >= npl(right).
 *
 * Time complexity: merge, insert, deleteMin are all O(log n).
 */
public class LeftistHeapEducational {

    static class Node {
        int key;
        int npl;        // null path length
        Node left;
        Node right;

        Node(int key) {
            this.key = key;
        }
    }

    private Node root;

    private int npl(Node n) {
        return n == null ? -1 : n.npl;
    }

    /** Merges two leftist heaps and returns the combined root. */
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
            b = t;                       // a holds the smaller root
        }
        a.right = merge(a.right, b);     // recursively merge into the right spine
        if (npl(a.left) < npl(a.right)) {
            Node t = a.left;             // restore leftist property
            a.left = a.right;
            a.right = t;
        }
        a.npl = npl(a.right) + 1;
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
        LeftistHeapEducational h1 = new LeftistHeapEducational();
        for (int x : new int[]{3, 10, 8, 21, 14}) {
            h1.insert(x);
        }
        LeftistHeapEducational h2 = new LeftistHeapEducational();
        for (int x : new int[]{2, 7, 17, 26}) {
            h2.insert(x);
        }
        System.out.println("Two leftist heaps were built separately, then merged in O(log n).");
        h1.root = h1.merge(h1.root, h2.root);

        StringBuilder sb = new StringBuilder();
        while (!h1.isEmpty()) {
            sb.append(h1.deleteMin()).append(" ");
        }
        System.out.println("Merged extraction order: " + sb.toString().trim());
        System.out.println("Fast merge is the feature a binary heap lacks.");
    }
}
