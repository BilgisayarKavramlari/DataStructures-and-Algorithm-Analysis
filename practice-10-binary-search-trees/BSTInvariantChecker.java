public class BSTInvariantChecker {
    public static void run() {
        System.out.println("--- BST invariant checker ---");
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        for (int key : new int[]{10, 5, 15, 3, 7, 12, 18}) tree.insert(key);
        System.out.println("inorder: " + tree.inorder());
        System.out.println("node count=" + tree.countNodes() + ", leaf count=" + tree.countLeaves() + ", height=" + tree.height());
        System.out.println("BST invariant valid? " + tree.isInvariantValid());
        System.out.println("The checker recursively carries valid low/high bounds for each subtree.\n");
    }
}
