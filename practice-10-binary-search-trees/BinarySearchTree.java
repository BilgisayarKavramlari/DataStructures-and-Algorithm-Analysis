import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * A readable generic binary search tree implementation for teaching.
 *
 * BST invariant: for every node x, all keys in x.left are smaller than x.key,
 * and all keys in x.right are larger than x.key.
 *
 * Time complexity: search/insert/delete are O(h), where h is the tree height.
 * In a balanced tree h = O(log n); in a skewed tree h = O(n).
 */
public class BinarySearchTree<E extends Comparable<E>> {
    static class Node<E> {
        E key;
        Node<E> left;
        Node<E> right;
        Node(E key) { this.key = key; }
    }

    private Node<E> root;

    public void insert(E key) { root = insert(root, key); }

    private Node<E> insert(Node<E> node, E key) {
        if (node == null) return new Node<>(key);
        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.left = insert(node.left, key);
        else if (cmp > 0) node.right = insert(node.right, key);
        return node; // duplicates are ignored in this educational set-style BST
    }

    public boolean contains(E key) {
        Node<E> current = root;
        while (current != null) {
            int cmp = key.compareTo(current.key);
            if (cmp == 0) return true;
            current = cmp < 0 ? current.left : current.right;
        }
        return false;
    }

    public E findMin() {
        if (root == null) throw new NoSuchElementException("empty tree");
        return findMin(root).key;
    }

    private Node<E> findMin(Node<E> node) {
        while (node.left != null) node = node.left;
        return node;
    }

    public E findMax() {
        if (root == null) throw new NoSuchElementException("empty tree");
        Node<E> node = root;
        while (node.right != null) node = node.right;
        return node.key;
    }

    public void remove(E key) { root = remove(root, key); }

    private Node<E> remove(Node<E> node, E key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.left = remove(node.left, key);
        else if (cmp > 0) node.right = remove(node.right, key);
        else {
            if (node.left != null && node.right != null) {
                Node<E> successor = findMin(node.right);
                node.key = successor.key;
                node.right = remove(node.right, successor.key);
            } else {
                node = (node.left != null) ? node.left : node.right;
            }
        }
        return node;
    }

    public E predecessor(E key) {
        Node<E> current = root;
        E answer = null;
        while (current != null) {
            int cmp = key.compareTo(current.key);
            if (cmp <= 0) current = current.left;
            else { answer = current.key; current = current.right; }
        }
        return answer;
    }

    public E successor(E key) {
        Node<E> current = root;
        E answer = null;
        while (current != null) {
            int cmp = key.compareTo(current.key);
            if (cmp >= 0) current = current.right;
            else { answer = current.key; current = current.left; }
        }
        return answer;
    }

    public int height() { return height(root); }
    private int height(Node<E> node) { return node == null ? -1 : 1 + Math.max(height(node.left), height(node.right)); }

    public int countNodes() { return countNodes(root); }
    private int countNodes(Node<E> node) { return node == null ? 0 : 1 + countNodes(node.left) + countNodes(node.right); }

    public int countLeaves() { return countLeaves(root); }
    private int countLeaves(Node<E> node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return countLeaves(node.left) + countLeaves(node.right);
    }

    public List<E> inorder() {
        List<E> keys = new ArrayList<>();
        inorder(root, keys);
        return keys;
    }

    private void inorder(Node<E> node, List<E> keys) {
        if (node == null) return;
        inorder(node.left, keys);
        keys.add(node.key);
        inorder(node.right, keys);
    }

    public boolean isInvariantValid() { return isInvariantValid(root, null, null); }

    private boolean isInvariantValid(Node<E> node, E low, E high) {
        if (node == null) return true;
        if (low != null && node.key.compareTo(low) <= 0) return false;
        if (high != null && node.key.compareTo(high) >= 0) return false;
        return isInvariantValid(node.left, low, node.key) && isInvariantValid(node.right, node.key, high);
    }

    public void printTree() { printTree(root, "", "root"); }

    private void printTree(Node<E> node, String indent, String label) {
        if (node == null) {
            System.out.println(indent + label + ": null");
            return;
        }
        System.out.println(indent + label + ": " + node.key);
        printTree(node.left, indent + "  ", "L");
        printTree(node.right, indent + "  ", "R");
    }
}
