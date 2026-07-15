public class BSTPredecessorSuccessorDemo {
    public static void run() {
        System.out.println("--- BST predecessor and successor ---");
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        for (int key : new int[]{40, 20, 60, 10, 30, 50, 70}) tree.insert(key);
        System.out.println("inorder: " + tree.inorder());
        for (int key : new int[]{10, 30, 40, 65, 70}) {
            System.out.println("key=" + key + ", predecessor=" + tree.predecessor(key) + ", successor=" + tree.successor(key));
        }
        System.out.println("Predecessor/successor are useful for ordered sets and range queries.\n");
    }
}
