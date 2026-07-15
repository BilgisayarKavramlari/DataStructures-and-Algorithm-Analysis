import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Complete educational red-black tree for integer keys.
 *
 * Invariants:
 * 1. Every node is red or black.
 * 2. The root is black.
 * 3. Every external NIL leaf is black.
 * 4. A red node has black children.
 * 5. Every path from a node to a NIL leaf has the same number of black nodes.
 *
 * Operations:
 * - search/contains: O(log n) after balancing.
 * - insert/delete: O(log n), using rotations and recoloring.
 * - traversal and validation: O(n).
 *
 * This class uses one explicit NIL sentinel so deletion fix-up can safely reason
 * about black leaves.  Duplicate inserts are ignored to keep the tree a set.
 */
public class RedBlackTreeEducational {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    static class Node {
        int key;
        boolean color;
        Node left;
        Node right;
        Node parent;

        Node(int key, boolean color) {
            this.key = key;
            this.color = color;
        }
    }

    private final Node nil = new Node(0, BLACK);
    private Node root = nil;
    private int size;
    private boolean verbose;

    public RedBlackTreeEducational() {
        nil.left = nil;
        nil.right = nil;
        nil.parent = nil;
    }

    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(int key) {
        return searchNode(key) != nil;
    }

    public Integer minimum() {
        if (root == nil) {
            return null;
        }
        return minimumNode(root).key;
    }

    public Integer maximum() {
        if (root == nil) {
            return null;
        }
        Node node = root;
        while (node.right != nil) {
            node = node.right;
        }
        return node.key;
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == nil) {
            return -1;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public List<Integer> inorderKeys() {
        ArrayList<Integer> keys = new ArrayList<Integer>();
        inorder(root, keys);
        return keys;
    }

    private void inorder(Node node, List<Integer> keys) {
        if (node == nil) {
            return;
        }
        inorder(node.left, keys);
        keys.add(node.key);
        inorder(node.right, keys);
    }

    public String levelOrderString() {
        if (root == nil) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder();
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            builder.append(node.key)
                   .append(node.color == RED ? "R" : "B")
                   .append(" ");
            if (node.left != nil) {
                queue.add(node.left);
            }
            if (node.right != nil) {
                queue.add(node.right);
            }
        }
        return builder.toString().trim();
    }

    public void printTree() {
        System.out.println("  level order: " + levelOrderString());
        System.out.println("  inorder: " + inorderKeys());
    }

    public void insert(int key) {
        Node parent = nil;
        Node current = root;
        while (current != nil) {
            parent = current;
            if (key == current.key) {
                trace("ignore duplicate key " + key);
                return;
            } else if (key < current.key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        Node inserted = new Node(key, RED);
        inserted.left = nil;
        inserted.right = nil;
        inserted.parent = parent;

        if (parent == nil) {
            root = inserted;
        } else if (key < parent.key) {
            parent.left = inserted;
        } else {
            parent.right = inserted;
        }
        size++;
        trace("insert red node " + key);
        insertFixup(inserted);
    }

    private void insertFixup(Node node) {
        while (node.parent.color == RED) {
            if (node.parent == node.parent.parent.left) {
                Node uncle = node.parent.parent.right;
                if (uncle.color == RED) {
                    trace("insert case: recolor parent " + node.parent.key
                            + ", uncle " + uncle.key + ", grandparent " + node.parent.parent.key);
                    node.parent.color = BLACK;
                    uncle.color = BLACK;
                    node.parent.parent.color = RED;
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.right) {
                        trace("insert case: left rotate parent " + node.parent.key);
                        node = node.parent;
                        rotateLeft(node);
                    }
                    trace("insert case: right rotate grandparent " + node.parent.parent.key);
                    node.parent.color = BLACK;
                    node.parent.parent.color = RED;
                    rotateRight(node.parent.parent);
                }
            } else {
                Node uncle = node.parent.parent.left;
                if (uncle.color == RED) {
                    trace("insert mirror case: recolor parent " + node.parent.key
                            + ", uncle " + uncle.key + ", grandparent " + node.parent.parent.key);
                    node.parent.color = BLACK;
                    uncle.color = BLACK;
                    node.parent.parent.color = RED;
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.left) {
                        trace("insert mirror case: right rotate parent " + node.parent.key);
                        node = node.parent;
                        rotateRight(node);
                    }
                    trace("insert mirror case: left rotate grandparent " + node.parent.parent.key);
                    node.parent.color = BLACK;
                    node.parent.parent.color = RED;
                    rotateLeft(node.parent.parent);
                }
            }
        }
        root.color = BLACK;
        root.parent = nil;
    }

