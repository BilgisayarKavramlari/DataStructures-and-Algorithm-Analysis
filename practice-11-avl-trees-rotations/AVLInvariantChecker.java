public class AVLInvariantChecker {
    public static void run() {
        System.out.println("--- AVL invariant checker ---");
        AVLTree tree = new AVLTree();
        for (int x : new int[]{8, 4, 12, 2, 6, 10, 14, 1, 3}) tree.insert(x);
        tree.printTree();
        System.out.println("valid AVL? " + tree.isAvlValid());
        System.out.println("The checker verifies both BST ordering and balance factor in [-1, 1].\n");
    }
}
