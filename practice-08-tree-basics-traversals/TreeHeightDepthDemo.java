/** Demonstrates height and depth in a tree. */
public class TreeHeightDepthDemo {
    private static void printDepths(GeneralTreeNode node, int depth) {
        System.out.println("node=" + node.label + ", depth=" + depth + ", subtree height=" + node.height());
        for (GeneralTreeNode child : node.children) {
            printDepths(child, depth + 1);
        }
    }

    public static void run() {
        System.out.println("--- Height and depth ---");
        GeneralTreeNode root = GeneralTreeNode.sampleCourseTree();
        printDepths(root, 0);
        System.out.println("Depth counts edges from the root to the node; height counts longest path down to a leaf.\n");
    }
}
