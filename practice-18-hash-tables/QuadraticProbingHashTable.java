/**
 * QuadraticProbingHashTable
 *
 * An open-addressing table whose probe sequence jumps by increasing squares:
 * h, h+1^2, h+2^2, ... (mod capacity). This avoids the primary clustering of
 * linear probing. With a prime capacity and load factor below 0.5, an empty slot
 * is guaranteed to be found.
 *
 * Invariant: a key sits at the first free slot in its quadratic probe sequence;
 * load factor is kept below 0.5 for the guarantee to hold.
 *
 * Time complexity: O(1) expected below half load. Space complexity: O(capacity).
 */
public class QuadraticProbingHashTable {

    private final Integer[] table;
    private int size;

    public QuadraticProbingHashTable(int primeCapacity) {
        table = new Integer[primeCapacity];
    }

    private int hash(int key) {
        return Math.floorMod(key, table.length);
    }

    public int insert(int key) {
        int home = hash(key);
        int i = 0;
        int probes = 1;
        while (true) {
            int index = (home + i * i) % table.length;
            if (table[index] == null) {
                table[index] = key;
                size++;
                return probes;
            }
            if (table[index] == key) {
                return probes;
            }
            i++;
            probes++;
        }
    }

    public boolean contains(int key) {
        int home = hash(key);
        for (int i = 0; i < table.length; i++) {
            int index = (home + i * i) % table.length;
            if (table[index] == null) {
                return false;
            }
            if (table[index] == key) {
                return true;
            }
        }
        return false;
    }

    public double loadFactor() {
        return (double) size / table.length;
    }

    public void printTable() {
        for (int i = 0; i < table.length; i++) {
            System.out.println("  slot " + i + ": "
                    + (table[i] == null ? "." : table[i]));
        }
    }
}
