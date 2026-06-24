import java.util.*;

/** Small union-find helper for Kruskal. */
public class UnionFindForKruskal {
    private final int[] parent, rank;
    public UnionFindForKruskal(int n){parent=new int[n];rank=new int[n];for(int i=0;i<n;i++)parent[i]=i;}
    public int find(int x){if(parent[x]!=x)parent[x]=find(parent[x]);return parent[x];}
    public boolean union(int a,int b){int ra=find(a),rb=find(b);if(ra==rb)return false;if(rank[ra]<rank[rb])parent[ra]=rb;else if(rank[ra]>rank[rb])parent[rb]=ra;else{parent[rb]=ra;rank[ra]++;}return true;}
    public static void run(){UnionFindForKruskal u=new UnionFindForKruskal(4);System.out.println("-- UnionFindForKruskal union 0-1 accepted="+u.union(0,1)+"\n");}
    public static void main(String[] args){run();}
}
