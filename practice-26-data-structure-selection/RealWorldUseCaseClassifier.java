/**
 * RealWorldUseCaseClassifier
 *
 * A tiny rule-based helper that, given a short profile of an application's
 * needs (ordering required, dominant operation, key type), recommends a data
 * structure. It models how an engineer reasons from requirements to a choice.
 *
 * Time complexity: O(1) per classification. Space complexity: O(1).
 */
public class RealWorldUseCaseClassifier {

    public void demonstrate() {
        System.out.println("Classifying applications from their requirement profile:");
        System.out.println();

        classify("LRU cache", false, "lookup-and-evict", "integer");
        classify("Leaderboard with ranks", true, "ordered-range", "score");
        classify("Spell-checker dictionary", false, "membership", "word");
        classify("Event simulation by time", true, "extract-min", "timestamp");
        classify("Browser back button", false, "lifo", "page");
    }

    private void classify(String app, boolean ordered, String dominant, String keyType) {
        String recommendation;
        if ("lifo".equals(dominant)) {
            recommendation = "Stack";
        } else if ("extract-min".equals(dominant)) {
            recommendation = "Binary heap / priority queue";
        } else if ("ordered-range".equals(dominant) || ordered) {
            recommendation = "Balanced BST / TreeMap";
        } else if ("membership".equals(dominant) && "word".equals(keyType)) {
            recommendation = "Trie or hash set";
        } else {
            recommendation = "Hash table";
        }
        System.out.println("  " + app + " (ordered=" + ordered + ", op=" + dominant
                + ", key=" + keyType + ")");
        System.out.println("    -> " + recommendation);
        System.out.println();
    }
}
