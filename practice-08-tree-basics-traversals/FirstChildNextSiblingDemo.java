/**
 * Demonstrates the first-child / next-sibling representation of a general tree.
 *
 * Main idea: every general tree can be represented using only two references per
 * node: one to the first child and one to the next sibling.
 */
public class FirstChildNextSiblingDemo {
    static class Node {
        String label;
        Node firstChild;
        Node nextSibling;

        Node(String label) { this.label = label; }
    }

    private static void print(Node node, String indent) {
        if (node == null) return;
        System.out.println(indent + node.label);
        print(node.firstChild, indent + "  ");
        print(node.nextSibling, indent);
    }

    public static void run() {
        System.out.println("--- First-child / next-sibling representation ---");
        Node root = new Node("A");
        root.firstChild = new Node("B");
        root.firstChild.nextSibling = new Node("C");
        root.firstChild.nextSibling.nextSibling = new Node("D");
        root.firstChild.firstChild = new Node("E");
        root.firstChild.firstChild.nextSibling = new Node("F");

        System.out.println("Tree printed from two-link representation:");
        print(root, "");
        System.out.println("Teaching note: firstChild goes down one level; nextSibling stays on the same level.");
        System.out.println("Space: O(n) nodes and exactly two structural links per node.\n");
    }
}
