import java.util.*;

/** Prim grows one tree using a priority queue of crossing edges. */
public class PrimMST {
    public static int mstWeight(List<List<WeightedGraphForMST.Edge>> graph) {
        boolean[] used = new boolean[graph.size()];
        PriorityQueue<WeightedGraphForMST.Edge> pq = new PriorityQueue<WeightedGraphForMST.Edge>();
        used[0] = true;
        pq.addAll(graph.get(0));
        int total = 0, chosen = 0;
        while (!pq.isEmpty() && chosen < graph.size() - 1) {
            WeightedGraphForMST.Edge e = pq.remove();
            if (used[e.to]) continue;
            used[e.to] = true;
            chosen++;
            total += e.weight;
            System.out.println("  choose " + e + ", total=" + total);
            for (WeightedGraphForMST.Edge next : graph.get(e.to)) if (!used[next.to]) pq.add(next);
        }
        if (chosen != graph.size() - 1) System.out.println("  graph is disconnected; result is a forest");
        return total;
    }
    public static void run(){System.out.println("-- PrimMST");System.out.println("  MST weight="+mstWeight(WeightedGraphForMST.adjacency(4))+"\n");}
    public static void main(String[] args){run();}
}
