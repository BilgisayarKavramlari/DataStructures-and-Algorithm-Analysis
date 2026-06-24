import java.util.*;

/** Mergesort recursively sorts halves and merges them. */
public class MergeSort {
    public static void sort(int[] a) { sort(a, new int[a.length], 0, a.length - 1); }
    private static void sort(int[] a, int[] tmp, int lo, int hi) {
        if (lo >= hi) return;
        int mid = (lo + hi) / 2;
        sort(a, tmp, lo, mid);
        sort(a, tmp, mid + 1, hi);
        int i=lo,j=mid+1,k=lo;
        while(i<=mid && j<=hi) tmp[k++] = a[i] <= a[j] ? a[i++] : a[j++];
        while(i<=mid) tmp[k++] = a[i++];
        while(j<=hi) tmp[k++] = a[j++];
        for(i=lo;i<=hi;i++) a[i]=tmp[i];
        System.out.println("  merged " + lo + ".." + hi + ": " + Arrays.toString(a));
    }
    public static void run(){int[] a={8,3,2,9,7,1,5,4};System.out.println("-- MergeSort");sort(a);System.out.println("result="+Arrays.toString(a)+"\n");}
    public static void main(String[] args){run();}
}
