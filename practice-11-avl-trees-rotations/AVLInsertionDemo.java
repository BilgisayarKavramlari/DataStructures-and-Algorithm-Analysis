public class AVLInsertionDemo {
    public static void run() {
        System.out.println("--- AVL insertion maintains logarithmic height ---");
        AVLTree tree = new AVLTree();
        for (int i = 1; i <= 15; i++) tree.insert(i);
        System.out.println("inserting sorted keys 1..15 still gives height=" + tree.height());
        System.out.println("inorder=" + tree.inorder());
        System.out.println("valid AVL? " + tree.isAvlValid());
        System.out.println();
    }
}
