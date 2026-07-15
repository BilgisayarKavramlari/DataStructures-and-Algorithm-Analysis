/** Prints an insertion sequence and explains where 2-3-4 node splits occur. */
public class TwoFourTreeTraceDemo {
    public static void run() {
        System.out.println("-- TwoFourTreeTraceDemo");
        RedBlackTreeEducational tree = new RedBlackTreeEducational();
        tree.setVerbose(true);
        for (int key : new int[] {10, 20, 30, 40, 50, 60, 70}) {
            System.out.println("insert " + key + " (2-3-4 view: descend, split full nodes on the way back)");
            tree.insert(key);
            tree.printTree();
            tree.validateOrThrow();
        }
        System.out.println("  Red-black rotations/recoloring simulate 2-3-4 splits while preserving sorted order.\n");
    }

    public static void main(String[] args) {
        run();
    }
}
