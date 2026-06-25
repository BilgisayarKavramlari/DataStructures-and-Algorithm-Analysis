/**
 * RadixSortIntro
 *
 * A least-significant-digit radix sort for non-negative integers. It sorts by
 * one digit at a time using a stable counting sort, from the least significant
 * digit to the most significant. Because it never compares two keys directly, it
 * is not bound by the comparison-sort lower bound.
 *
 * Invariant: after processing digit d, the array is sorted by the lowest d+1
 * digits.
 *
 * Time complexity: O(d * (n + b)) for d digits and base b. Space complexity O(n + b).
 */
public class RadixSortIntro {

    public static void sort(int[] a) {
        if (a.length == 0) {
            return;
        }
        int max = a[0];
        for (int v : a) {
            max = Math.max(max, v);
        }
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(a, exp);
        }
    }

    // Stable counting sort keyed on the digit selected by exp.
    private static void countingSortByDigit(int[] a, int exp) {
        int n = a.length;
        int[] output = new int[n];
        int[] count = new int[10];

        for (int v : a) {
            count[(v / exp) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];        // running positions
        }
        for (int i = n - 1; i >= 0; i--) {   // reverse pass keeps it stable
            int digit = (a[i] / exp) % 10;
            output[--count[digit]] = a[i];
        }
        System.arraycopy(output, 0, a, 0, n);
    }

    public void demonstrate() {
        int[] a = {329, 457, 657, 839, 436, 720, 355};
        System.out.println("Before: " + java.util.Arrays.toString(a));
        sort(a);
        System.out.println("After : " + java.util.Arrays.toString(a));
        System.out.println("Sorting digit by digit avoids element comparisons entirely.");
    }
}
