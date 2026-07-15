/**
 * SparseDenseGraphComparison
 *
 * Compares the space cost of the adjacency-list and adjacency-matrix
 * representations as a function of edge count, making concrete the rule of
 * thumb: use a list for sparse graphs and a matrix for dense graphs.
 *
 * The matrix always costs on the order of V^2 cells. The list costs on the
 * order of V + E references. The crossover is near E = V^2, i.e. when the graph
 * is dense.
 *
 * Time complexity: O(1) arithmetic per row printed. Space complexity: O(1).
 */
public class SparseDenseGraphComparison {

    public void demonstrate() {
        int v = 1000;
        System.out.println("Comparing storage for V = " + v + " vertices.");
        System.out.println("Matrix cost is fixed at V*V cells regardless of edges.");
        System.out.println();
        System.out.printf("%-14s %-16s %-18s %-12s%n",
                "edges", "matrixCells", "listReferences", "preferred");

        long matrixCells = (long) v * v;
        int[] edgeCounts = { 1000, 5000, 50000, 250000, 499500 };
        for (int e : edgeCounts) {
            long listRefs = (long) v + 2L * e;
            String preferred = listRefs < matrixCells ? "list" : "matrix";
            System.out.printf("%-14d %-16d %-18d %-12s%n",
                    e, matrixCells, listRefs, preferred);
        }

        System.out.println();
        System.out.println("Sparse graphs (few edges) strongly favour the adjacency list;");
        System.out.println("only near the dense limit does the matrix become competitive,");
        System.out.println("and the matrix still wins on O(1) edge-existence queries.");
    }
}
