/**
 * LinearProbingHashTable
 *
 * An open-addressing hash table that resolves collisions by scanning forward one
 * slot at a time until an empty slot is found. All entries live in one array, so
 * there are no chains, but long runs ("primary clustering") can form.
 *
 * Invariant: a key is stored at the first non-occupied slot at or after hash(key)
 * in probe order; the load factor stays below 1.
 *
 * Main operation: probe sequence h, h+1, h+2, ... (mod capacity).
 *
 * Time complexity: O(1) expected at low load, degrading as the load factor
 * approaches 1. Space complexity: O(capacity).
 */
public class LinearProbingHashTable {

    private final Integer[] table;
    private int size;

    public LinearProbingHashTable(int capacity) {
        table = new Integer[capacity];
    }

    private int hash(int key) {
        return Math.floorMod(key, table.length);
    }

    /** Inserts a key, returning the number of probes used. */
    public int insert(int key) {
        int index = hash(key);
        int probes = 1;
        while (table[index] != null) {
            if (table[index] == key) {
                return probes;            // already present
            }
            index = (index + 1) % table.length;
            probes++;
        }
        table[index] = key;
        size++;
        return probes;
    }

    public boolean contains(int key) {
        int index = hash(key);
        int scanned = 0;
        while (table[index] != null && scanned < table.length) {
            if (table[index] == key) {
                return true;
            }
            index = (index + 1) % table.length;
            scanned++;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printTable() {
        for (int i = 0; i < table.length; i++) {
            System.out.println("  slot " + i + ": "
                    + (table[i] == null ? "." : table[i]));
        }
    }
}
