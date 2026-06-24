import java.util.*;

/** Weighted undirected graph sample shared by MST demos. */
public class WeightedGraphForMST {
    static class Edge implements Comparable<Edge> {
        int from, to, weight;
        Edge(int from,int to,int weight){this.from=from;this.to=to;this.weight=weight;}
        public int compareTo(Edge other){return weight-other.weight;}
        public String toString(){return from+"-"+to+"("+weight+")";}
    }
    public static List<Edge> edges(){
        return Arrays.asList(new Edge(0,1,1),new Edge(0,2,4),new Edge(1,2,2),new Edge(1,3,6),new Edge(2,3,3));
    }
    public static List<List<Edge>> adjacency(int n){
        List<List<Edge>> g=new ArrayList<List<Edge>>();
        for(int i=0;i<n;i++)g.add(new ArrayList<Edge>());
        for(Edge e:edges()){g.get(e.from).add(e);g.get(e.to).add(new Edge(e.to,e.from,e.weight));}
        return g;
    }
    public static void run(){System.out.println("-- WeightedGraphForMST edges="+edges()+"\n");}
    public static void main(String[] args){run();}
}
