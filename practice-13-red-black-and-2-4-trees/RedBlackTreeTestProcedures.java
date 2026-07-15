import java.util.Arrays;
import java.util.List;

/** Deterministic test procedures for insert, search, delete, order, and invariants. */
public class RedBlackTreeTestProcedures {
    public static void run() {
        System.out.println("-- RedBlackTreeTestProcedures");
        RedBlackTreeEducational tree = new RedBlackTreeEducational();
        int[] keys = {41, 38, 31, 12, 19, 8, 50, 60, 55, 1, 2, 3, 4, 5, 6, 7};
        for (int key : keys) {
            tree.insert(key);
            assertValid(tree, "after insert " + key);
        }
        assertEquals(keys.length, tree.size(), "size after unique inserts");
        assertTrue(tree.contains(31), "search finds existing key 31");
        assertTrue(!tree.contains(99), "search rejects missing key 99");
        assertEquals(Integer.valueOf(1), tree.minimum(), "minimum key");
        assertEquals(Integer.valueOf(60), tree.maximum(), "maximum key");

        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 12, 19, 31, 38, 41, 50, 55, 60);
        assertEquals(expected, tree.inorderKeys(), "inorder traversal is sorted");

        int[] deletions = {1, 60, 41, 38, 31, 12, 19, 8, 50, 55, 2, 3, 4, 5, 6, 7};
        for (int key : deletions) {
            assertTrue(tree.delete(key), "delete existing key " + key);
            assertTrue(!tree.contains(key), "deleted key no longer appears " + key);
            assertValid(tree, "after delete " + key);
        }
        assertTrue(tree.isEmpty(), "tree is empty after deleting all keys");
        assertTrue(!tree.delete(12345), "deleting a missing key returns false");
        assertValid(tree, "after missing delete on empty tree");
        System.out.println("  all red-black tree tests passed\n");
    }

    private static void assertValid(RedBlackTreeEducational tree, String context) {
        try {
            tree.validateOrThrow();
        } catch (IllegalStateException ex) {
            throw new AssertionError(context + " failed validation: " + ex.getMessage());
        }
    }

    private static void assertTrue(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
        System.out.println("  pass: " + message);
    }

    private static void assertEquals(Object expected, Object actual, String message) {
        if (expected == null ? actual != null : !expected.equals(actual)) {
            throw new AssertionError(message + ": expected " + expected + " but was " + actual);
        }
        System.out.println("  pass: " + message + " -> " + actual);
    }

    public static void main(String[] args) {
        run();
    }
}
