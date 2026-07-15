/**
 * DataStructureSelectionReview
 *
 * A rapid-fire review of selection decisions in the form of short prompts and
 * the reasoned answer, mirroring the style of exam questions that ask "which
 * structure and why". The goal is fluency in mapping requirements to structures.
 *
 * Time complexity: O(1) printing. Space complexity: O(1).
 */
public class DataStructureSelectionReview {

    public void demonstrate() {
        System.out.println("Selection review (prompt then justified answer):");
        System.out.println();

        qa("Need O(1) average membership tests, no ordering",
                "Hash set: expected constant-time contains and add");
        qa("Need the minimum element repeatedly removed",
                "Min-heap: O(1) peek, O(log n) extract-min");
        qa("Need to keep a sorted set with predecessor/successor queries",
                "Balanced BST / TreeSet: O(log n) navigation in key order");
        qa("Need to merge groups and test connectivity online",
                "Union-find: near-constant amortized union and find");
        qa("Need prefix-based key retrieval for autocomplete",
                "Trie: traversal cost proportional to key length");
        qa("Need stable sorting of records by a secondary key",
                "Merge sort: stable and guaranteed O(n log n)");
    }

    private void qa(String prompt, String answer) {
        System.out.println("  Q: " + prompt);
        System.out.println("  A: " + answer);
        System.out.println();
    }
}
