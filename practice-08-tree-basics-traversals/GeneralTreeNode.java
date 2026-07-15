import java.util.ArrayList;
import java.util.List;

/**
 * A node in a general tree. A general tree node may have any number of children.
 *
 * Invariant: children are stored in parent-to-child order in the children list.
 * This representation is easy to understand but may use more references than
 * the first-child/next-sibling representation.
 */
public class GeneralTreeNode {
    final String label;
    final List<GeneralTreeNode> children = new ArrayList<>();

    public GeneralTreeNode(String label) {
        this.label = label;
    }

    public GeneralTreeNode addChild(String childLabel) {
        GeneralTreeNode child = new GeneralTreeNode(childLabel);
        children.add(child);
        return child;
    }

    public int height() {
        int maxChildHeight = -1; // a leaf has height 0
        for (GeneralTreeNode child : children) {
            maxChildHeight = Math.max(maxChildHeight, child.height());
        }
        return maxChildHeight + 1;
    }

    public int size() {
        int total = 1;
        for (GeneralTreeNode child : children) {
            total += child.size();
        }
        return total;
    }

    public void printPreorder(String indent) {
        System.out.println(indent + label);
        for (GeneralTreeNode child : children) {
            child.printPreorder(indent + "  ");
        }
    }

    public static GeneralTreeNode sampleCourseTree() {
        GeneralTreeNode course = new GeneralTreeNode("CS3345");
        GeneralTreeNode trees = course.addChild("Trees");
        trees.addChild("Traversals");
        trees.addChild("BST");
        trees.addChild("AVL");
        GeneralTreeNode graphs = course.addChild("Graphs");
        graphs.addChild("BFS");
        graphs.addChild("Dijkstra");
        course.addChild("Hashing");
        return course;
    }
}
