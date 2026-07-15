/**
 * Main - Practice 24: Minimum Spanning Trees
 *
 * Demonstrates Prim's and Kruskal's algorithms on a shared graph (printing the
 * selected edges and total weight), confirms the two agree, distinguishes an
 * MST from a shortest-path tree, and shows the minimum spanning forest of a
 * disconnected graph.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("==== Practice 24: Minimum Spanning Trees ====");
        run("Prim's algorithm", new PrimMST()::demonstrate);
        run("Kruskal's algorithm", new KruskalMST()::demonstrate);
        run("Prim vs Kruskal agreement", new MSTTraceDemo()::demonstrate);
        run("MST vs shortest-path tree", new MSTvsShortestPathDemo()::demonstrate);
        run("Disconnected graph forest", new DisconnectedGraphMSTDemo()::demonstrate);
        System.out.println();
        System.out.println("Minimum spanning tree study complete.");
    }

    private static void run(String title, Runnable demo) {
        System.out.println();
        System.out.println("--- " + title + " ---");
        demo.run();
    }
}
