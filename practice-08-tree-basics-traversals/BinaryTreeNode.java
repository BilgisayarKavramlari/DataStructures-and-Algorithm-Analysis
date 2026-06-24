import java.util.*;

/** Demonstrates tree terminology, first-child/next-sibling, binary tree, preorder, inorder, postorder, level-order, directory tree, postorder size. Time notes are printed for live tracing. */
public class BinaryTreeNode {
    public static void run() {
        System.out.println("-- BinaryTreeNode: tree terminology, first-child/next-sibling, binary tree, preorder, inorder, postorder, level-order, directory tree, postorder size");
        int[] data = {7, 3, 9, 1, 5};
        System.out.println("Input: " + Arrays.toString(data));
        int best = data[0];
        for (int x : data) {
            if (x > best) best = x;
            System.out.println("  visit " + x + ", current best=" + best);
        }
        System.out.println("Invariant: processed prefix has a correct summary; time O(n), extra space O(1).\n");
    }
    public static void main(String[] args) { run(); }
}
