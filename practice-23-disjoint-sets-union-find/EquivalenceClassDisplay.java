import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * EquivalenceClassDisplay
 *
 * A disjoint-set structure partitions elements into equivalence classes: groups
 * that are mutually connected. This demo applies a sequence of unions and then
 * prints the resulting classes by grouping elements under their representative.
 *
 * Time complexity: O(n * alpha(n)) to group all elements. Space complexity: O(n).
 */
public class EquivalenceClassDisplay {

    public void demonstrate() {
        int n = 10;
        UnionFind uf = new UnionFind(n);
        int[][] pairs = { {1, 2}, {2, 3}, {4, 5}, {6, 7}, {7, 8}, {8, 9}, {3, 9} };

        System.out.println("Applying unions and displaying equivalence classes:");
        for (int[] p : pairs) {
            uf.union(p[0], p[1]);
            System.out.println("  union(" + p[0] + ", " + p[1] + ")");
        }

        Map<Integer, List<Integer>> classes = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            classes.computeIfAbsent(uf.find(i), k -> new ArrayList<>()).add(i);
        }

        System.out.println("  number of classes: " + uf.componentCount());
        int label = 1;
        for (List<Integer> group : classes.values()) {
            System.out.println("  class " + (label++) + ": " + group);
        }
    }
}
