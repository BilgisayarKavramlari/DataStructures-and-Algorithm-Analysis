import java.util.ArrayList;
import java.util.List;

/**
 * BacktrackingSubsetsDemo
 *
 * Backtracking explores a decision tree, extending a partial solution and
 * undoing the last choice when a branch is exhausted. Generating all subsets is
 * the simplest instance: at each element decide include or exclude, recurse, and
 * on return remove the element to restore state for the sibling branch.
 *
 * Invariant: the 'current' list always holds the choices made along the active
 * root-to-node path; it is restored exactly on backtrack.
 *
 * Time complexity: O(n * 2^n) to build and print all 2^n subsets. Space
 *   complexity: O(n) recursion depth.
 */
public class BacktrackingSubsetsDemo {

    private final List<List<Integer>> allSubsets = new ArrayList<>();

    public void demonstrate() {
        int[] elements = { 1, 2, 3 };
        System.out.println("Generating every subset of " + java.util.Arrays.toString(elements)
                + " by backtracking.");
        backtrack(elements, 0, new ArrayList<>());

        System.out.println("  subsets found (" + allSubsets.size() + " total):");
        for (List<Integer> subset : allSubsets) {
            System.out.println("    " + subset);
        }
        System.out.println("  count is 2^" + elements.length + " = "
                + (1 << elements.length) + ", as expected.");
    }

    private void backtrack(int[] elements, int index, List<Integer> current) {
        if (index == elements.length) {
            allSubsets.add(new ArrayList<>(current));
            return;
        }
        backtrack(elements, index + 1, current);
        current.add(elements[index]);
        backtrack(elements, index + 1, current);
        current.remove(current.size() - 1);
    }
}
