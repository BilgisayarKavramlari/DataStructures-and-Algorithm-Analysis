/**
 * LinearProbingDemo
 *
 * Inserts colliding keys into a linear-probing table and reports the probe count
 * per insertion, making primary clustering visible as later keys need more
 * probes to find a free slot.
 *
 * Time complexity: O(1) expected per insert at low load.
 */
public class LinearProbingDemo {

    public void demonstrate() {
        LinearProbingHashTable table = new LinearProbingHashTable(11);
        int[] keys = {10, 21, 32, 43, 9};   // 10,21,32,43 all hash to slot 10
        for (int k : keys) {
            int probes = table.insert(k);
            System.out.println("insert " + k + " used " + probes + " probe(s)");
        }
        System.out.println();
        table.printTable();
        System.out.println();
        System.out.println("Successive collisions form a run, so each new colliding key probes further.");
    }
}
