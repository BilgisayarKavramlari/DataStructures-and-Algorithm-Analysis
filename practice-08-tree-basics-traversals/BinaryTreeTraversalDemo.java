/** Demonstrates preorder, inorder, and postorder traversals on a binary tree. */
public class BinaryTreeTraversalDemo {
    private static void preorder(BinaryTreeNode node) {
        if (node == null) return;
        System.out.print(node.label + " ");
        preorder(node.left);
        preorder(node.right);
    }

    private static void inorder(BinaryTreeNode node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.label + " ");
        inorder(node.right);
    }

    private static void postorder(BinaryTreeNode node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.label + " ");
    }

    public static void run() {
        System.out.println("--- Binary tree traversals ---");
        BinaryTreeNode root = BinaryTreeNode.sampleExpressionShape();
        System.out.print("Preorder  (node, left, right): "); preorder(root); System.out.println();
        System.out.print("Inorder   (left, node, right): "); inorder(root); System.out.println();
        System.out.print("Postorder (left, right, node): "); postorder(root); System.out.println();
        System.out.println("Complexity: each traversal visits every node once, so time O(n), recursion stack O(h).\n");
    }
}
