import java.util.Random;

/**
 * TreapEducationalDemo
 *
 * A treap is a binary search tree that is also a heap on randomly assigned
 * priorities. Keys obey BST order; priorities obey heap order. Because the
 * priorities are random, the tree's expected height is O(log n), giving balanced
 * behaviour without explicit rebalancing rules. It is a clean illustration of
 * randomization producing balance.
 *
 * Invariant: for every node, left.key < key < right.key (BST) and the node's
 * priority is greater than or equal to its children's (max-heap).
 *
 * Time complexity: expected O(log n) search, insert, delete. Space: O(n).
 */
public class TreapEducationalDemo {

    private static class Node {
        int key;
        int priority;
        Node left;
        Node right;

        Node(int key, int priority) {
            this.key = key;
            this.priority = priority;
        }
    }

    private Node root;
    private final Random random = new Random(5);

    public void demonstrate() {
        System.out.println("A treap keeps BST order on keys and heap order on random priorities.");
        int[] keys = { 50, 30, 70, 20, 40, 60, 80 };
        for (int key : keys) {
            root = insert(root, key);
        }

        System.out.println("  in-order traversal (must be sorted by key):");
        StringBuilder sb = new StringBuilder("    ");
        inorder(root, sb);
        System.out.println(sb.toString().trim());

        System.out.println("  structure (key/priority), parent priority >= child priority:");
        printTree(root, 2);
        System.out.println("  random priorities keep the expected height logarithmic.");
    }

    private Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key, random.nextInt(100));
        }
        if (key < node.key) {
            node.left = insert(node.left, key);
            if (node.left.priority > node.priority) {
                node = rotateRight(node);
            }
        } else {
            node.right = insert(node.right, key);
            if (node.right.priority > node.priority) {
                node = rotateLeft(node);
            }
        }
        return node;
    }

    private Node rotateRight(Node y) {
        Node x = y.left;
        y.left = x.right;
        x.right = y;
        return x;
    }

    private Node rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        return y;
    }

    private void inorder(Node node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        inorder(node.left, sb);
        sb.append(node.key).append(" ");
        inorder(node.right, sb);
    }

    private void printTree(Node node, int indent) {
        if (node == null) {
            return;
        }
        StringBuilder pad = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            pad.append(" ");
        }
        System.out.println(pad.toString() + node.key + "/p" + node.priority);
        printTree(node.left, indent + 2);
        printTree(node.right, indent + 2);
    }
}
