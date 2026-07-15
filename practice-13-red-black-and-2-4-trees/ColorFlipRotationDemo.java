/** Demonstrates visible recoloring and rotations during insert and delete fix-up. */
public class ColorFlipRotationDemo {
    public static void run() {
        System.out.println("-- ColorFlipRotationDemo");
        RedBlackTreeEducational tree = new RedBlackTreeEducational();
        tree.setVerbose(true);
        for (int key : new int[] {7, 3, 18, 10, 22, 8, 11, 26}) {
            System.out.println("insert " + key);
            tree.insert(key);
            tree.printTree();
        }
        System.out.println("delete 3 to trigger delete fix-up if needed");
        tree.delete(3);
        tree.printTree();
        tree.validateOrThrow();
        System.out.println("  rotations change shape; recoloring restores black-height invariants\n");
    }

    public static void main(String[] args) {
        run();
    }
}
