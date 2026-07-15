/**
 * LazyDeletionDemo
 *
 * In open addressing a key cannot simply be erased, because doing so would break
 * the probe chains of keys inserted after it. Lazy deletion marks a slot as
 * DELETED instead: searches skip past it, but insertions may reuse it.
 *
 * Time complexity: O(1) expected, though tombstones can lengthen probe chains
 * until the table is rehashed.
 */
public class LazyDeletionDemo {

    private enum State { EMPTY, OCCUPIED, DELETED }

    private final Integer[] keys = new Integer[7];
    private final State[] states = new State[7];

    public LazyDeletionDemo() {
        for (int i = 0; i < states.length; i++) {
            states[i] = State.EMPTY;
        }
    }

    private int hash(int key) {
        return Math.floorMod(key, keys.length);
    }

    private void insert(int key) {
        int index = hash(key);
        while (states[index] == State.OCCUPIED) {
            index = (index + 1) % keys.length;
        }
        keys[index] = key;
        states[index] = State.OCCUPIED;
    }

    private boolean contains(int key) {
        int index = hash(key);
        int scanned = 0;
        // Must keep scanning past DELETED slots, but stop at EMPTY.
        while (states[index] != State.EMPTY && scanned < keys.length) {
            if (states[index] == State.OCCUPIED && keys[index] == key) {
                return true;
            }
            index = (index + 1) % keys.length;
            scanned++;
        }
        return false;
    }

    private void delete(int key) {
        int index = hash(key);
        int scanned = 0;
        while (states[index] != State.EMPTY && scanned < keys.length) {
            if (states[index] == State.OCCUPIED && keys[index] == key) {
                states[index] = State.DELETED;   // tombstone, not erased
                return;
            }
            index = (index + 1) % keys.length;
            scanned++;
        }
    }

    public void demonstrate() {
        insert(1);
        insert(8);     // collides with 1 -> goes to slot 2
        insert(15);    // collides -> goes to slot 3
        System.out.println("Inserted 1, 8, 15 (all hash to slot 1).");

        System.out.println("Deleting 8 with a tombstone (not a hard erase)...");
        delete(8);
        System.out.println("contains(15) after deleting 8? " + contains(15)
                + "  (search still reaches 15)");
        System.out.println("contains(8) after deleting 8?  " + contains(8));
        System.out.println();
        System.out.println("A hard erase would have left an EMPTY gap and hidden 15 from search.");
    }
}
