import java.util.ArrayList;
import java.util.List;

/**
 * Educational AVL tree for integer keys.
 *
 * AVL invariant: for every node, height(left) and height(right) differ by at most 1.
 * This keeps height O(log n), so search/insert/delete are O(log n).
 */
public class AVLTree {
    static class Node {
        int key;
        int height = 0;
        Node left;
        Node right;
        Node(int key) { this.key = key; }
    }

    private Node root;
    private boolean traceRotations;

    public AVLTree() { this(false); }
    public AVLTree(boolean traceRotations) { this.traceRotations = traceRotations; }

    public void insert(int key) { root = insert(root, key); }

    private Node insert(Node node, int key) {
        if (node == null) return new Node(key);
        if (key < node.key) node.left = insert(node.left, key);
        else if (key > node.key) node.right = insert(node.right, key);
        else return node;
        return rebalance(node);
    }

    public void remove(int key) { root = remove(root, key); }

    private Node remove(Node node, int key) {
        if (node == null) return null;
        if (key < node.key) node.left = remove(node.left, key);
        else if (key > node.key) node.right = remove(node.right, key);
        else {
            if (node.left == null || node.right == null) {
                node = (node.left != null) ? node.left : node.right;
            } else {
                Node successor = min(node.right);
                node.key = successor.key;
                node.right = remove(node.right, successor.key);
            }
        }
        return node == null ? null : rebalance(node);
    }

    private Node min(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    private Node rebalance(Node node) {
        updateHeight(node);
        int balance = balanceFactor(node);
        if (balance > 1) {
            if (balanceFactor(node.left) < 0) {
                if (traceRotations) System.out.println("LR case at " + node.key + ": rotate left child left, then node right");
                node.left = rotateLeft(node.left);
            } else if (traceRotations) {
                System.out.println("LL case at " + node.key + ": rotate right");
            }
            return rotateRight(node);
        }
        if (balance < -1) {
            if (balanceFactor(node.right) > 0) {
                if (traceRotations) System.out.println("RL case at " + node.key + ": rotate right child right, then node left");
                node.right = rotateRight(node.right);
            } else if (traceRotations) {
                System.out.println("RR case at " + node.key + ": rotate left");
            }
            return rotateLeft(node);
        }
        return node;
    }

    private Node rotateRight(Node y) {
        if (traceRotations) System.out.println("rotateRight(" + y.key + ")");
        Node x = y.left;
        Node t2 = x.right;
        x.right = y;
        y.left = t2;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private Node rotateLeft(Node x) {
        if (traceRotations) System.out.println("rotateLeft(" + x.key + ")");
        Node y = x.right;
        Node t2 = y.left;
        y.left = x;
        x.right = t2;
        updateHeight(x);
        updateHeight(y);
        return y;
    }

    private int height(Node node) { return node == null ? -1 : node.height; }
    private void updateHeight(Node node) { node.height = 1 + Math.max(height(node.left), height(node.right)); }
    private int balanceFactor(Node node) { return node == null ? 0 : height(node.left) - height(node.right); }

    public int height() { return height(root); }
    public int rootKey() { return root == null ? Integer.MIN_VALUE : root.key; }

    public List<Integer> inorder() {
        List<Integer> out = new ArrayList<>();
        inorder(root, out);
        return out;
    }

    private void inorder(Node node, List<Integer> out) {
        if (node == null) return;
        inorder(node.left, out);
        out.add(node.key);
        inorder(node.right, out);
    }

    public boolean isAvlValid() {
        try { check(root, null, null); return true; }
        catch (IllegalStateException ex) { return false; }
    }

    private int check(Node node, Integer low, Integer high) {
        if (node == null) return -1;
        if (low != null && node.key <= low) throw new IllegalStateException("BST low bound violated");
        if (high != null && node.key >= high) throw new IllegalStateException("BST high bound violated");
        int lh = check(node.left, low, node.key);
        int rh = check(node.right, node.key, high);
        if (Math.abs(lh - rh) > 1) throw new IllegalStateException("AVL balance violated at " + node.key);
        if (node.height != 1 + Math.max(lh, rh)) throw new IllegalStateException("stored height wrong");
        return node.height;
    }

    public void printTree() { printTree(root, "", "root"); }

    private void printTree(Node node, String indent, String label) {
        if (node == null) {
            System.out.println(indent + label + ": null");
            return;
        }
        System.out.println(indent + label + ": " + node.key + " h=" + node.height + " bf=" + balanceFactor(node));
        printTree(node.left, indent + "  ", "L");
        printTree(node.right, indent + "  ", "R");
    }
}
