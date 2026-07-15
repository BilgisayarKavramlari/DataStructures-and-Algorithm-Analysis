/**
 * DataStructureSelectionCases
 *
 * Presents worked scenarios that map a problem's access pattern to the right
 * data structure. The skill being taught is matching required operations (and
 * their frequency) to a structure whose strengths align, rather than memorising
 * structures in isolation.
 *
 * Time complexity: O(1) printing per case. Space complexity: O(1).
 */
public class DataStructureSelectionCases {

    public void demonstrate() {
        System.out.println("Matching real scenarios to an appropriate data structure:");
        System.out.println();

        printCase("Look up a user by id, millions of times, order irrelevant",
                "Hash table",
                "expected O(1) lookup and insert; ordering is not needed");

        printCase("Always serve the highest-priority task next",
                "Binary heap (priority queue)",
                "O(1) peek-min/max and O(log n) insert and extract");

        printCase("Keep entries sorted and support range queries",
                "Balanced BST (red-black / AVL) or TreeMap",
                "O(log n) search plus in-order traversal for ranges");

        printCase("Undo history where only the most recent action is reverted",
                "Stack",
                "last-in first-out matches undo semantics, O(1) push/pop");

        printCase("Tasks processed strictly in arrival order",
                "Queue",
                "first-in first-out preserves arrival order, O(1) enqueue/dequeue");

        printCase("Detect whether two elements are in the same group, with merges",
                "Union-find (disjoint set)",
                "near O(1) amortized connectivity and union");

        printCase("Autocomplete by shared prefix",
                "Trie",
                "search proportional to key length, shares common prefixes");

        System.out.println();
        System.out.println("The structure follows from the operation mix, not the other way around.");
    }

    private void printCase(String scenario, String choice, String reason) {
        System.out.println("  scenario: " + scenario);
        System.out.println("    choose: " + choice);
        System.out.println("    because: " + reason);
        System.out.println();
    }
}
