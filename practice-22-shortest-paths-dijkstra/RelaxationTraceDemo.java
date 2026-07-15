/**
 * RelaxationTraceDemo
 *
 * Isolates the single most important operation in shortest-path algorithms:
 * edge relaxation. Relaxing edge (u, v, w) asks whether the known route to u
 * plus w beats the shortest known route to v, and if so improves v's estimate.
 * Every Dijkstra and Bellman-Ford step is just repeated relaxation.
 *
 * Time complexity: O(1) per relaxation. Space complexity: O(V) for the estimate
 *   array.
 */
public class RelaxationTraceDemo {

    private static final int INF = Integer.MAX_VALUE;

    public void demonstrate() {
        System.out.println("Edge relaxation updates a distance estimate when a shorter route appears.");
        System.out.println();

        int[] dist = { 0, INF, INF, INF };
        System.out.println("  start: dist = " + show(dist));

        relax(dist, 0, 1, 7);
        relax(dist, 0, 2, 2);
        relax(dist, 2, 1, 3);
        relax(dist, 1, 3, 1);

        System.out.println();
        System.out.println("Notice 0->2->1 (cost 5) overrides the direct 0->1 (cost 7):");
        System.out.println("  final: dist = " + show(dist));
    }

    private void relax(int[] dist, int u, int v, int w) {
        if (dist[u] != INF && dist[u] + w < dist[v]) {
            int old = dist[v];
            dist[v] = dist[u] + w;
            System.out.println("  relax (" + u + " -> " + v + ", w=" + w + "): dist[" + v
                    + "] " + showValue(old) + " -> " + dist[v]);
        } else {
            System.out.println("  relax (" + u + " -> " + v + ", w=" + w
                    + "): no improvement");
        }
    }

    private String show(int[] dist) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < dist.length; i++) {
            sb.append(showValue(dist[i]));
            if (i < dist.length - 1) {
                sb.append(", ");
            }
        }
        return sb.append("]").toString();
    }

    private String showValue(int value) {
        return value == INF ? "INF" : String.valueOf(value);
    }
}
