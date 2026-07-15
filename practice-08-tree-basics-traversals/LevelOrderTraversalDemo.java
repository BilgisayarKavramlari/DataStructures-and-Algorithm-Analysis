import java.util.ArrayDeque;
import java.util.Queue;

/** Demonstrates breadth-first / level-order traversal. */
public class LevelOrderTraversalDemo {
    public static void run() {
        System.out.println("--- Level-order traversal ---");
        GeneralTreeNode root = GeneralTreeNode.sampleCourseTree();
        Queue<GeneralTreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            GeneralTreeNode current = queue.remove();
            System.out.println("visit " + current.label + ", enqueue its " + current.children.size() + " children");
            queue.addAll(current.children);
        }
        System.out.println("Level-order traversal uses a queue. Time O(n), extra space O(width).\n");
    }
}
