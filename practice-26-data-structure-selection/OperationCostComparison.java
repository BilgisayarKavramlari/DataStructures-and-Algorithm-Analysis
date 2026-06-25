/**
 * OperationCostComparison
 *
 * Tabulates the asymptotic cost of the core operations across the main data
 * structures, so a selection decision can be read off directly. Seeing the
 * trade-offs side by side is more instructive than any single structure's
 * analysis.
 *
 * Time complexity: O(1) printing. Space complexity: O(1).
 */
public class OperationCostComparison {

    public void demonstrate() {
        System.out.println("Asymptotic cost of common operations (average case):");
        System.out.println();
        System.out.printf("  %-22s %-12s %-12s %-12s %-12s%n",
                "structure", "search", "insert", "delete", "ordered?");
        row("Array (unsorted)", "O(n)", "O(1)*", "O(n)", "no");
        row("Sorted array", "O(log n)", "O(n)", "O(n)", "yes");
        row("Linked list", "O(n)", "O(1)", "O(1)**", "no");
        row("Hash table", "O(1)", "O(1)", "O(1)", "no");
        row("Balanced BST", "O(log n)", "O(log n)", "O(log n)", "yes");
        row("Binary heap", "O(n)", "O(log n)", "O(log n)***", "partial");
        row("Trie", "O(L)", "O(L)", "O(L)", "yes (lexical)");

        System.out.println();
        System.out.println("  *   amortized for a dynamic array append");
        System.out.println("  **  given a reference to the node");
        System.out.println("  *** delete refers to extract-min / extract-max");
        System.out.println("  L = key length for tries");
    }

    private void row(String name, String search, String insert, String delete, String ordered) {
        System.out.printf("  %-22s %-12s %-12s %-12s %-12s%n",
                name, search, insert, delete, ordered);
    }
}
