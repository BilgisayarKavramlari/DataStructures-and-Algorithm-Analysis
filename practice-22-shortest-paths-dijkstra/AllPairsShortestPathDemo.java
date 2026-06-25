/**
 * AllPairsShortestPathDemo
 *
 * The Floyd-Warshall algorithm computes shortest distances between every pair
 * of vertices. It builds the answer by allowing one more intermediate vertex k
 * at a time: dist[i][j] is improved whenever routing through k is shorter. Its
 * triple loop is short to write and works with negative edges (but not negative
 * cycles).
 *
 * Invariant: after processing intermediates 0..k, dist[i][j] is the shortest
 * path using only those vertices as intermediates.
 *
 * Time complexity: O(V^3). Space complexity: O(V^2).
 */
public class AllPairsShortestPathDemo {

    private static final int INF = 1_000_000;

    public void demonstrate() {
        int n = 4;
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = (i == j) ? 0 : INF;
            }
        }
        addEdge(dist, 0, 1, 3);
        addEdge(dist, 0, 3, 7);
        addEdge(dist, 1, 0, 8);
        addEdge(dist, 1, 2, 2);
        addEdge(dist, 2, 0, 5);
        addEdge(dist, 2, 3, 1);
        addEdge(dist, 3, 0, 2);

        System.out.println("Floyd-Warshall all-pairs shortest paths.");
        System.out.println("Improving paths by allowing each vertex k as an intermediate:");

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
            System.out.println("  after allowing intermediates through " + k + " done");
        }

        System.out.println("Final distance matrix:");
        System.out.print("      ");
        for (int j = 0; j < n; j++) {
            System.out.printf("%5d", j);
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.printf("  %2d  ", i);
            for (int j = 0; j < n; j++) {
                System.out.printf("%5s", dist[i][j] >= INF ? "INF" : dist[i][j]);
            }
            System.out.println();
        }
    }

    private void addEdge(int[][] dist, int u, int v, int w) {
        dist[u][v] = w;
    }
}
