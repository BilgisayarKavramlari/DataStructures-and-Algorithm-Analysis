/**
 * This is an executable concept trace for red-black deletion.
 * Full deletion is longer than insertion, so this demo focuses on the cases
 * students must recognize: double-black, red sibling, black sibling with black
 * children, and restructuring when a sibling has a red child.
 */
public class RedBlackDeletionConceptDemo {
    public static void run() {
        System.out.println("--- Red-black deletion concept trace ---");
        String[] cases = {
            "1. Delete a black leaf: the missing black creates a double-black position.",
            "2. If sibling is red: rotate parent toward double-black and recolor to get a black sibling case.",
            "3. If sibling is black with two black children: recolor sibling red and propagate double-black upward.",
            "4. If sibling is black with a red near child: rotate sibling to convert to far-child case.",
            "5. If sibling is black with a red far child: rotate parent, recolor, and eliminate double-black."
        };
        for (String c : cases) System.out.println(c);
        System.out.println("Teaching note: deletion is case analysis that preserves equal black height on every path.\n");
    }
}
