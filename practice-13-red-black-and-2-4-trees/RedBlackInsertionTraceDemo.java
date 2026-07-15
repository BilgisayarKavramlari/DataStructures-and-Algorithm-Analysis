/** Shows insertion recoloring and rotations using the complete tree implementation. */
public class RedBlackInsertionTraceDemo {
    public static void run() {
        System.out.println("-- RedBlackInsertionTraceDemo");
        RedBlackTreeEducational tree = new RedBlackTreeEducational();
        tree.setVerbose(true);
        for (int key : new int[] {10, 20, 30, 15, 5, 1, 8}) {
            System.out.println("insert " + key);
            tree.insert(key);
            tree.printTree();
            tree.validateOrThrow();
        }
        System.out.println("  insertion trace finished with valid invariants\n");
    }

    public static void main(String[] args) {
        run();
    }
}
