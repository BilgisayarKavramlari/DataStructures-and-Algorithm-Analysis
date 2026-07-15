/** Relates red-black coloring to the 2-3-4 tree view used in lectures. */
public class TwoFourCorrespondenceDemo {
    public static void run() {
        System.out.println("-- TwoFourCorrespondenceDemo");
        RedBlackTreeEducational tree = new RedBlackTreeEducational();
        for (int key : new int[] {40, 20, 60, 10, 30, 50, 70, 25, 35}) {
            tree.insert(key);
        }
        tree.printTree();
        System.out.println("  Teaching view: a black node plus red children represents one 2-3-4 node.");
        System.out.println("  Splitting a 4-node corresponds to recoloring and sometimes rotation.");
        System.out.println("  The actual tree above remains a binary-search tree with red-black invariants.\n");
    }

    public static void main(String[] args) {
        run();
    }
}
