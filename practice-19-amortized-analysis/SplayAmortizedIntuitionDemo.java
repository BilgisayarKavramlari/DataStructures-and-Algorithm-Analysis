/**
 * SplayAmortizedIntuitionDemo
 *
 * Gives intuition for why splay-tree operations are amortized O(log n) even
 * though a single access can take O(n) on a degenerate tree. Splaying the
 * accessed node to the root roughly halves the depth of the nodes along the
 * access path, so a deep, expensive access is always followed by a structure
 * that is much cheaper to search.
 *
 * We model this with a simple path-length proxy: repeatedly access the deepest
 * element of a worst-case "stick" shaped tree and watch the modeled access cost
 * fall sharply after each splay, then level off.
 *
 * Time complexity of the simulation: O(accesses). Space complexity: O(1).
 */
public class SplayAmortizedIntuitionDemo {

    public void demonstrate() {
        System.out.println("Modeling repeated deep accesses on an initially stick-shaped tree.");
        System.out.println("Splaying halves the access path, so later accesses get cheaper.");
        System.out.println();
        System.out.printf("%-10s %-14s%n", "access", "modeledDepth");

        int depth = 32;
        for (int access = 1; access <= 8; access++) {
            System.out.printf("%-10d %-14d%n", access, depth);
            depth = Math.max(1, depth / 2);
        }

        System.out.println();
        System.out.println("A worst-case access can be costly once, but the splay that follows");
        System.out.println("flattens the path, spreading the cost so the amortized bound is O(log n).");
    }
}
