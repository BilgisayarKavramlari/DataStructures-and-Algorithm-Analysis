/**
 * DoubleHashingDemo
 *
 * Double hashing uses a second hash function to set the probe step, so different
 * keys with the same home slot follow different probe sequences. This removes
 * both primary and secondary clustering. A common choice is
 * step = R - (key mod R) for a prime R smaller than the table size.
 *
 * Time complexity: O(1) expected per operation with a good pair of hashes.
 */
public class DoubleHashingDemo {

    private final Integer[] table;
    private final int R;

    public DoubleHashingDemo() {
        this.table = new Integer[13];     // prime table size
        this.R = 7;                       // prime smaller than the table size
    }

    private int hash1(int key) {
        return Math.floorMod(key, table.length);
    }

    private int hash2(int key) {
        return R - Math.floorMod(key, R);  // never zero
    }

    private int insert(int key) {
        int index = hash1(key);
        int step = hash2(key);
        int probes = 1;
        while (table[index] != null) {
            index = (index + step) % table.length;
            probes++;
        }
        table[index] = key;
        return probes;
    }

    public void demonstrate() {
        int[] keys = {13, 26, 39, 52};    // all share home slot 0
        System.out.println("All keys hash1 to slot 0, but each gets its own step from hash2:");
        for (int k : keys) {
            int step = hash2(k);
            int probes = insert(k);
            System.out.println("  key " + k + " step=" + step
                    + " placed after " + probes + " probe(s)");
        }
        System.out.println();
        for (int i = 0; i < table.length; i++) {
            System.out.println("  slot " + i + ": "
                    + (table[i] == null ? "." : table[i]));
        }
        System.out.println("Distinct steps mean colliding keys diverge immediately.");
    }
}
