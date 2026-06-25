/**
 * QuadraticProbingDemo
 *
 * Inserts colliding keys into a quadratic-probing table and reports the probe
 * counts. Compared with linear probing, the squared jumps scatter the colliding
 * keys instead of bunching them into one run.
 *
 * Time complexity: O(1) expected below half load.
 */
public class QuadraticProbingDemo {

    public void demonstrate() {
        QuadraticProbingHashTable table = new QuadraticProbingHashTable(11);
        int[] keys = {10, 21, 32, 43};      // all hash to slot 10
        for (int k : keys) {
            int probes = table.insert(k);
            System.out.println("insert " + k + " used " + probes + " probe(s)");
        }
        System.out.println();
        table.printTable();
        System.out.printf("Load factor = %.2f (kept below 0.5)%n", table.loadFactor());
        System.out.println("Squared offsets spread collisions out, avoiding primary clustering.");
    }
}
