/**
 * ComplexitySummaryDemo
 *
 * A consolidated reference of the headline complexities for the structures and
 * algorithms covered across the course, intended as a final selection aid: when
 * choosing, scan for the structure whose guaranteed bounds match the dominant
 * operation.
 *
 * Time complexity: O(1) printing. Space complexity: O(1).
 */
public class ComplexitySummaryDemo {

    public void demonstrate() {
        System.out.println("Course-wide complexity summary for quick selection:");
        System.out.println();

        System.out.println("Searching:");
        System.out.println("  hash table: O(1) expected, no order");
        System.out.println("  balanced BST: O(log n), ordered");
        System.out.println("  sorted array + binary search: O(log n), static");
        System.out.println();

        System.out.println("Priority access:");
        System.out.println("  binary heap: O(log n) insert / extract, O(1) peek");
        System.out.println("  pairing / Fibonacci heap: O(1) insert, fast decrease-key");
        System.out.println();

        System.out.println("Connectivity / grouping:");
        System.out.println("  union-find: near O(1) amortized union and find");
        System.out.println();

        System.out.println("Sorting:");
        System.out.println("  merge sort: O(n log n) stable");
        System.out.println("  quicksort: O(n log n) expected, in place");
        System.out.println("  counting / radix: O(n) for bounded integer keys");
        System.out.println();

        System.out.println("Graphs:");
        System.out.println("  BFS / DFS: O(V + E)");
        System.out.println("  Dijkstra: O((V + E) log V)");
        System.out.println("  Prim / Kruskal MST: O(E log E)");
        System.out.println();

        System.out.println("Match the dominant operation and any ordering requirement to this table,");
        System.out.println("and the appropriate structure usually selects itself.");
    }
}