    public boolean delete(int key) {
        Node target = searchNode(key);
        if (target == nil) {
            trace("delete skipped; key not found: " + key);
            return false;
        }

        Node movedOrNil;
        boolean removedOriginalColor = target.color;
        if (target.left == nil) {
            movedOrNil = target.right;
            transplant(target, target.right);
        } else if (target.right == nil) {
            movedOrNil = target.left;
            transplant(target, target.left);
        } else {
            Node successor = minimumNode(target.right);
            removedOriginalColor = successor.color;
            movedOrNil = successor.right;
            if (successor.parent == target) {
                movedOrNil.parent = successor;
            } else {
                transplant(successor, successor.right);
                successor.right = target.right;
                successor.right.parent = successor;
            }
            transplant(target, successor);
            successor.left = target.left;
            successor.left.parent = successor;
            successor.color = target.color;
        }

        size--;
        trace("deleted key " + key + "; removed color was " + colorName(removedOriginalColor));
        if (removedOriginalColor == BLACK) {
            deleteFixup(movedOrNil);
        }
        if (root != nil) {
            root.color = BLACK;
            root.parent = nil;
        }
        return true;
    }

    private void deleteFixup(Node node) {
        while (node != root && node.color == BLACK) {
            if (node == node.parent.left) {
                Node sibling = node.parent.right;
                if (sibling.color == RED) {
                    trace("delete case 1: red sibling " + sibling.key);
                    sibling.color = BLACK;
                    node.parent.color = RED;
                    rotateLeft(node.parent);
                    sibling = node.parent.right;
                }
                if (sibling.left.color == BLACK && sibling.right.color == BLACK) {
                    trace("delete case 2: black sibling with black children");
                    sibling.color = RED;
                    node = node.parent;
                } else {
                    if (sibling.right.color == BLACK) {
                        trace("delete case 3: rotate sibling " + sibling.key + " right");
                        sibling.left.color = BLACK;
                        sibling.color = RED;
                        rotateRight(sibling);
                        sibling = node.parent.right;
                    }
                    trace("delete case 4: rotate parent " + node.parent.key + " left");
                    sibling.color = node.parent.color;
                    node.parent.color = BLACK;
                    sibling.right.color = BLACK;
                    rotateLeft(node.parent);
                    node = root;
                }
            } else {
                Node sibling = node.parent.left;
                if (sibling.color == RED) {
                    trace("delete mirror case 1: red sibling " + sibling.key);
                    sibling.color = BLACK;
                    node.parent.color = RED;
                    rotateRight(node.parent);
                    sibling = node.parent.left;
                }
                if (sibling.right.color == BLACK && sibling.left.color == BLACK) {
                    trace("delete mirror case 2: black sibling with black children");
                    sibling.color = RED;
                    node = node.parent;
                } else {
                    if (sibling.left.color == BLACK) {
                        trace("delete mirror case 3: rotate sibling " + sibling.key + " left");
                        sibling.right.color = BLACK;
                        sibling.color = RED;
                        rotateLeft(sibling);
                        sibling = node.parent.left;
                    }
                    trace("delete mirror case 4: rotate parent " + node.parent.key + " right");
                    sibling.color = node.parent.color;
                    node.parent.color = BLACK;
                    sibling.left.color = BLACK;
                    rotateRight(node.parent);
                    node = root;
                }
            }
        }
        node.color = BLACK;
    }

    private void rotateLeft(Node pivot) {
        Node child = pivot.right;
        pivot.right = child.left;
        if (child.left != nil) {
            child.left.parent = pivot;
        }
        child.parent = pivot.parent;
        if (pivot.parent == nil) {
            root = child;
        } else if (pivot == pivot.parent.left) {
            pivot.parent.left = child;
        } else {
            pivot.parent.right = child;
        }
        child.left = pivot;
        pivot.parent = child;
        trace("rotate left at " + pivot.key);
    }

    private void rotateRight(Node pivot) {
        Node child = pivot.left;
        pivot.left = child.right;
        if (child.right != nil) {
            child.right.parent = pivot;
        }
        child.parent = pivot.parent;
        if (pivot.parent == nil) {
            root = child;
        } else if (pivot == pivot.parent.right) {
            pivot.parent.right = child;
        } else {
            pivot.parent.left = child;
        }
        child.right = pivot;
        pivot.parent = child;
        trace("rotate right at " + pivot.key);
    }

