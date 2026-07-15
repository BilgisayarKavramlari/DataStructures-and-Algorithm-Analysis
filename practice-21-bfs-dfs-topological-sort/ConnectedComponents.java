import java.util.ArrayList;
import java.util.List;

/**
 * ConnectedComponents
 *
 * Counts and labels the connected components of an undirected graph by running
 * a depth-first traversal from each not-yet-visited vertex. Every traversal
 * paints one full component before the next starts.
 *
 * Invariant: vertices sharing a component receive the same component id.
 *
 * Time complexity: O(V + E). Space complexity: O(V) for the component-id array
 *   and recursion.
 */
public class ConnectedComponents {

    private Graph graph;
    private int[] componentId;

    public void demonstrate() {
        graph = new Graph(8, false);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);
        graph.addEdge(5, 7);

        componentId = new int[graph.vertexCount()];
        for (int v = 0; v < graph.vertexCount(); v++) {
            componentId[v] = -1;
        }

        int components = 0;
        System.out.println("Labeling connected components of an 8-vertex graph:");
        for (int v = 0; v < graph.vertexCount(); v++) {
            if (componentId[v] == -1) {
                paint(v, components);
                components++;
            }
        }

        System.out.println("  number of components: " + components);
        List<List<Integer>> grouped = new ArrayList<>();
        for (int c = 0; c < components; c++) {
            grouped.add(new ArrayList<>());
        }
        for (int v = 0; v < graph.vertexCount(); v++) {
            grouped.get(componentId[v]).add(v);
        }
        for (int c = 0; c < components; c++) {
            System.out.println("  component " + c + ": " + grouped.get(c));
        }
    }

    private void paint(int vertex, int id) {
        componentId[vertex] = id;
        for (int next : graph.neighbours(vertex)) {
            if (componentId[next] == -1) {
                paint(next, id);
            }
        }
    }
}
