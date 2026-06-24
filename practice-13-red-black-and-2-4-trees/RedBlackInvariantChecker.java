public class RedBlackInvariantChecker {
    public static void run() {
        System.out.println("--- Red-black invariant checker ---");
        RedBlackTreeEducational tree = new RedBlackTreeEducational(false);
        for (int key : new int[]{50, 25, 75, 10, 30, 60, 80, 5, 15}) tree.insert(key);
        tree.printTree();
        System.out.println("valid red-black tree? " + tree.isValidRedBlackTree());
        System.out.println("The checker verifies root black, no red-red parent/child, BST order, and equal black height.\n");
    }
}