    private void transplant(Node oldNode, Node newNode) {
        if (oldNode.parent == nil) {
            root = newNode;
        } else if (oldNode == oldNode.parent.left) {
            oldNode.parent.left = newNode;
        } else {
            oldNode.parent.right = newNode;
        }
        newNode.parent = oldNode.parent;
    }

    private Node minimumNode(Node node) {
        while (node.left != nil) {
            node = node.left;
        }
        return node;
    }

    private Node searchNode(int key) {
        Node current = root;
        while (current != nil) {
            if (key == current.key) {
                return current;
            } else if (key < current.key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return nil;
    }

    public boolean invariantsHold() {
        try {
            validateOrThrow();
            return true;
        } catch (IllegalStateException ex) {
            return false;
        }
    }

    public void validateOrThrow() {
        if (nil.color != BLACK) {
            throw new IllegalStateException("NIL sentinel must be black");
        }
        if (root == nil) {
            if (size != 0) {
                throw new IllegalStateException("empty tree cannot have positive size");
            }
            return;
        }
        if (root.color != BLACK) {
            throw new IllegalStateException("root must be black");
        }
        if (root.parent != nil) {
            throw new IllegalStateException("root parent must be NIL");
        }
        int counted = validateNode(root, null, null).nodeCount;
        if (counted != size) {
            throw new IllegalStateException("stored size " + size + " differs from counted size " + counted);
        }
    }

    private ValidationResult validateNode(Node node, Integer minExclusive, Integer maxExclusive) {
        if (node == nil) {
            return new ValidationResult(1, 0);
        }
        if (minExclusive != null && node.key <= minExclusive) {
            throw new IllegalStateException("BST order violation at key " + node.key);
        }
        if (maxExclusive != null && node.key >= maxExclusive) {
            throw new IllegalStateException("BST order violation at key " + node.key);
        }
        if (node.color == RED && (node.left.color == RED || node.right.color == RED)) {
            throw new IllegalStateException("red node " + node.key + " has a red child");
        }
        if (node.left != nil && node.left.parent != node) {
            throw new IllegalStateException("bad parent pointer at left child of " + node.key);
        }
        if (node.right != nil && node.right.parent != node) {
            throw new IllegalStateException("bad parent pointer at right child of " + node.key);
        }

        ValidationResult left = validateNode(node.left, minExclusive, node.key);
        ValidationResult right = validateNode(node.right, node.key, maxExclusive);
        if (left.blackHeight != right.blackHeight) {
            throw new IllegalStateException("black-height mismatch at key " + node.key);
        }
        int blackHeight = left.blackHeight + (node.color == BLACK ? 1 : 0);
        int nodeCount = left.nodeCount + right.nodeCount + 1;
        return new ValidationResult(blackHeight, nodeCount);
    }

    private static class ValidationResult {
        final int blackHeight;
        final int nodeCount;

        ValidationResult(int blackHeight, int nodeCount) {
            this.blackHeight = blackHeight;
            this.nodeCount = nodeCount;
        }
    }

    private void trace(String message) {
        if (verbose) {
            System.out.println("  " + message);
        }
    }

    private String colorName(boolean color) {
        return color == RED ? "RED" : "BLACK";
    }

    public static void run() {
        RedBlackTreeEducational tree = new RedBlackTreeEducational();
        tree.setVerbose(true);
        System.out.println("-- RedBlackTreeEducational: complete insert/search/delete demo");
        int[] inserts = {40, 20, 60, 10, 30, 50, 70, 25, 35, 45, 55, 65, 80};
        for (int key : inserts) {
            System.out.println("insert " + key);
            tree.insert(key);
            tree.printTree();
            System.out.println("  valid=" + tree.invariantsHold());
        }
        System.out.println("search 25=" + tree.contains(25));
        System.out.println("search 99=" + tree.contains(99));
        for (int key : new int[] {10, 60, 40}) {
            System.out.println("delete " + key);
            tree.delete(key);
            tree.printTree();
            System.out.println("  valid=" + tree.invariantsHold());
        }
        System.out.println("  min=" + tree.minimum() + ", max=" + tree.maximum()
                + ", size=" + tree.size() + ", height=" + tree.height());
        System.out.println("Complexity: search, insert, and delete are O(log n); validation is O(n).\n");
    }

    public static void main(String[] args) {
        run();
    }
}
