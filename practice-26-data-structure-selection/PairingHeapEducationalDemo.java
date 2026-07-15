/**
 * PairingHeapEducationalDemo
 *
 * A pairing heap is a simple, multi-way heap-ordered tree that performs very
 * well in practice and supports decrease-key efficiently. Insert and merge are
 * O(1); delete-min links the children in pairs and then folds them together. It
 * is often the pragmatic choice when a Fibonacci heap's bounds are wanted
 * without its complexity.
 *
 * Invariant: every node's key is less than or equal to all keys in its child
 * subtrees (min-heap order).
 *
 * Time complexity: insert and merge O(1); delete-min amortized O(log n).
 * Space complexity: O(n).
 */
public class PairingHeapEducationalDemo {

    private static class Node {
        int key;
        Node child;
        Node sibling;

        Node(int key) {
            this.key = key;
        }
    }

    private Node root;

    public void demonstrate() {
        System.out.println("A pairing heap: O(1) insert and merge, two-pass delete-min.");
        int[] keys = { 15, 9, 22, 3, 18, 7, 11 };
        System.out.print("  inserting: ");
        for (int key : keys) {
            System.out.print(key + " ");
            insert(key);
        }
        System.out.println();

        System.out.print("  delete-min order: ");
        StringBuilder sb = new StringBuilder();
        while (root != null) {
            sb.append(deleteMin()).append(" ");
        }
        System.out.println(sb.toString().trim());
        System.out.println("  keys emerge sorted, confirming min-heap order is maintained.");
    }

    private Node merge(Node a, Node b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        if (a.key <= b.key) {
            b.sibling = a.child;
            a.child = b;
            return a;
        } else {
            a.sibling = b.child;
            b.child = a;
            return b;
        }
    }

    private void insert(int key) {
        root = merge(root, new Node(key));
    }

    private int deleteMin() {
        int min = root.key;
        root = mergePairs(root.child);
        return min;
    }

    private Node mergePairs(Node first) {
        if (first == null || first.sibling == null) {
            return first;
        }
        Node second = first.sibling;
        Node rest = second.sibling;
        first.sibling = null;
        second.sibling = null;
        return merge(merge(first, second), mergePairs(rest));
    }
}
