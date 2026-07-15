import java.util.ArrayDeque;
import java.util.Queue;

/**
 * BFS - breadth-first search
 *
 * Explores a graph in layers: all vertices at distance 1 from the source, then
 * distance 2, and so on. A FIFO queue holds the frontier and a visited array
 * prevents revisiting. On an unweighted graph BFS finds the fewest-edge path
 * from the source to every reachable vertex.
 *
 * Invariant: when a vertex is dequeued, its recorded distance is final and
 * minimal in edges.
 *
 * Time complexity: O(V + E). Space complexity: O(V) for the queue, visited,
 *   and distance arrays.
 */
public class BFS {

    public void demonstrate() {
        Graph g = new Graph(7, false);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(4, 6);

        int source = 0;
        System.out.println("Breadth-first search from vertex " + source + ":");
        boolean[] visited = new boolean[g.vertexCount()];
        int[] distance = new int[g.vertexCount()];
        Queue<Integer> queue = new ArrayDeque<>();

        visited[source] = true;
        queue.add(source);
        StringBuilder order = new StringBuilder();

        while (!queue.isEmpty()) {
            int v = queue.poll();
            order.append(v).append(" ");
            for (int next : g.neighbours(v)) {
                if (!visited[next]) {
                    visited[next] = true;
                    distance[next] = distance[v] + 1;
                    System.out.println("  discover " + next + " from " + v
                            + " at distance " + distance[next]);
                    queue.add(next);
                }
            }
        }

        System.out.println("  visit order: " + order.toString().trim());
        System.out.print("  distances from source: ");
        for (int v = 0; v < g.vertexCount(); v++) {
            System.out.print(v + ":" + distance[v] + " ");
        }
        System.out.println();
    }
}
