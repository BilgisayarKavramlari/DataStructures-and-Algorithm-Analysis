public class AVLRotationTraceDemo {
    public static void run() {
        System.out.println("--- AVL rotation trace in a longer insertion sequence ---");
        AVLTree tree = new AVLTree(true);
        for (int x : new int[]{50, 20, 70, 10, 30, 25, 27}) {
            System.out.println("insert " + x);
            tree.insert(x);
            System.out.println("inorder=" + tree.inorder() + ", height=" + tree.height() + ", valid=" + tree.isAvlValid());
        }
        System.out.println();
    }
}
