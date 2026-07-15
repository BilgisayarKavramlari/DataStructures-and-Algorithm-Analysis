/**
 * TraversalTraceDemo
 *
 * Places breadth-first and depth-first orders side by side on the same graph so
 * the contrast is explicit: BFS fans out level by level while DFS plunges deep
 * before backtracking. Seeing both from the same source clarifies which problem
 * each traversal suits.
 *
 * Time complexity: O(V + E) per traversal. Space complexity: O(V).
 */
public class TraversalTraceDemo {

    public void demonstrate() {
        Graph g = new Graph(7, false);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(2, 6);

        System.out.println("Same tree-shaped graph, two traversal orders from vertex 0:");
        System.out.println("  BFS (level by level): " + bfsOrder(g, 0));
        System.out.println("  DFS (deep first):     " + dfsOrder(g, 0));
        System.out.println();
        System.out.println("BFS reaches 1 and 2 before any grandchild; DFS dives into 1's");
        System.out.println("subtree entirely before visiting 2.");
    }

    private String bfsOrder(Graph g, int source) {
        boolean[] visited = new boolean[g.vertexCount()];
        java.util.Queue<Integer> queue = new java.util.ArrayDeque<>();
        visited[source] = true;
        queue.add(source);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int v = queue.poll();
            sb.append(v).append(" ");
            for (int next : g.neighbours(v)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        return sb.toString().trim();
    }

    private String dfsOrder(Graph g, int source) {
        boolean[] visited = new boolean[g.vertexCount()];
        StringBuilder sb = new StringBuilder();
        dfs(g, source, visited, sb);
        return sb.toString().trim();
    }

    private void dfs(Graph g, int v, boolean[] visited, StringBuilder sb) {
        visited[v] = true;
        sb.append(v).append(" ");
        for (int next : g.neighbours(v)) {
            if (!visited[next]) {
                dfs(g, next, visited, sb);
            }
        }
    }
}
