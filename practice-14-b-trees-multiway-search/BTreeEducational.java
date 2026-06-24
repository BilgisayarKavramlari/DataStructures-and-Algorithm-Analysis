import java.util.*;

/** Educational B-tree with minimum degree 2: search, insert, split, median promotion. */
public class BTreeEducational {
    private static final int T = 2;
    static class Node {
        ArrayList<Integer> keys = new ArrayList<Integer>();
        ArrayList<Node> children = new ArrayList<Node>();
        boolean leaf = true;
    }
    private Node root = new Node();
    public boolean contains(int key) { return contains(root, key); }
    private boolean contains(Node node, int key) {
        int i = 0;
        while (i < node.keys.size() && key > node.keys.get(i)) i++;
        if (i < node.keys.size() && key == node.keys.get(i)) return true;
        return !node.leaf && contains(node.children.get(i), key);
    }
    public void insert(int key) {
        if (root.keys.size() == 2 * T - 1) {
            Node newRoot = new Node();
            newRoot.leaf = false;
            newRoot.children.add(root);
            splitChild(newRoot, 0);
            root = newRoot;
        }
        insertNonFull(root, key);
    }
    private void splitChild(Node parent, int index) {
        Node full = parent.children.get(index);
        Node right = new Node();
        right.leaf = full.leaf;
        int median = full.keys.get(T - 1);
        right.keys.add(full.keys.remove(T));
        full.keys.remove(T - 1);
        if (!full.leaf) {
            right.children.add(full.children.remove(T));
            right.children.add(full.children.remove(T));
        }
        parent.keys.add(index, median);
        parent.children.add(index + 1, right);
        System.out.println("  split child; promoted median " + median);
    }
    private void insertNonFull(Node node, int key) {
        int i = node.keys.size() - 1;
        if (node.leaf) {
            node.keys.add(0);
            while (i >= 0 && key < node.keys.get(i)) { node.keys.set(i + 1, node.keys.get(i)); i--; }
            node.keys.set(i + 1, key);
            System.out.println("  insert " + key + " into leaf " + node.keys);
        } else {
            while (i >= 0 && key < node.keys.get(i)) i--;
            i++;
            if (node.children.get(i).keys.size() == 2 * T - 1) {
                splitChild(node, i);
                if (key > node.keys.get(i)) i++;
            }
            insertNonFull(node.children.get(i), key);
        }
    }
    public void printLevels() {
        Queue<Node> q = new ArrayDeque<Node>();
        q.add(root);
        while (!q.isEmpty()) {
            int level = q.size();
            for (int i=0;i<level;i++) {
                Node n = q.remove();
                System.out.print(n.keys + " ");
                q.addAll(n.children);
            }
            System.out.println();
        }
    }
    public static void run() {
        BTreeEducational tree = new BTreeEducational();
        System.out.println("-- BTreeEducational");
        for (int x : new int[]{8,9,10,11,15,20,17}) tree.insert(x);
        System.out.println("  contains 15=" + tree.contains(15));
        tree.printLevels();
        System.out.println("  Simplified: deletion is taught separately as borrow/merge traces.\n");
    }
    public static void main(String[] args){run();}
}
