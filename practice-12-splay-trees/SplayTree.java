import java.util.ArrayList;
import java.util.List;

/**
 * Educational bottom-up splay tree for integer keys.
 *
 * Splay rule: after accessing a node, rotate it to the root using zig, zig-zig,
 * or zig-zag steps. Individual operations can be O(n), but the amortized cost
 * over a sequence is O(log n).
 */
public class SplayTree {
    static class Node {
        int key;
        Node left, right, parent;
        Node(int key) { this.key = key; }
    }

    private Node root;
    private boolean trace;
    private int rotations;

    public SplayTree(boolean trace) { this.trace = trace; }
    public SplayTree() { this(false); }

    public void insert(int key) {
        if (root == null) { root = new Node(key); return; }
        Node current = root;
        Node parent = null;
        while (current != null) {
            parent = current;
            if (key < current.key) current = current.left;
            else if (key > current.key) current = current.right;
            else { splay(current); return; }
        }
        Node node = new Node(key);
        node.parent = parent;
        if (key < parent.key) parent.left = node; else parent.right = node;
        splay(node);
        
    }

    public boolean access(int key) {
        Node current = root;
        Node last = null;
        while (current != null) {
            last = current;
            if (key == current.key) { splay(current); return true; }
            current = key < current.key ? current.left : current.right;
        }
        if (last != null) splay(last); // unsuccessful search splays the last visited node
        return false;
    }

    private void splay(Node x) {
        while (x.parent != null) {
            Node p = x.parent;
            Node g = p.parent;
            if (g == null) {
                if (trace) System.out.println("zig at " + x.key);
                if (x == p.left) rotateRight(p); else rotateLeft(p);
            } else if (x == p.left && p == g.left) {
                if (trace) System.out.println("zig-zig left-left at " + x.key);
                rotateRight(g);
                rotateRight(p);
            } else if (x == p.right && p == g.right) {
                if (trace) System.out.println("zig-zig right-right at " + x.key);
                rotateLeft(g);
                rotateLeft(p);
            } else if (x == p.right && p == g.left) {
                if (trace) System.out.println("zig-zag left-right at " + x.key);
                rotateLeft(p);
                rotateRight(g);
            } else {
                if (trace) System.out.println("zig-zag right-left at " + x.key);
                rotateRight(p);
                rotateLeft(g);
            }
        }
        printTree(x," ", " ");
    }

    private void rotateLeft(Node x) {
        Node y = x.right;
        if (y == null) return;
        x.right = y.left;
        if (y.left != null) y.left.parent = x;
        y.parent = x.parent;
        replaceParentChild(x, y);
        y.left = x;
        x.parent = y;
        rotations++;
    }

    private void rotateRight(Node x) {
        Node y = x.left;
        if (y == null) return;
        x.left = y.right;
        if (y.right != null) y.right.parent = x;
        y.parent = x.parent;
        replaceParentChild(x, y);
        y.right = x;
        x.parent = y;
        rotations++;
    }

    private void replaceParentChild(Node oldChild, Node newChild) {
        if (oldChild.parent == null) root = newChild;
        else if (oldChild == oldChild.parent.left) oldChild.parent.left = newChild;
        else oldChild.parent.right = newChild;
    }

    public int rootKey() { return root == null ? Integer.MIN_VALUE : root.key; }
    public int rotationCount() { return rotations; }
    public void resetRotationCount() { rotations = 0; }

    public List<Integer> inorder() { List<Integer> out = new ArrayList<>(); inorder(root, out); return out; }
    private void inorder(Node n, List<Integer> out) { if (n != null) { inorder(n.left, out); out.add(n.key); inorder(n.right, out); } }

    public void printTree() { printTree(root, "", "root"); }
    private void printTree(Node n, String indent, String label) {
        if (n == null) { System.out.println(indent + label + ": null"); return; }
        System.out.println(indent + label + ": " + n.key);
        printTree(n.left, indent + "  ", "L");
        printTree(n.right, indent + "  ", "R");
    }
}
