public class SplayAmortizedIntuitionDemo {
    public static void run() {
        System.out.println("--- Splay amortized intuition ---");
        SplayTree tree = new SplayTree(false);
        for (int x : new int[]{5, 10, 15, 20, 25, 30, 35, 40}) tree.insert(x);
        int[] accesses = {5, 40, 5, 40, 20, 20, 20, 35, 35};
        tree.resetRotationCount();
        for (int key : accesses) {
            tree.access(key);
            System.out.println("access " + key + " -> root=" + tree.rootKey() + ", total rotations=" + tree.rotationCount());
        }
        System.out.println("A single operation can be expensive, but over a sequence the amortized cost is logarithmic.\n");
    }
}
