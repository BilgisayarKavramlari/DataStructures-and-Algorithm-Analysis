public class ZigZagDemo {
    public static void run() {
        System.out.println("--- Splay zig-zag case ---");
        SplayTree tree = new SplayTree(true);
        tree.insert(30);
        tree.insert(10);
        tree.insert(20); // creates a left-right pattern before splay
        System.out.println("root after LR zig-zag sequence: " + tree.rootKey());
        tree.printTree();
        System.out.println();
    }
}
