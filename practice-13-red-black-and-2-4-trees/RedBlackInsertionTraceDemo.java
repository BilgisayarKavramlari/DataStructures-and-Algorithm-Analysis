public class RedBlackInsertionTraceDemo {
    public static void run() {
        System.out.println("--- Red-black insertion trace ---");
        RedBlackTreeEducational tree = new RedBlackTreeEducational(true);
        for (int key : new int[]{10, 20, 30, 15, 5, 1, 8}) {
            System.out.println("\ninsert " + key);
            tree.insert(key);
            System.out.println("inorder=" + tree.inorder() + ", valid=" + tree.isValidRedBlackTree());
            tree.printTree();
        }
        System.out.println();
    }
}
