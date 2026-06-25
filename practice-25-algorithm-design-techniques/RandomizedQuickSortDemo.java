import java.util.Random;

/**
 * RandomizedQuickSortDemo
 *
 * Randomization is an algorithm-design technique in its own right. Plain
 * quicksort degrades to O(n^2) on adversarial input (such as already-sorted
 * data) because a fixed pivot choice splits poorly. Choosing the pivot at random
 * makes that worst case astronomically unlikely, giving expected O(n log n)
 * regardless of input order.
 *
 * Invariant: after each partition the pivot sits in its final sorted position,
 * with smaller elements left and larger elements right.
 *
 * Time complexity: expected O(n log n), worst O(n^2) but with vanishing
 *   probability. Space complexity: O(log n) expected recursion depth.
 */
public class RandomizedQuickSortDemo {

    private final Random random = new Random(42);
    private int comparisons = 0;

    public void demonstrate() {
        int[] adversarial = { 1, 2, 3, 4, 5, 6, 7, 8 };
        System.out.println("Sorting already-sorted input (quicksort's classic worst case).");
        System.out.println("Array: " + java.util.Arrays.toString(adversarial));
        System.out.println();

        comparisons = 0;
        int[] copy = adversarial.clone();
        randomizedQuickSort(copy, 0, copy.length - 1);
        System.out.println("  sorted: " + java.util.Arrays.toString(copy));
        System.out.println("  comparisons with random pivot: " + comparisons);
        System.out.println();
        System.out.println("A random pivot avoids the consistently lopsided splits that would");
        System.out.println("otherwise make sorted input cost quadratic.");
    }

    private void randomizedQuickSort(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivotIndex = low + random.nextInt(high - low + 1);
        swap(a, pivotIndex, high);
        int p = partition(a, low, high);
        randomizedQuickSort(a, low, p - 1);
        randomizedQuickSort(a, p + 1, high);
    }

    private int partition(int[] a, int low, int high) {
        int pivot = a[high];
        int i = low;
        for (int j = low; j < high; j++) {
            comparisons++;
            if (a[j] < pivot) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i, high);
        return i;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
