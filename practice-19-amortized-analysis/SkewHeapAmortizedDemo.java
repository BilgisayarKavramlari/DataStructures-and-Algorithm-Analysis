/**
 * SkewHeapAmortizedDemo
 *
 * A skew heap is a self-adjusting leftist heap: every merge unconditionally
 * swaps the children of nodes along the right path. This needs no balance
 * bookkeeping yet still achieves amortized O(log n) merge, insert, and
 * delete-min through a potential argument based on the number of "heavy" right
 * children.
 *
 * This demo builds a small skew heap by repeated insertion (each insert is a
 * merge with a single-node heap) and prints the resulting min-extraction order
 * to confirm the heap-order property, while explaining the amortized guarantee.
 *
 * Time complexity: merge, insert, delete-min are each amortized O(log n).
 * Space complexity: O(n) for n stored keys.
 */
public class SkewHeapAmortizedDemo {

    private static class Node {
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
            Node temp = a;
            a = b;
            b = temp;
        }
        a.right = merge(a.right, b);
        Node swap = a.left;
        a.left = a.right;
        a.right = swap;
        return a;
    }

    private void insert(int key) {
        root = merge(root, new Node(key));
    }

    private int deleteMin() {
        int min = root.key;
        root = merge(root.left, root.right);
        return min;
    }

    public void demonstrate() {
        System.out.println("A skew heap always swaps children during merge: no balance info needed.");
        System.out.println();

        int[] keys = { 18, 5, 33, 12, 7, 25, 1, 9 };
        System.out.print("Inserting keys: ");
        for (int key : keys) {
            System.out.print(key + " ");
            insert(key);
        }
        System.out.println();

        System.out.print("Delete-min order: ");
        StringBuilder order = new StringBuilder();
        while (root != null) {
            order.append(deleteMin()).append(" ");
        }
        System.out.println(order.toString().trim());

        System.out.println();
        System.out.println("Keys come out sorted, confirming heap order. Each merge along the");
        System.out.println("right path with child swaps gives amortized O(log n) per operation.");
    }
}
