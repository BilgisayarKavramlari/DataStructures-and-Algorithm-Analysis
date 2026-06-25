/**
 * DFSRecursive - depth-first search (recursive)
 *
 * Explores as far as possible along each branch before backtracking, using the
 * call stack to remember where to resume. Prints discovery and finish events to
 * make the recursion structure visible.
 *
 * Invariant: a vertex is marked visited the moment it is discovered, so each
 * vertex is entered exactly once.
 *
 * Time complexity: O(V + E). Space complexity: O(V) for the visited array plus
 *   the recursion stack, up to O(V) deep.
 */
public class DFSRecursive {

    private boolean[] visited;
    private Graph graph;

    public void demonstrate() {
        graph = new Graph(7, false);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);

        visited = new boolean[graph.vertexCount()];
        System.out.println("Recursive depth-first search from vertex 0:");
        dfs(0, 0);
    }

    private void dfs(int vertex, int depth) {
        visited[vertex] = true;
        System.out.println("  " + indent(depth) + "enter " + vertex);
        for (int next : graph.neighbours(vertex)) {
            if (!visited[next]) {
                dfs(next, depth + 1);
            }
        }
        System.out.println("  " + indent(depth) + "finish " + vertex);
    }

    private String indent(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("  ");
        }
        return sb.toString();
    }
}
