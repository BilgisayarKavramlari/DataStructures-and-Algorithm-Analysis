public class ZigDemo {
    public static void run() {
        System.out.println("--- Splay zig case ---");
        SplayTree tree = new SplayTree(true);
        tree.insert(10);
        tree.insert(5); // 5 is child of root; splaying uses one rotation
        System.out.println("root after accessing/inserting 5: " + tree.rootKey());
        tree.printTree();
        System.out.println();
    }
}
