import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * MazeGenerationDemo
 *
 * A classic application of union-find: generating a perfect maze. Treat each
 * cell as an element and each potential wall as an edge between adjacent cells.
 * Shuffle the walls; for each wall, if its two cells are in different sets,
 * remove the wall (knock it down) and union the cells. The maze is complete when
 * all cells form one set, guaranteeing exactly one path between any two cells.
 *
 * Invariant: cells in the same set are already mutually reachable, so removing a
 * wall between same-set cells would create a loop and is skipped.
 *
 * Time complexity: O(walls * alpha(cells)). Space complexity: O(cells + walls).
 */
public class MazeGenerationDemo {

    public void demonstrate() {
        int rows = 3;
        int cols = 4;
        int cells = rows * cols;
        UnionFind uf = new UnionFind(cells);

        List<int[]> walls = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int id = r * cols + c;
                if (c + 1 < cols) {
                    walls.add(new int[] { id, id + 1 });
                }
                if (r + 1 < rows) {
                    walls.add(new int[] { id, id + cols });
                }
            }
        }
        Collections.shuffle(walls, new java.util.Random(1));

        System.out.println("Generating a " + rows + "x" + cols + " perfect maze with union-find.");
        System.out.println("Removing a wall only when it joins two separate regions:");
        int removed = 0;
        for (int[] wall : walls) {
            if (uf.union(wall[0], wall[1])) {
                removed++;
                System.out.println("  knock down wall between cell " + wall[0]
                        + " and cell " + wall[1]);
            }
        }

        System.out.println("  walls removed: " + removed + " (always cells - 1 = " + (cells - 1) + ")");
        System.out.println("  remaining regions: " + uf.componentCount()
                + " (1 means fully connected)");
        System.out.println("  exactly cells-1 removals with no loops yields a perfect maze.");
    }
}
