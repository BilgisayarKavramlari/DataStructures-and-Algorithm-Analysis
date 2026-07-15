public class BSTInvariantChecker {
    public static void run() {
        System.out.println("--- BST invariant checker ---");
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        BinarySearchTree<Integer> tree2 = new BinarySearchTree<>();
        for (int key : new int[]{10, 5, 15, 3, 7, 12, 18}) tree.insert(key);
        System.out.println("inorder: " + tree.inorder());
        System.out.println("node count=" + tree.countNodes() + ", leaf count=" + tree.countLeaves() + ", height=" + tree.height());
        System.out.println("BST invariant valid? " + tree.isInvariantValid());
        System.out.println("The checker recursively carries valid low/high bounds for each subtree.\n");

        for (int key : new int[]{3, 5, 7, 10, 12, 15, 18}) tree2.insert(key);
        System.out.println("inorder: " + tree2.inorder());
        System.out.println("node count=" + tree2.countNodes() + ", leaf count=" + tree2.countLeaves() + ", height=" + tree2.height());
        System.out.println("BST invariant valid? " + tree2.isInvariantValid());
        System.out.println("The checker recursively carries valid low/high bounds for each subtree.\n");
    }
}
