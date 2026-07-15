import java.util.TreeMap;

/**
 * TreeMapDemo
 *
 * Demonstrates TreeMap, a sorted map keyed by a balanced tree. Keys are kept in
 * order, so range views and ordered iteration come for free. Here it counts word
 * frequencies and reports them alphabetically.
 *
 * Time complexity: O(log n) per put/get; ordered iteration is O(n).
 */
public class TreeMapDemo {

    public void demonstrate() {
        String[] words = {"delta", "alpha", "charlie", "alpha", "bravo", "delta", "alpha"};
        TreeMap<String, Integer> counts = new TreeMap<>();
        for (String w : words) {
            counts.merge(w, 1, Integer::sum);
        }
        System.out.println("Word frequencies in key order:");
        for (var entry : counts.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println("First key: " + counts.firstKey()
                + ", last key: " + counts.lastKey());
        System.out.println("TreeMap iterates keys in sorted order without an extra sort step.");
    }
}
