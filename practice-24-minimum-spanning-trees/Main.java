/** Main driver for Practice 24: Minimum Spanning Trees. */
public class Main {
    public static void main(String[] args) {
        System.out.println("CS 3345 Practice 24: Minimum Spanning Trees");
        System.out.println("Related Course Module: Module 9");
        System.out.println("Weiss topic: Chapter 9, Minimum Spanning Trees");
        System.out.println("Goal: trace complete plain-Java examples for live teaching.\n");
        WeightedGraphForMST.run();
        PrimMST.run();
        KruskalMST.run();
        MSTTraceDemo.run();
        MSTvsShortestPathDemo.run();
        DisconnectedGraphMSTDemo.run();
        UnionFindForKruskal.run();
        System.out.println("End of Practice 24. Re-run after changing input values to experiment.");
    }
}
