import java.util.*;

/** Topic checklist and runnable trace notes for instructor use. */
public class AdvancedTopicNotes {
    public static void showRequiredTopics() {
        String[] topics = TOPICS.split(", ");
        System.out.println("Visible lecture topics:");
        for (int i = 0; i < Math.min(topics.length, 10); i++) System.out.println("  - " + topics[i]);
        if (topics.length > 10) System.out.println("  - ... plus " + (topics.length - 10) + " additional related topics");
        System.out.println("Invariant prompt: state what must remain true after each update.");
        System.out.println("Edge case prompt: empty input, one item, duplicate keys, and worst-case order.");
    }
    static final String TOPICS = "variables, primitive types, references, arrays, loops, nested loops, methods, classes, objects, generics, Comparable, Comparator, timing, common mistakes";
}
