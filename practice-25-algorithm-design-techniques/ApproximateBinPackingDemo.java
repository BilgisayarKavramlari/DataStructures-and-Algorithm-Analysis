/**
 * ApproximateBinPackingDemo
 *
 * Bin packing (fit items of varying size into the fewest unit-capacity bins) is
 * NP-hard, so we use fast approximation heuristics. First Fit places each item
 * in the first bin with room; First Fit Decreasing sorts items largest-first
 * before doing so and is provably within 11/9 of optimal plus a constant.
 *
 * Time complexity: O(n^2) for the simple first-fit scan; O(n log n + n^2) with
 *   the presort. Space complexity: O(n).
 */
public class ApproximateBinPackingDemo {

    public void demonstrate() {
        double[] items = { 0.5, 0.7, 0.5, 0.2, 0.4, 0.2, 0.5, 0.1, 0.6 };

        System.out.println("Packing items (bin capacity 1.0): " + java.util.Arrays.toString(items));
        System.out.println();

        int firstFit = firstFit(items.clone());
        System.out.println("  First Fit used " + firstFit + " bins.");

        double[] sorted = items.clone();
        java.util.Arrays.sort(sorted);
        for (int i = 0; i < sorted.length / 2; i++) {
            double t = sorted[i];
            sorted[i] = sorted[sorted.length - 1 - i];
            sorted[sorted.length - 1 - i] = t;
        }
        int firstFitDecreasing = firstFit(sorted);
        System.out.println("  First Fit Decreasing used " + firstFitDecreasing + " bins.");
        System.out.println();
        System.out.println("Sorting largest-first packs big items before fragmentation sets in,");
        System.out.println("which is why First Fit Decreasing usually needs fewer bins.");
    }

    private int firstFit(double[] items) {
        double[] remaining = new double[items.length];
        int binCount = 0;
        for (double item : items) {
            boolean placed = false;
            for (int b = 0; b < binCount; b++) {
                if (remaining[b] >= item) {
                    remaining[b] -= item;
                    placed = true;
                    break;
                }
            }
            if (!placed) {
                remaining[binCount] = 1.0 - item;
                binCount++;
            }
        }
        return binCount;
    }
}
