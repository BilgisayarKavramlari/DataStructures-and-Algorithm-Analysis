/** Demonstrates why postorder is useful for computing directory sizes. */
public class PostorderSizeCalculationDemo {
    private static int totalSize(DirectoryTreeDemo.Entry entry) {
        int total = entry.fileSize;
        for (DirectoryTreeDemo.Entry child : entry.children) {
            total += totalSize(child);
        }
        System.out.println("computed total size for " + entry.name + " = " + total);
        return total;
    }

    public static void run() {
        System.out.println("--- Postorder size calculation ---");
        DirectoryTreeDemo.Entry root = DirectoryTreeDemo.sample();
        int total = totalSize(root);
        System.out.println("Final total size = " + total);
        System.out.println("Teaching note: parent totals are computed after child totals, which is postorder logic.\n");
    }
}
