import java.util.*;

/** Heapsort builds a max heap and repeatedly removes the maximum. */
public class HeapSort {
    private static void heapify(int[] a, int size, int i) {
        while (true) {
            int largest = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if (left < size && a[left] > a[largest]) largest = left;
            if (right < size && a[right] > a[largest]) largest = right;
            if (largest == i) return;
            int t = a[i]; a[i] = a[largest]; a[largest] = t;
            i = largest;
        }
    }
    public static void sort(int[] a) {
        for (int i = a.length / 2 - 1; i >= 0; i--) heapify(a, a.length, i);
        System.out.println("  max heap=" + Arrays.toString(a));
        for (int end = a.length - 1; end > 0; end--) {
            int t = a[0]; a[0] = a[end]; a[end] = t;
            heapify(a, end, 0);
            System.out.println("  sorted suffix starts at " + end + ": " + Arrays.toString(a));
        }
    }
    public static void run() { int[] a={4,10,3,5,1}; System.out.println("-- HeapSort"); sort(a); System.out.println("result="+Arrays.toString(a)+"\n"); }
    public static void main(String[] args){run();}
}
