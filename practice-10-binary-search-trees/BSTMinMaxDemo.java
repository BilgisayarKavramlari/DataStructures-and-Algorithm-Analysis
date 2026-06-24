public class BSTMinMaxDemo {
    public static void run() {
        System.out.println("--- BST min and max ---");
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        for (int key : new int[]{50, 20, 70, 10, 30, 60, 90}) tree.insert(key);
        System.out.println("inorder: " + tree.inorder());
        System.out.println("min is reached by following left links: " + tree.findMin());
        System.out.println("max is reached by following right links: " + tree.findMax());
        System.out.println();
    }
}
