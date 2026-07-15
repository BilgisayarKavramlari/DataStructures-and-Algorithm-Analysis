import java.util.ArrayList;
import java.util.List;

/** Shows a directory tree, a common application of general trees. */
public class DirectoryTreeDemo {
    static class Entry {
        String name;
        int fileSize; // zero for directories
        List<Entry> children = new ArrayList<>();

        Entry(String name, int fileSize) { this.name = name; this.fileSize = fileSize; }
        Entry add(String name, int size) { Entry e = new Entry(name, size); children.add(e); return e; }
        boolean isDirectory() { return !children.isEmpty(); }
    }

    static Entry sample() {
        Entry root = new Entry("course", 0);
        Entry module = root.add("module-3-trees", 0);
        module.add("slides.pdf", 120);
        module.add("tree-demo.java", 25);
        Entry practice = root.add("practice", 0);
        practice.add("bst.java", 40);
        practice.add("avl.java", 55);
        return root;
    }

    static void print(Entry e, String indent) {
        String kind = e.isDirectory() ? "dir" : "file";
        System.out.println(indent + e.name + " (" + kind + ", own size=" + e.fileSize + ")");
        for (Entry child : e.children) print(child, indent + "  ");
    }

    public static void run() {
        System.out.println("--- Directory tree example ---");
        Entry root = sample();
        print(root, "");
        System.out.println("Directories are naturally represented as trees; children are files or subdirectories.\n");
    }
}
