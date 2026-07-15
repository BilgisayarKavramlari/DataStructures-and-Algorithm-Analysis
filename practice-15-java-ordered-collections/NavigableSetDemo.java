import java.util.TreeSet;

/**
 * NavigableSetDemo
 *
 * Demonstrates the navigation methods a TreeSet provides as a NavigableSet:
 * floor, ceiling, lower, higher, and bounded range views. These answer
 * "nearest neighbour" questions in O(log n) using the tree structure.
 *
 * Time complexity: O(log n) per navigation query.
 */
public class NavigableSetDemo {

    public void demonstrate() {
        TreeSet<Integer> set = new TreeSet<>();
        for (int v = 10; v <= 90; v += 10) {
            set.add(v);
        }
        System.out.println("Set: " + set);
        System.out.println("floor(55)   = " + set.floor(55)
                + "  (largest element <= 55)");
        System.out.println("ceiling(55) = " + set.ceiling(55)
                + "  (smallest element >= 55)");
        System.out.println("lower(50)   = " + set.lower(50)
                + "  (largest element strictly < 50)");
        System.out.println("higher(50)  = " + set.higher(50)
                + "  (smallest element strictly > 50)");
        System.out.println("headSet(50) = " + set.headSet(50));
        System.out.println("tailSet(50) = " + set.tailSet(50));
        System.out.println("subSet(30,70) = " + set.subSet(30, 70));
        System.out.println("These nearest-neighbour queries are why a sorted set beats a hash set here.");
    }
}
