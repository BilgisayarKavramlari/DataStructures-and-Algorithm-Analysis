import java.util.*;

/** Kruskal sorts edges and accepts those connecting different components. */
public class KruskalMST {
    public static int mstWeight(int vertices, List<WeightedGraphForMST.Edge> edges) {
        List<WeightedGraphForMST.Edge> sorted = new ArrayList<WeightedGraphForMST.Edge>(edges);
        Collections.sort(sorted);
        UnionFindForKruskal uf = new UnionFindForKruskal(vertices);
        int total = 0;
        for (WeightedGraphForMST.Edge e : sorted) {
            if (uf.union(e.from, e.to)) {
                total += e.weight;
                System.out.println("  take " + e + ", total=" + total);
            } else {
                System.out.println("  skip cycle edge " + e);
            }
        }
        return total;
    }
    public static void run(){System.out.println("-- KruskalMST");System.out.println("  MST weight="+mstWeight(4,WeightedGraphForMST.edges())+"\n");}
    public static void main(String[] args){run();}
}
