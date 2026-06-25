/**
 * DynamicArrayResizeTraceDemo
 *
 * Traces the capacity-doubling behaviour of a DynamicArray append by append,
 * printing the per-operation cost so the rare, expensive resize steps stand out
 * against the many cheap O(1) appends.
 *
 * Teaching point: expensive operations are infrequent, which is exactly the
 * pattern that amortized analysis is designed to characterise.
 */
public class DynamicArrayResizeTraceDemo {

    public void demonstrate() {
        DynamicArray array = new DynamicArray(1);
        System.out.println("Appending 16 values to a DynamicArray with initial capacity 1.");
        System.out.println("A cost greater than 1 marks an append that triggered a resize.");
        System.out.println();
        System.out.printf("%-8s %-10s %-10s %-8s%n", "append", "value", "capacity", "cost");

        for (int value = 1; value <= 16; value++) {
            int cost = array.add(value);
            System.out.printf("%-8d %-10d %-10d %-8d%n",
                    value, value, array.capacity(), cost);
        }

        System.out.println();
        System.out.println("Total resizes: " + array.resizeCount());
        System.out.println("Total element copies across all resizes: " + array.totalCopies());
        System.out.println("Copies stay below 2n, so amortized cost per append is O(1).");
    }
}
