/**
 * Basic binary tree node.
 * Invariant: each node has at most one left child and at most one right child.
 */
public class BinaryTreeNode {
    String label;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(String label) {
        this.label = label;
    }

    public BinaryTreeNode withLeft(BinaryTreeNode child) {
        this.left = child;
        return this;
    }

    public BinaryTreeNode withRight(BinaryTreeNode child) {
        this.right = child;
        return this;
    }

    public static BinaryTreeNode sampleExpressionShape() {
        BinaryTreeNode root = new BinaryTreeNode("*");
        root.left = new BinaryTreeNode("+");
        root.right = new BinaryTreeNode("-");
        root.left.left = new BinaryTreeNode("a");
        root.left.right = new BinaryTreeNode("b");
        root.right.left = new BinaryTreeNode("c");
        root.right.right = new BinaryTreeNode("d");
        return root;
    }
}
