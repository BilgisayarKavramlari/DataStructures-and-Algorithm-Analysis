/**
 * CuckooHashingEducationalDemo
 *
 * Concept:
 *   Cuckoo hashing uses two independent hash functions and two tables. Every
 *   key lives in exactly one of its two candidate slots, which guarantees
 *   worst-case O(1) lookup: a search inspects only two positions.
 *
 * Insertion rule (the "cuckoo" behaviour):
 *   Place the new key in its slot in table 1. If that slot is occupied, evict
 *   the resident key (like a cuckoo chick pushing eggs out of a nest) and
 *   reinsert that displaced key into its alternate table. Continue until an
 *   empty slot is found or a displacement limit is reached, which signals that
 *   a rehash with new hash functions would be required.
 *
 * Invariant:
 *   Each stored key k resides in table1[h1(k)] or table2[h2(k)] and nowhere
 *   else. Lookups therefore never probe a chain.
 *
 * Time complexity: lookup and delete are worst-case O(1); insertion is
 *   expected O(1) amortized but may trigger a rehash under high load.
 * Space complexity: O(capacity) across the two tables.
 *
 * This implementation is simplified for teaching: capacity is fixed and a
 * displacement limit reports failure instead of performing a full rehash.
 */
public class CuckooHashingEducationalDemo {

    private static final int CAPACITY = 11;
    private final Integer[] table1 = new Integer[CAPACITY];
    private final Integer[] table2 = new Integer[CAPACITY];

    private int hash1(int key) {
        return Math.floorMod(key, CAPACITY);
    }

    private int hash2(int key) {
        return Math.floorMod(key / CAPACITY + 1, CAPACITY);
    }

    public void demonstrate() {
        System.out.println("Cuckoo hashing with two tables and two hash functions.");
        System.out.println("h1(k) = k mod " + CAPACITY + ", h2(k) = (k / " + CAPACITY + " + 1) mod " + CAPACITY);
        System.out.println();

        int[] keys = { 20, 50, 53, 75, 100, 67, 105, 3, 36, 39 };
        for (int key : keys) {
            insert(key);
        }

        System.out.println();
        System.out.println("Final table contents:");
        printTables();

        System.out.println();
        for (int key : new int[] { 75, 36, 999 }) {
            System.out.println("  lookup(" + key + ") -> " + (contains(key) ? "found" : "absent")
                    + " (checked only 2 slots)");
        }
    }

    private void insert(int key) {
        System.out.println("Inserting " + key + ":");
        int current = key;
        boolean useTable1 = true;
        int maxDisplacements = 2 * CAPACITY;

        for (int step = 0; step < maxDisplacements; step++) {
            if (useTable1) {
                int pos = hash1(current);
                if (table1[pos] == null) {
                    table1[pos] = current;
                    System.out.println("  placed " + current + " into table1[" + pos + "]");
                    return;
                }
                int evicted = table1[pos];
                table1[pos] = current;
                System.out.println("  table1[" + pos + "] occupied; placed " + current
                        + ", evicted " + evicted);
                current = evicted;
            } else {
                int pos = hash2(current);
                if (table2[pos] == null) {
                    table2[pos] = current;
                    System.out.println("  placed " + current + " into table2[" + pos + "]");
                    return;
                }
                int evicted = table2[pos];
                table2[pos] = current;
                System.out.println("  table2[" + pos + "] occupied; placed " + current
                        + ", evicted " + evicted);
                current = evicted;
            }
            useTable1 = !useTable1;
        }
        System.out.println("  displacement limit reached for " + current
                + "; a real table would rehash with new functions");
    }

    private boolean contains(int key) {
        Integer a = table1[hash1(key)];
        Integer b = table2[hash2(key)];
        return (a != null && a == key) || (b != null && b == key);
    }

    private void printTables() {
        System.out.print("  table1: ");
        for (int i = 0; i < CAPACITY; i++) {
            System.out.print((table1[i] == null ? "." : table1[i]) + " ");
        }
        System.out.println();
        System.out.print("  table2: ");
        for (int i = 0; i < CAPACITY; i++) {
            System.out.print((table2[i] == null ? "." : table2[i]) + " ");
        }
        System.out.println();
    }
}
