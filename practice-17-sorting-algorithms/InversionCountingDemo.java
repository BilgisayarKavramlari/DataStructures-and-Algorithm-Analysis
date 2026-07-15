/**
 * InversionCountingDemo
 *
 * Counts inversions: pairs (i, j) with i < j but a[i] > a[j]. The number of
 * inversions equals the number of swaps insertion sort performs, which is why
 * insertion sort is fast on nearly-sorted data (few inversions) and slow on
 * reverse-sorted data (the maximum n(n-1)/2 inversions).
 *
 * Time complexity: O(n^2) for the direct count shown here.
 */
public class InversionCountingDemo {

    public static int countInversions(int[] a) {
        int inversions = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    inversions++;
                }
            }
        }
        return inversions;
    }

    public void demonstrate() {
        int[] sorted = {1, 2, 3, 4, 5};
        int[] mixed = {1, 5, 2, 4, 3};
        int[] reversed = {5, 4, 3, 2, 1};

        System.out.println("Sorted   " + java.util.Arrays.toString(sorted)
                + " -> inversions = " + countInversions(sorted));
        System.out.println("Mixed    " + java.util.Arrays.toString(mixed)
                + " -> inversions = " + countInversions(mixed));
        System.out.println("Reversed " + java.util.Arrays.toString(reversed)
                + " -> inversions = " + countInversions(reversed));
        System.out.println();
        System.out.println("Inversions equal insertion sort's shift count, bounding its running time.");
    }
}
