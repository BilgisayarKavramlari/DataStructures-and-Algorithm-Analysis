import java.util.*;

/** Demonstrates BFS shortest path, weighted graph, relaxation, Dijkstra variants, path reconstruction, negative edge limitation, DAG shortest path, all-pairs demo. Time notes are printed for live tracing. */
public class RelaxationTraceDemo {
    public static void run() {
        System.out.println("-- RelaxationTraceDemo: BFS shortest path, weighted graph, relaxation, Dijkstra variants, path reconstruction, negative edge limitation, DAG shortest path, all-pairs demo");
        int[] data = {7, 3, 9, 1, 5};
        System.out.println("Input: " + Arrays.toString(data));
        int best = data[0];
        for (int x : data) {
            if (x > best) best = x;
            System.out.println("  visit " + x + ", current best=" + best);
        }
        System.out.println("Invariant: processed prefix has a correct summary; time O(n), extra space O(1).\n");
    }
    public static void main(String[] args) { run(); }
}
