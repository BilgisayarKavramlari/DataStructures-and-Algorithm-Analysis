import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * JavaHashMapHashSetDemo
 *
 * Purpose:
 *   Shows how the Java standard library implements the hash-table abstraction
 *   through HashMap and HashSet, so students can connect the hand-written
 *   tables in this folder to the production-quality structures they will
 *   actually use.
 *
 * Key teaching points:
 *   - HashMap stores key/value pairs; HashSet stores unique keys only and is
 *     internally backed by a HashMap.
 *   - Average-case time complexity for get/put/containsKey is O(1) when the
 *     hashCode is well distributed; worst case degrades to O(log n) in modern
 *     JDKs because long collision chains are converted into balanced trees.
 *   - Iteration order is not specified and must never be relied upon.
 *
 * Space complexity: O(n) for n stored entries plus the backing array.
 */
public class JavaHashMapHashSetDemo {

    public void demonstrate() {
        demonstrateHashMap();
        demonstrateHashSet();
        demonstrateGetOrDefaultAndMerge();
    }

    private void demonstrateHashMap() {
        System.out.println("HashMap as a key/value dictionary:");
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("apple", 12);
        inventory.put("banana", 7);
        inventory.put("cherry", 30);

        System.out.println("  put apple=12, banana=7, cherry=30");
        System.out.println("  get(banana)        -> " + inventory.get("banana"));
        System.out.println("  containsKey(mango) -> " + inventory.containsKey("mango"));

        inventory.put("banana", 9);
        System.out.println("  put banana=9 (overwrites existing key)");
        System.out.println("  get(banana)        -> " + inventory.get("banana"));

        inventory.remove("apple");
        System.out.println("  remove(apple)");
        System.out.println("  containsKey(apple) -> " + inventory.containsKey("apple"));
        System.out.println("  size               -> " + inventory.size());
    }

    private void demonstrateHashSet() {
        System.out.println();
        System.out.println("HashSet for membership and duplicate elimination:");
        Set<String> seen = new HashSet<>();
        String[] words = { "tree", "graph", "tree", "heap", "graph", "tree" };

        for (String word : words) {
            boolean added = seen.add(word);
            System.out.println("  add(" + word + ") -> " + (added ? "inserted" : "already present"));
        }
        System.out.println("  distinct elements: " + seen.size());
    }

    private void demonstrateGetOrDefaultAndMerge() {
        System.out.println();
        System.out.println("Frequency counting with getOrDefault and merge:");
        String sentence = "the cat sat on the mat the cat ran";
        Map<String, Integer> counts = new HashMap<>();

        for (String token : sentence.split(" ")) {
            counts.merge(token, 1, Integer::sum);
        }

        for (String key : new String[] { "the", "cat", "dog" }) {
            System.out.println("  count(" + key + ") = " + counts.getOrDefault(key, 0));
        }
    }
}
