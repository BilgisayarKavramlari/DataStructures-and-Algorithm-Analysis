import java.util.*;

/** Generic binary search tree used for live BST tracing. */
class TeachingBST<E extends Comparable<E>> {
    static class Node<E> { E key; Node<E> left, right; Node(E key) { this.key = key; } }
    Node<E> root;
    void insert(E key) { root = insert(root, key); }
    Node<E> insert(Node<E> n, E key) { if (n == null) return new Node<E>(key); int c = key.compareTo(n.key); if (c < 0) n.left = insert(n.left, key); else if (c > 0) n.right = insert(n.right, key); return n; }
    boolean contains(E key) { Node<E> n = root; while (n != null) { int c = key.compareTo(n.key); if (c == 0) return true; n = c < 0 ? n.left : n.right; } return false; }
    E findMin() { Node<E> n = root; while (n.left != null) n = n.left; return n.key; }
    E findMax() { Node<E> n = root; while (n.right != null) n = n.right; return n.key; }
    int height() { return height(root); } int height(Node<E> n) { return n == null ? -1 : 1 + Math.max(height(n.left), height(n.right)); }
    int count() { return count(root); } int count(Node<E> n) { return n == null ? 0 : 1 + count(n.left) + count(n.right); }
    int leaves() { return leaves(root); } int leaves(Node<E> n) { if (n == null) return 0; if (n.left == null && n.right == null) return 1; return leaves(n.left) + leaves(n.right); }
    boolean invariant() { return invariant(root, null, null); } boolean invariant(Node<E> n, E lo, E hi) { if (n == null) return true; if (lo != null && n.key.compareTo(lo) <= 0) return false; if (hi != null && n.key.compareTo(hi) >= 0) return false; return invariant(n.left, lo, n.key) && invariant(n.right, n.key, hi); }
    void printTree() { printTree(root, ""); } void printTree(Node<E> n, String indent) { if (n != null) { printTree(n.right, indent + "   "); System.out.println(indent + n.key); printTree(n.left, indent + "   "); } }
}
