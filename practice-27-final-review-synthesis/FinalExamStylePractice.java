/**
 * FinalExamStylePractice
 *
 * Poses a handful of exam-style questions spanning the whole course and prints
 * worked answers. The questions target the reasoning the course aims to build:
 * choosing structures, deriving complexities, and explaining algorithm
 * behaviour, rather than rote recall.
 *
 * Time complexity: O(1) printing. Space complexity: O(1).
 */
public class FinalExamStylePractice {

    public void demonstrate() {
        System.out.println("Final exam style questions with worked answers:");
        System.out.println();

        question("1. Why is a hash table's worst-case search O(n) despite O(1) average?",
                "All keys can collide into one bucket, degrading to a linear scan;"
                + " good hashing and load-factor control keep this rare.");

        question("2. When does quicksort hit O(n^2), and how is it avoided?",
                "On consistently poor pivots (e.g. sorted input with a fixed pivot);"
                + " random or median-of-three pivots make it improbable.");

        question("3. Give the recurrence for merge sort and its solution.",
                "T(n) = 2T(n/2) + O(n), which by the master theorem is O(n log n).");

        question("4. Why does Dijkstra fail with negative edges?",
                "It finalises a vertex on first pop assuming no cheaper later path;"
                + " a negative edge can violate this. Use Bellman-Ford instead.");

        question("5. What makes a balanced BST preferable to a hash table sometimes?",
                "It keeps keys ordered, enabling range queries and"
                + " predecessor/successor lookups that a hash table cannot.");

        question("6. State the amortized cost of union-find with both optimizations.",
                "Near O(1) per operation, specifically the inverse Ackermann"
                + " function with union by rank and path compression.");

        System.out.println("These questions reward reasoning about trade-offs, the core course skill.");
    }

    private void question(String q, String a) {
        System.out.println("  " + q);
        System.out.println("    Answer: " + a);
        System.out.println();
    }
}
