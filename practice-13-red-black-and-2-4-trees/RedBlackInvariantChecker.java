/** Runs invariant checks after a mixed insert/delete sequence. */
public class RedBlackInvariantChecker {
    public static void run() {
        System.out.println("-- RedBlackInvariantChecker");
        RedBlackTreeEducational tree = new RedBlackTreeEducational();
        int[] inserts = {25, 10, 40, 5, 15, 30, 50, 1, 8, 12, 18, 28, 35, 45, 60};
        for (int key : inserts) {
            tree.insert(key);
            tree.validateOrThrow();
        }
        System.out.println("  valid after inserts: " + tree.invariantsHold());
        for (int key : new int[] {1, 50, 25, 10, 35}) {
            tree.delete(key);
            tree.validateOrThrow();
            System.out.println("  valid after deleting " + key + ": " + tree.invariantsHold()
                    + ", inorder=" + tree.inorderKeys());
        }
        System.out.println("  root is black, red nodes have black children, and black-heights match\n");
    }

    public static void main(String[] args) {
        run();
    }
}
