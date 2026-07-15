/** Demonstrates working deletion cases: leaf, one-child, two-child, root, and missing key. */
public class RedBlackDeletionConceptDemo {
    public static void run() {
        System.out.println("-- RedBlackDeletionConceptDemo");
        RedBlackTreeEducational tree = new RedBlackTreeEducational();
        tree.setVerbose(true);
        for (int key : new int[] {40, 20, 60, 10, 30, 50, 70, 25, 35, 45, 55, 65, 80}) {
            tree.insert(key);
        }
        tree.printTree();

        for (int key : new int[] {10, 30, 60, 40, 999}) {
            System.out.println("delete request " + key);
            boolean removed = tree.delete(key);
            System.out.println("  removed=" + removed);
            tree.printTree();
            tree.validateOrThrow();
        }
        System.out.println("  deletion uses transplant, successor replacement, and delete fix-up cases");
        System.out.println("  every displayed delete leaves a valid red-black tree\n");
    }

    public static void main(String[] args) {
        run();
    }
}
