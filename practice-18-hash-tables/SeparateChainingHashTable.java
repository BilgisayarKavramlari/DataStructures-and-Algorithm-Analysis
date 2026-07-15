import java.util.LinkedList;
import java.util.List;

/**
 * SeparateChainingHashTable
 *
 * A hash table that resolves collisions by storing all keys that hash to the
 * same slot in a linked list (a "chain"). Lookups scan only the relevant chain.
 *
 * Invariant: every stored key resides in the chain at index hash(key); the load
 * factor is size/capacity.
 *
 * Main operations: insert appends to a chain if absent; contains scans a chain;
 * remove unlinks from a chain.
 *
 * Time complexity: O(1 + load factor) expected per operation with a good hash.
 * Space complexity: O(n + capacity).
 */
public class SeparateChainingHashTable {

    private List<Integer>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public SeparateChainingHashTable(int capacity) {
        table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return Math.floorMod(key, table.length);
    }

    public void insert(int key) {
        List<Integer> chain = table[hash(key)];
        if (!chain.contains(key)) {
            chain.add(key);
            size++;
        }
    }

    public boolean contains(int key) {
        return table[hash(key)].contains(key);
    }

    public boolean remove(int key) {
        boolean removed = table[hash(key)].remove((Integer) key);
        if (removed) {
            size--;
        }
        return removed;
    }

    public int size() {
        return size;
    }

    public double loadFactor() {
        return (double) size / table.length;
    }

    public void printChains() {
        for (int i = 0; i < table.length; i++) {
            System.out.println("  slot " + i + ": " + table[i]);
        }
    }
}
