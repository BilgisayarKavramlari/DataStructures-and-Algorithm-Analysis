public class BSTHeightExperiment {
    public static void run() {
        System.out.println("--- BST height experiment ---");
        BinarySearchTree<Integer> skewed = new BinarySearchTree<>();
        for (int i = 1; i <= 10; i++) skewed.insert(i);
        System.out.println("sorted insertion order height: " + skewed.height() + " for " + skewed.countNodes() + " nodes");

        BinarySearchTree<Integer> better = new BinarySearchTree<>();
        for (int key : new int[]{6, 3, 9, 2, 5, 8, 10, 1, 4, 7}) better.insert(key);
        System.out.println("more balanced insertion order height: " + better.height() + " for " + better.countNodes() + " nodes");
        System.out.println("BST performance depends on shape; this motivates AVL, red-black, and splay trees.\n");
    }
}
