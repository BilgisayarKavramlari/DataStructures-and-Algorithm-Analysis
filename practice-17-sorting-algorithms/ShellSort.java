import java.util.*;

/** Shellsort performs insertion sort over decreasing gaps. */
public class ShellSort {
    public static void sort(int[] a) {
        for (int gap = a.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < a.length; i++) {
                int value = a[i];
                int j = i;
                while (j >= gap && a[j - gap] > value) {
                    a[j] = a[j - gap];
                    j -= gap;
                }
                a[j] = value;
            }
            System.out.println("  after gap " + gap + ": " + Arrays.toString(a));
        }
    }
    public static void run() { int[] a={9,8,3,7,5,6,4,1}; System.out.println("-- ShellSort"); sort(a); System.out.println("sorted="+Arrays.toString(a)+"\n"); }
    public static void main(String[] args){run();}
}
