import java.util.*;

/** Dijkstra using Java PriorityQueue for nonnegative edge weights. */
public class DijkstraWithPriorityQueue {
    static class Edge { int to, weight; Edge(int to, int weight){this.to=to;this.weight=weight;} }
    static class State implements Comparable<State> { int v, d; State(int v,int d){this.v=v;this.d=d;} public int compareTo(State o){return d-o.d;} }
    public static int[] shortestPaths(List<List<Edge>> graph, int start) {
        int[] dist = new int[graph.size()];
        int[] prev = new int[graph.size()];
        Arrays.fill(dist, Integer.MAX_VALUE/4);
        Arrays.fill(prev, -1);
        PriorityQueue<State> pq = new PriorityQueue<State>();
        dist[start] = 0;
        pq.add(new State(start, 0));
        while (!pq.isEmpty()) {
            State s = pq.remove();
            if (s.d != dist[s.v]) continue;
            System.out.println("  remove vertex " + s.v + " distance " + s.d);
            for (Edge e : graph.get(s.v)) {
                if (dist[s.v] + e.weight < dist[e.to]) {
                    dist[e.to] = dist[s.v] + e.weight;
                    prev[e.to] = s.v;
                    pq.add(new State(e.to, dist[e.to]));
                    System.out.println("    relax " + s.v + "->" + e.to + " new distance " + dist[e.to]);
                }
            }
        }
        System.out.println("  predecessor table=" + Arrays.toString(prev));
        return dist;
    }
    public static void run() {
        List<List<Edge>> g = new ArrayList<List<Edge>>();
        for (int i=0;i<4;i++) g.add(new ArrayList<Edge>());
        g.get(0).add(new Edge(1,2)); g.get(0).add(new Edge(2,5));
        g.get(1).add(new Edge(2,1)); g.get(1).add(new Edge(3,4));
        g.get(2).add(new Edge(3,1));
        System.out.println("-- DijkstraWithPriorityQueue");
        System.out.println("  distances=" + Arrays.toString(shortestPaths(g,0)) + "\n");
    }
    public static void main(String[] args){run();}
}
