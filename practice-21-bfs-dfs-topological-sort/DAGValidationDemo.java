/**
 * DAGValidationDemo
 *
 * Validates whether a directed graph is a DAG (directed acyclic graph) by
 * attempting a topological sort with Kahn's algorithm: a graph is a DAG exactly
 * when every vertex can be emitted. This reframes cycle detection as a
 * by-product of the ordering process.
 *
 * Time complexity: O(V + E). Space complexity: O(V).
 */
public class DAGValidationDemo {

    public void demonstrate() {
        System.out.println("Validating two directed graphs as DAGs via Kahn emission count.");
        System.out.println();

        Graph dag = new Graph(4, true);
        dag.addEdge(0, 1);
        dag.addEdge(1, 2);
        dag.addEdge(2, 3);
        System.out.println("Graph 1: 0->1->2->3");
        System.out.println("  is DAG: " + isDag(dag));

        Graph notDag = new Graph(4, true);
        notDag.addEdge(0, 1);
        notDag.addEdge(1, 2);
        notDag.addEdge(2, 3);
        notDag.addEdge(3, 1);
        System.out.println("Graph 2: 0->1->2->3->1 (extra back edge)");
        System.out.println("  is DAG: " + isDag(notDag));
    }

    private boolean isDag(Graph g) {
        int n = g.vertexCount();
        int[] indegree = new int[n];
        for (int u = 0; u < n; u++) {
            for (int v : g.neighbours(u)) {
                indegree[v]++;
            }
        }
        java.util.Deque<Integer> ready = new java.util.ArrayDeque<>();
        for (int v = 0; v < n; v++) {
            if (indegree[v] == 0) {
                ready.add(v);
            }
        }
        int emitted = 0;
        while (!ready.isEmpty()) {
            int v = ready.poll();
            emitted++;
            for (int next : g.neighbours(v)) {
                if (--indegree[next] == 0) {
                    ready.add(next);
                }
            }
        }
        return emitted == n;
    }
}
