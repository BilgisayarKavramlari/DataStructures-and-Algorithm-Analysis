public class BSTDeleteDemo {
    private static BinarySearchTree<Integer> sample() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        for (int key : new int[]{50, 30, 70, 20, 40, 60, 80, 65}) tree.insert(key);
        return tree;
    }

    public static void run() {
        System.out.println("--- BST delete cases ---");
        BinarySearchTree<Integer> leafCase = sample();
        System.out.println("delete leaf 20");
        leafCase.remove(20);
        System.out.println("after leaf delete: " + leafCase.inorder());

        BinarySearchTree<Integer> oneChildCase = sample();
        System.out.println("delete node 60 with one child 65");
        oneChildCase.remove(60);
        System.out.println("after one-child delete: " + oneChildCase.inorder());

        BinarySearchTree<Integer> twoChildCase = sample();
        System.out.println("delete node 70 with two children: replace with successor from right subtree");
        twoChildCase.remove(70);
        System.out.println("after two-child delete: " + twoChildCase.inorder());
        System.out.println("Invariant check after deletes: " + twoChildCase.isInvariantValid());
        System.out.println();
    }
}
