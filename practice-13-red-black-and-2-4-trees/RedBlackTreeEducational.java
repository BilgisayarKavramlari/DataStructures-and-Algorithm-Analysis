/** Educational left-leaning red-black insertion with invariant checking. */
public class RedBlackTreeEducational {
    static class Node {
        int key;
        boolean red = true;
        Node left, right;
        Node(int key) { this.key = key; }
    }
    private Node root;
    private boolean isRed(Node node) { return node != null && node.red; }
    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.red = h.red;
        h.red = true;
        System.out.println("  rotate left at " + h.key);
        return x;
    }
    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.red = h.red;
        h.red = true;
        System.out.println("  rotate right at " + h.key);
        return x;
    }
    private void flipColors(Node h) {
        h.red = !h.red;
        h.left.red = !h.left.red;
        h.right.red = !h.right.red;
        System.out.println("  color flip at " + h.key);
    }
    public void insert(int key) {
        root = insert(root, key);
        root.red = false;
    }
    private Node insert(Node h, int key) {
        if (h == null) return new Node(key);
        if (key < h.key) h.left = insert(h.left, key);
        else if (key > h.key) h.right = insert(h.right, key);
        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);
        return h;
    }
    private int blackHeight(Node n) {
        if (n == null) return 1;
        int left = blackHeight(n.left);
        int right = blackHeight(n.right);
        if (left != right) throw new IllegalStateException("black-height mismatch");
        if (isRed(n) && (isRed(n.left) || isRed(n.right))) throw new IllegalStateException("red parent has red child");
        return left + (n.red ? 0 : 1);
    }
    public boolean invariantsHold() { return root == null || (!root.red && blackHeight(root) > 0); }
    public static void run() {
        RedBlackTreeEducational tree = new RedBlackTreeEducational();
        System.out.println("-- RedBlackTreeEducational");
        for (int x : new int[]{10,20,30,15,5,1}) {
            System.out.println("insert " + x);
            tree.insert(x);
            System.out.println("  invariants hold=" + tree.invariantsHold());
        }
        System.out.println("  Simplified: deletion is shown in RedBlackDeletionConceptDemo as double-black cases.\n");
    }
    public static void main(String[] args) { run(); }
}
