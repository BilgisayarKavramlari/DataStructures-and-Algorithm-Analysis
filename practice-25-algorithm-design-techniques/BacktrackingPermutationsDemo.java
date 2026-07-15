import java.util.ArrayList;
import java.util.List;

/**
 * BacktrackingPermutationsDemo
 *
 * Generates all permutations of a set by backtracking: choose an unused element
 * for the next position, recurse, then mark it unused again before trying the
 * next candidate. The used[] flags enforce that each element appears once per
 * permutation.
 *
 * Invariant: used[i] is true exactly while element i sits in the current partial
 * permutation; it is cleared on backtrack.
 *
 * Time complexity: O(n * n!) to build and print all n! permutations. Space
 *   complexity: O(n) for the recursion and flags.
 */
public class BacktrackingPermutationsDemo {

    private final List<List<Integer>> permutations = new ArrayList<>();

    public void demonstrate() {
        int[] elements = { 1, 2, 3 };
        System.out.println("Generating every permutation of " + java.util.Arrays.toString(elements)
                + " by backtracking.");
        boolean[] used = new boolean[elements.length];
        backtrack(elements, used, new ArrayList<>());

        System.out.println("  permutations found (" + permutations.size() + " total):");
        for (List<Integer> perm : permutations) {
            System.out.println("    " + perm);
        }
        System.out.println("  count is " + elements.length + "! = "
                + factorial(elements.length) + ", as expected.");
    }

    private void backtrack(int[] elements, boolean[] used, List<Integer> current) {
        if (current.size() == elements.length) {
            permutations.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < elements.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            current.add(elements[i]);
            backtrack(elements, used, current);
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }

    private int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
