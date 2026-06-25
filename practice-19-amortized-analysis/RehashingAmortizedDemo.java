/**
 * RehashingAmortizedDemo
 *
 * Shows that a hash table which doubles its bucket array when the load factor
 * exceeds a threshold has amortized O(1) insertion, by the same doubling
 * argument as a dynamic array. A rehash re-inserts every existing key into the
 * larger array and is therefore O(n), but rehashes become geometrically rarer
 * as the table grows.
 *
 * Time complexity: insert is amortized O(1); a rehash is O(n).
 * Space complexity: O(capacity).
 *
 * Simplified for teaching: keys are integers, collisions are not stored (we
 * only track counts), and the focus is on counting rehash work.
 */
public class RehashingAmortizedDemo {

    private static final double MAX_LOAD = 0.75;

    public void demonstrate() {
        System.out.println("Inserting 20 keys; the table rehashes when load factor > "
                + MAX_LOAD + ".");
        System.out.println();
        System.out.printf("%-8s %-10s %-12s %-10s%n",
                "insert", "capacity", "loadFactor", "rehashCost");

        int capacity = 4;
        int size = 0;
        long totalRehashWork = 0;

        for (int key = 1; key <= 20; key++) {
            int rehashCost = 0;
            double load = (double) (size + 1) / capacity;
            if (load > MAX_LOAD) {
                rehashCost = size;
                totalRehashWork += size;
                capacity *= 2;
            }
            size++;
            System.out.printf("%-8d %-10d %-12.3f %-10d%n",
                    key, capacity, (double) size / capacity, rehashCost);
        }

        System.out.println();
        System.out.println("Total re-insertion work across all rehashes: " + totalRehashWork);
        System.out.println("This stays below 2n, so insertion is amortized O(1).");
    }
}
