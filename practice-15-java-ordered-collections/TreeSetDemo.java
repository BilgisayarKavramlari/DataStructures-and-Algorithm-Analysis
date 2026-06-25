import java.util.TreeSet;

/**
 * TreeSetDemo
 *
 * Demonstrates TreeSet, a sorted set backed by a balanced (red-black) tree. It
 * keeps elements in sorted order and supports O(log n) add, remove, and
 * contains. Duplicates are rejected because it is a set.
 *
 * Time complexity: O(log n) per operation; iteration is O(n) in sorted order.
 */
public class TreeSetDemo {

    public void demonstrate() {
        TreeSet<Integer> set = new TreeSet<>();
        int[] data = {50, 20, 80, 20, 10, 60, 30};
        for (int x : data) {
            set.add(x);
        }
        System.out.println("Inserted values (with a duplicate 20).");
        System.out.println("Iteration is automatically sorted: " + set);
        System.out.println("Smallest element (first): " + set.first());
        System.out.println("Largest element (last)  : " + set.last());
        System.out.println("Contains 60? " + set.contains(60));
        set.remove(60);
        System.out.println("After removing 60       : " + set);
        System.out.println("A TreeSet keeps order at all times, unlike a HashSet.");
    }
}
