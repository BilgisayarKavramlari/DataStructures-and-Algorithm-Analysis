import java.util.ArrayDeque;
import java.util.Deque;

/**
 * DFSIterative - depth-first search using an explicit stack
 *
 * Reproduces depth-first traversal without recursion by managing the stack
 * manually. This is the form to use when recursion depth could overflow the
 * call stack on very large graphs.
 *
 * Invariant: a vertex is processed at most once; the visited check happens when
 * a vertex is popped, so duplicate stack entries are harmless.
 *
 * Time complexity: O(V + E). Space complexity: O(V) for the stack and visited
 *   array.
 */
public class DFSIterative {

    public void demonstrate() {
        Graph g = new Graph(7, false);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(4, 6);

        boolean[] visited = new boolean[g.vertexCount()];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        System.out.println("Iterative depth-first search from vertex 0:");
        StringBuilder order = new StringBuilder();

        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (visited[v]) {
                continue;
            }
            visited[v] = true;
            order.append(v).append(" ");
            System.out.println("  visit " + v);
            java.util.List<Integer> nbrs = g.neighbours(v);
            for (int i = nbrs.size() - 1; i >= 0; i--) {
                int next = nbrs.get(i);
                if (!visited[next]) {
                    stack.push(next);
                }
            }
        }
        System.out.println("  visit order: " + order.toString().trim());
    }
}
