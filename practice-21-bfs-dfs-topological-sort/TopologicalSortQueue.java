import java.util.ArrayDeque;
import java.util.Queue;

/**
 * TopologicalSortQueue
 *
 * Kahn's algorithm using a queue of zero-in-degree vertices. Initializing the
 * queue with every source, then releasing a vertex's successors as it is
 * emitted, yields an O(V + E) topological order and simultaneously detects
 * cycles (if fewer than V vertices are emitted, a cycle exists).
 *
 * Invariant: the queue holds exactly the vertices whose predecessors are all
 * already emitted.
 *
 * Time complexity: O(V + E). Space complexity: O(V) for the queue and in-degree
 *   array.
 */
public class TopologicalSortQueue {

    public void demonstrate() {
        int n = 6;
        Graph g = new Graph(n, true);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        int[] indegree = new int[n];
        for (int u = 0; u < n; u++) {
            for (int v : g.neighbours(u)) {
                indegree[v]++;
            }
        }

        Queue<Integer> ready = new ArrayDeque<>();
        for (int v = 0; v < n; v++) {
            if (indegree[v] == 0) {
                ready.add(v);
            }
        }

        System.out.println("Kahn's algorithm with a queue of ready vertices:");
        System.out.println("  initial zero-in-degree set: " + ready);
        StringBuilder order = new StringBuilder();
        int emitted = 0;

        while (!ready.isEmpty()) {
            int v = ready.poll();
            order.append(v).append(" ");
            emitted++;
            for (int next : g.neighbours(v)) {
                if (--indegree[next] == 0) {
                    ready.add(next);
                }
            }
        }

        if (emitted < n) {
            System.out.println("  only " + emitted + " of " + n + " emitted: cycle present");
        } else {
            System.out.println("  topological order: " + order.toString().trim());
        }
    }
}
