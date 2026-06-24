public class SplayLocalityExperiment {
    public static void run() {
        System.out.println("--- Splay locality experiment ---");
        SplayTree tree = new SplayTree(false);
        for (int x : new int[]{10, 20, 30, 40, 50, 60, 70}) tree.insert(x);
        tree.resetRotationCount();
        for (int i = 1; i <= 5; i++) {
            tree.access(40);
            System.out.println("access #" + i + " to 40 -> root=" + tree.rootKey() + ", total rotations=" + tree.rotationCount());
        }
        System.out.println("After the first access, repeated access to 40 becomes cheap because it is at the root.\n");
    }
}
