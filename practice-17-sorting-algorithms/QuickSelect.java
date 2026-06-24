import java.util.*;

/** Quickselect finds kth smallest without sorting the entire array. */
public class QuickSelect {
    public static int select(int[] a, int k) {
        int lo=0, hi=a.length-1;
        while (lo <= hi) {
            int p = partition(a, lo, hi);
            System.out.println("  partition index=" + p + ": " + Arrays.toString(a));
            if (p == k) return a[p];
            if (p < k) lo = p + 1; else hi = p - 1;
        }
        throw new IllegalArgumentException("k out of range");
    }
    private static int partition(int[] a,int lo,int hi){int pivot=a[hi],i=lo;for(int j=lo;j<hi;j++)if(a[j]<=pivot){int t=a[i];a[i]=a[j];a[j]=t;i++;}int t=a[i];a[i]=a[hi];a[hi]=t;return i;}
    public static void run(){int[] a={10,4,5,8,6,11,26};int k=2;System.out.println("-- QuickSelect");System.out.println("k="+k+" value="+select(a,k)+"\n");}
    public static void main(String[] args){run();}
}
