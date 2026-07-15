public class ZigZigDemo {
    public static void run() {
        System.out.println("--- Splay zig-zig case ---");
        SplayTree tree = new SplayTree(true);
        for (int x : new int[]{30, 20, 10}) tree.insert(x);
        System.out.println("root after LL zig-zig sequence: " + tree.rootKey());
        tree.printTree();
        System.out.println();
    }
}
