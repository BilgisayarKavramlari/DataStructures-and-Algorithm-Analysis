public class BSTInsertSearchDemo {
    public static void run() {
        System.out.println("--- BST insert and search ---");
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        int[] keys = {6, 3, 8, 1, 4, 7, 9};
        for (int key : keys) {
            System.out.println("insert " + key);
            tree.insert(key);
        }
        tree.printTree();
        System.out.println("inorder traversal (sorted): " + tree.inorder());
        System.out.println("contains 4? " + tree.contains(4));
        System.out.println("contains 5? " + tree.contains(5));
        System.out.println("Search follows one path from root to leaf, so time O(height).\n");
    }
}
