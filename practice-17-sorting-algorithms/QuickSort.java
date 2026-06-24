import java.util.*;

/** Quicksort partitions around a pivot, then sorts both sides. */
public class QuickSort {
    public static void sort(int[] a) { quick(a, 0, a.length - 1); }
    private static void quick(int[] a, int lo, int hi) {
        if (lo >= hi) return;
        int p = partition(a, lo, hi);
        System.out.println("  pivot placed at " + p + ": " + Arrays.toString(a));
        quick(a, lo, p - 1);
        quick(a, p + 1, hi);
    }
    private static int partition(int[] a, int lo, int hi) {
        int pivot = a[hi];
        int i = lo;
        for (int j = lo; j < hi; j++) {
            if (a[j] <= pivot) { int t=a[i]; a[i]=a[j]; a[j]=t; i++; }
        }
        int t=a[i]; a[i]=a[hi]; a[hi]=t;
        return i;
    }
    public static void run(){int[] a={9,3,7,1,8,2};System.out.println("-- QuickSort");sort(a);System.out.println("result="+Arrays.toString(a)+"\n");}
    public static void main(String[] args){run();}
}
