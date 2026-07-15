public class AVLDeletionEducationalDemo {
    public static void run() {
        System.out.println("--- AVL deletion with rebalancing ---");
        AVLTree tree = new AVLTree(true);
        for (int x : new int[]{40, 20, 60, 10, 30, 50, 70, 25, 35}) tree.insert(x);
        System.out.println("before delete: " + tree.inorder() + ", height=" + tree.height());
        tree.remove(60);
        System.out.println("after deleting 60: " + tree.inorder() + ", height=" + tree.height() + ", valid=" + tree.isAvlValid());
        tree.remove(40);
        System.out.println("after deleting 40: " + tree.inorder() + ", height=" + tree.height() + ", valid=" + tree.isAvlValid());
        System.out.println("Deletion is BST deletion followed by AVL rebalancing on the path back to the root.\n");
    }
}
