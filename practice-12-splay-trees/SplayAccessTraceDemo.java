public class SplayAccessTraceDemo {
    public static void run() {
        System.out.println("--- Splay access trace ---");
        SplayTree tree = new SplayTree(true);
        for (int x : new int[]{50, 30, 70, 20, 40, 60, 80}) tree.insert(x);
        tree.resetRotationCount();
        System.out.println("access 20");
        tree.access(20);
        System.out.println("root=" + tree.rootKey() + ", rotations=" + tree.rotationCount());
        tree.printTree();
        System.out.println("Splaying moves recently accessed items close to the root.\n");
    }
}
