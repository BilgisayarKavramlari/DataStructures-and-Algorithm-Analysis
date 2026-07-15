/**
 * ShellSort
 *
 * Generalises insertion sort by first sorting elements far apart (gap > 1) and
 * shrinking the gap to 1. Early large-gap passes move elements long distances
 * cheaply, removing many inversions before the final gap-1 pass.
 *
 * Invariant: after a pass with gap g, the array is "g-sorted" (every g-th
 * subsequence is sorted).
 *
 * Time complexity: depends on the gap sequence; the halving sequence shown here
 * is about O(n^2) worst case but far better in practice. Space complexity O(1).
 */
public class ShellSort {

    public static void sort(int[] a) {
        int n = a.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = a[i];
                int j = i;
                while (j >= gap && a[j - gap] > temp) {
                    a[j] = a[j - gap];
                    j -= gap;
                }
                a[j] = temp;
            }
        }
    }

    public void demonstrate() {
        int[] a = {62, 83, 18, 53, 7, 17, 95, 86, 47, 69, 25, 28};
        System.out.println("Before: " + java.util.Arrays.toString(a));
        sort(a);
        System.out.println("After : " + java.util.Arrays.toString(a));
        System.out.println("Large gaps remove distant inversions before the final gap-1 pass.");
    }
}
