import java.util.*;

/** Insertion sort maintains a sorted prefix a[0..i). */
public class InsertionSort {
    public static void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int value = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > value) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = value;
            System.out.println("  after inserting index " + i + ": " + Arrays.toString(a));
        }
    }
    public static void run() {
        int[] a = {5, 2, 4, 6, 1, 3};
        System.out.println("-- InsertionSort");
        System.out.println("before=" + Arrays.toString(a));
        sort(a);
        System.out.println("after =" + Arrays.toString(a));
        System.out.println("Complexity: O(n) best on sorted input, O(n^2) worst with reverse order.\n");
    }
    public static void main(String[] args) { run(); }
}
