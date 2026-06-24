import java.util.*;

/** Union-find using rank and path compression. */
public class UnionByRank {
    private final int[] parent;
    private final int[] rank;
    public UnionByRank(int n) {
        parent = new int[n]; rank = new int[n];
        for (int i=0;i<n;i++) parent[i]=i;
    }
    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    public void union(int a, int b) {
        int ra=find(a), rb=find(b);
        if (ra == rb) return;
        if (rank[ra] < rank[rb]) parent[ra] = rb;
        else if (rank[ra] > rank[rb]) parent[rb] = ra;
        else { parent[rb] = ra; rank[ra]++; }
    }
    public static void run() {
        UnionByRank ds = new UnionByRank(6);
        System.out.println("-- UnionByRank");
        ds.union(0,1); ds.union(2,3); ds.union(1,3);
        System.out.println("  parents=" + Arrays.toString(ds.parent));
        System.out.println("  ranks  =" + Arrays.toString(ds.rank));
        System.out.println("  find(3)=" + ds.find(3) + ", parents after compression=" + Arrays.toString(ds.parent) + "\n");
    }
    public static void main(String[] args){run();}
}
