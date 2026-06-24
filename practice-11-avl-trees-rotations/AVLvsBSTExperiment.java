public class AVLvsBSTExperiment {
    static class PlainBST {
        static class Node { int key; Node left, right; Node(int key) { this.key = key; } }
        Node root;
        void insert(int key) { root = insert(root, key); }
        Node insert(Node n, int key) {
            if (n == null) return new Node(key);
            if (key < n.key) n.left = insert(n.left, key); else if (key > n.key) n.right = insert(n.right, key);
            return n;
        }
        int height() { return height(root); }
        int height(Node n) { return n == null ? -1 : 1 + Math.max(height(n.left), height(n.right)); }
    }

    public static void run() {
        System.out.println("--- AVL vs ordinary BST height ---");
        PlainBST bst = new PlainBST();
        AVLTree avl = new AVLTree();
        for (int i = 1; i <= 31; i++) { bst.insert(i); avl.insert(i); }
        System.out.println("sorted insertion 1..31");
        System.out.println("ordinary BST height=" + bst.height());
        System.out.println("AVL height=" + avl.height());
        System.out.println("AVL rotations prevent the sorted-input disaster.\n");
    }
}
