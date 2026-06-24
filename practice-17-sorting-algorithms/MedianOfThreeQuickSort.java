import java.util.*;

/** Quicksort variant using median-of-three pivot selection. */
public class MedianOfThreeQuickSort {
    private static int medianIndex(int[] a, int lo, int hi) {
        int mid = (lo + hi) / 2;
        if (a[lo] > a[mid]) swap(a, lo, mid);
        if (a[lo] > a[hi]) swap(a, lo, hi);
        if (a[mid] > a[hi]) swap(a, mid, hi);
        return mid;
    }
    private static void swap(int[] a,int i,int j){int t=a[i];a[i]=a[j];a[j]=t;}
    private static void quick(int[] a,int lo,int hi){
        if(lo>=hi)return;
        int m=medianIndex(a,lo,hi);
        swap(a,m,hi);
        int pivot=a[hi], i=lo;
        for(int j=lo;j<hi;j++) if(a[j]<=pivot) swap(a,i++,j);
        swap(a,i,hi);
        System.out.println("  median pivot " + pivot + " -> " + Arrays.toString(a));
        quick(a,lo,i-1); quick(a,i+1,hi);
    }
    public static void run(){int[] a={12,5,9,1,13,4,8};System.out.println("-- MedianOfThreeQuickSort");quick(a,0,a.length-1);System.out.println("result="+Arrays.toString(a)+"\n");}
    public static void main(String[] args){run();}
}
