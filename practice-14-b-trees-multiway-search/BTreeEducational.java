import java.util.ArrayList;
import java.util.List;

/**
 * BTreeEducational
 *
 * Represents a B-tree of a chosen minimum degree t. Every node (except the root)
 * holds between t-1 and 2t-1 keys, and every internal node holds one more child
 * than keys. All leaves are at the same depth, which keeps the height O(log_t n)
 * and makes B-trees ideal for block-oriented storage.
 *
 * Invariant: keys within a node are sorted; all leaves share the same depth; a
 * non-root node has at least t-1 keys and at most 2t-1 keys.
 *
 * Main operation: search descends the multiway structure; insertion splits any
 * full (2t-1 key) node it meets on the way down, promoting the median upward.
 *
 * Edge cases: splitting the root grows the tree's height by one.
 *
 * Time complexity: O(t * log_t n) comparisons per search or insert.
 * Space complexity: O(n).
 */
public class BTreeEducational {

    private final int t;            // minimum degree

    static class Node {
        List<Integer> keys = new ArrayList<>();
        List<Node> children = new ArrayList<>();
        boolean leaf = true;
    }

    private Node root = new Node();

    public BTreeEducational(int minimumDegree) {
        this.t = minimumDegree;
    }

    private boolean isFull(Node n) {
        return n.keys.size() == 2 * t - 1;
    }

    /** Returns true when the key is present in the tree. */
    public boolean search(int key) {
        return search(root, key);
    }

    private boolean search(Node n, int key) {
        int i = 0;
        while (i < n.keys.size() && key > n.keys.get(i)) {
            i++;
        }
        if (i < n.keys.size() && n.keys.get(i) == key) {
            return true;
        }
        if (n.leaf) {
            return false;
        }
        return search(n.children.get(i), key);
    }

    /** Counts the nodes visited while searching, for the search demo. */
    public int searchVisitCount(int key) {
        int visits = 0;
        Node n = root;
        while (n != null) {
            visits++;
            int i = 0;
            while (i < n.keys.size() && key > n.keys.get(i)) {
                i++;
            }
            if (i < n.keys.size() && n.keys.get(i) == key) {
                return visits;
            }
            if (n.leaf) {
                return visits;
            }
            n = n.children.get(i);
        }
        return visits;
    }

    public void insert(int key) {
        if (isFull(root)) {
            Node newRoot = new Node();
            newRoot.leaf = false;
            newRoot.children.add(root);
            splitChild(newRoot, 0);
            root = newRoot;
        }
        insertNonFull(root, key);
    }

    private void insertNonFull(Node n, int key) {
        int i = n.keys.size() - 1;
        if (n.leaf) {
            n.keys.add(0);                      // grow the list by one slot
            while (i >= 0 && key < n.keys.get(i)) {
                n.keys.set(i + 1, n.keys.get(i));
                i--;
            }
            n.keys.set(i + 1, key);
        } else {
            while (i >= 0 && key < n.keys.get(i)) {
                i--;
            }
            i++;
            if (isFull(n.children.get(i))) {
                splitChild(n, i);
                if (key > n.keys.get(i)) {
                    i++;
                }
            }
            insertNonFull(n.children.get(i), key);
        }
    }

    /** Splits the full child at index, promoting its median into the parent. */
    private void splitChild(Node parent, int index) {
        Node full = parent.children.get(index);
        Node right = new Node();
        right.leaf = full.leaf;

        int median = full.keys.get(t - 1);

        // Right node takes the top t-1 keys.
        for (int j = t; j < full.keys.size(); j++) {
            right.keys.add(full.keys.get(j));
        }
        if (!full.leaf) {
            for (int j = t; j < full.children.size(); j++) {
                right.children.add(full.children.get(j));
            }
        }
        // Trim the full node down to its lower t-1 keys.
        List<Integer> leftKeys = new ArrayList<>(full.keys.subList(0, t - 1));
        full.keys = leftKeys;
        if (!full.leaf) {
            full.children = new ArrayList<>(full.children.subList(0, t));
        }
        parent.keys.add(index, median);
        parent.children.add(index + 1, right);
    }

    public void printByLevel() {
        List<Node> level = new ArrayList<>();
        level.add(root);
        int depth = 0;
        while (!level.isEmpty()) {
            StringBuilder sb = new StringBuilder("Level " + depth + ": ");
            List<Node> next = new ArrayList<>();
            for (Node n : level) {
                sb.append(n.keys).append(" ");
                next.addAll(n.children);
            }
            System.out.println(sb.toString().trim());
            level = next;
            depth++;
        }
    }

    public int height() {
        int h = 0;
        Node n = root;
        while (!n.leaf) {
            h++;
            n = n.children.get(0);
        }
        return h;
    }
}
