import java.util.Random;

/**
 * SkipListEducationalDemo
 *
 * A skip list is a randomized, layered linked list that delivers O(log n)
 * expected search, insertion, and deletion without the rotations a balanced tree
 * needs. Each node is promoted to higher express lanes by repeated coin flips;
 * searching drops down lanes, skipping large stretches of the bottom list.
 *
 * Invariant: every level is a sorted sublist of the level below it; level 0
 * contains all keys.
 *
 * Time complexity: expected O(log n) per operation. Space complexity: O(n)
 *   expected (each node has on average two forward pointers).
 */
public class SkipListEducationalDemo {

    private static final int MAX_LEVEL = 4;
    private final Random random = new Random(7);

    private static class Node {
        int key;
        Node[] forward;

        Node(int key, int level) {
            this.key = key;
            this.forward = new Node[level + 1];
        }
    }

    private final Node head = new Node(Integer.MIN_VALUE, MAX_LEVEL);
    private int currentLevel = 0;

    public void demonstrate() {
        System.out.println("Building a skip list by inserting keys with randomized levels.");
        int[] keys = { 3, 6, 7, 9, 12, 19, 17, 26, 21, 25 };
        for (int key : keys) {
            insert(key);
        }
        printStructure();
        System.out.println();

        for (int target : new int[] { 19, 21, 15 }) {
            boolean found = search(target);
            System.out.println("  search(" + target + ") -> " + (found ? "found" : "not found"));
        }
        System.out.println();
        System.out.println("Express lanes let a search skip past many bottom-level nodes,");
        System.out.println("yielding expected logarithmic time without explicit balancing.");
    }

    private int randomLevel() {
        int level = 0;
        while (level < MAX_LEVEL && random.nextBoolean()) {
            level++;
        }
        return level;
    }

    private void insert(int key) {
        Node[] update = new Node[MAX_LEVEL + 1];
        Node x = head;
        for (int i = currentLevel; i >= 0; i--) {
            while (x.forward[i] != null && x.forward[i].key < key) {
                x = x.forward[i];
            }
            update[i] = x;
        }
        int level = randomLevel();
        if (level > currentLevel) {
            for (int i = currentLevel + 1; i <= level; i++) {
                update[i] = head;
            }
            currentLevel = level;
        }
        Node node = new Node(key, level);
        for (int i = 0; i <= level; i++) {
            node.forward[i] = update[i].forward[i];
            update[i].forward[i] = node;
        }
    }

    private boolean search(int key) {
        Node x = head;
        for (int i = currentLevel; i >= 0; i--) {
            while (x.forward[i] != null && x.forward[i].key < key) {
                x = x.forward[i];
            }
        }
        x = x.forward[0];
        return x != null && x.key == key;
    }

    private void printStructure() {
        for (int i = currentLevel; i >= 0; i--) {
            StringBuilder sb = new StringBuilder("  level " + i + ": ");
            Node x = head.forward[i];
            while (x != null) {
                sb.append(x.key).append(" ");
                x = x.forward[i];
            }
            System.out.println(sb.toString().trim());
        }
    }
}
