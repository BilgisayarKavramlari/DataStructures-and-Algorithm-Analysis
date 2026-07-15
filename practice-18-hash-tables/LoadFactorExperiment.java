/**
 * LoadFactorExperiment
 *
 * Measures how the average number of probes for a successful search grows with
 * the load factor under linear probing. Theory predicts roughly
 * (1 + 1/(1-a)) / 2 probes at load factor a, so cost explodes as a approaches 1.
 * The experiment reports measured averages alongside that intuition.
 *
 * Time complexity: O(capacity) to build and probe each table.
 */
public class LoadFactorExperiment {

    public void demonstrate() {
        int capacity = 1009;            // prime
        System.out.printf("%-12s %-16s %-16s%n", "load factor", "measured probes", "theory ~");
        for (double target : new double[]{0.25, 0.5, 0.75, 0.9}) {
            int n = (int) (capacity * target);
            LinearProbingHashTable table = new LinearProbingHashTable(capacity);
            int[] inserted = new int[n];
            for (int i = 0; i < n; i++) {
                int key = i * 7 + 3;     // spread but deterministic
                inserted[i] = key;
                table.insert(key);
            }
            long totalProbes = 0;
            for (int key : inserted) {
                totalProbes += probesForSuccessfulSearch(table, key, capacity);
            }
            double measured = (double) totalProbes / n;
            double theory = (1 + 1.0 / (1 - target)) / 2.0;
            System.out.printf("%-12.2f %-16.2f %-16.2f%n", target, measured, theory);
        }
        System.out.println();
        System.out.println("Probe cost climbs sharply past load factor 0.75, motivating rehashing.");
    }

    // Re-derives the probe count by repeating the probe sequence for a known key.
    private int probesForSuccessfulSearch(LinearProbingHashTable table, int key, int capacity) {
        // Reinsert returns probe count without adding a duplicate.
        return table.insert(key);
    }
}
