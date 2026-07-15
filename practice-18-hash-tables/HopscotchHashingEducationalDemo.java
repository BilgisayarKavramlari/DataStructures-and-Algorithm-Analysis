/**
 * HopscotchHashingEducationalDemo
 *
 * Concept:
 *   Hopscotch hashing is an open-addressing scheme that guarantees a key is
 *   always found within a small neighbourhood (here of size H) of its home
 *   bucket h(k). This keeps lookups cache-friendly and bounded: a search
 *   inspects at most H consecutive slots.
 *
 * Insertion:
 *   1. Linearly probe forward from the home bucket to find any free slot.
 *   2. If that free slot lies within H of the home bucket, store the key there.
 *   3. Otherwise "hop" the empty slot closer by swapping it with an earlier key
 *      whose own neighbourhood still contains the empty slot, repeating until
 *      the empty slot is inside the home neighbourhood.
 *
 * Invariant:
 *   Every key k is stored at some index in [h(k), h(k) + H - 1] (modulo the
 *   table size). Lookups therefore scan a fixed-width window only.
 *
 * Time complexity: lookup is O(H) = O(1) for constant H; insertion is expected
 *   O(1) amortized. Space complexity: O(capacity).
 *
 * This version is simplified for teaching: it reports failure rather than
 * resizing when no valid hop sequence exists.
 */
public class HopscotchHashingEducationalDemo {

    private static final int CAPACITY = 13;
    private static final int H = 4;
    private final Integer[] table = new Integer[CAPACITY];

    private int home(int key) {
        return Math.floorMod(key, CAPACITY);
    }

    public void demonstrate() {
        System.out.println("Hopscotch hashing keeps every key within H = " + H
                + " slots of its home bucket.");
        System.out.println("home(k) = k mod " + CAPACITY);
        System.out.println();

        int[] keys = { 0, 13, 26, 1, 14, 27, 40, 2 };
        for (int key : keys) {
            insert(key);
        }

        System.out.println();
        System.out.println("Final table:");
        printTable();

        System.out.println();
        for (int key : new int[] { 40, 27, 500 }) {
            System.out.println("  lookup(" + key + ") -> " + (contains(key) ? "found" : "absent")
                    + " (window of " + H + " slots from home)");
        }
    }

    private void insert(int key) {
        int homeIndex = home(key);
        System.out.println("Inserting " + key + " (home bucket " + homeIndex + "):");

        int free = -1;
        for (int offset = 0; offset < CAPACITY; offset++) {
            int idx = (homeIndex + offset) % CAPACITY;
            if (table[idx] == null) {
                free = idx;
                break;
            }
        }
        if (free == -1) {
            System.out.println("  table full; a real table would resize");
            return;
        }

        int distance = Math.floorMod(free - homeIndex, CAPACITY);
        while (distance >= H) {
            int hopped = hopCloser(free, homeIndex);
            if (hopped == -1) {
                System.out.println("  no valid hop; a real table would resize");
                return;
            }
            System.out.println("  hopped empty slot from " + free + " to " + hopped);
            free = hopped;
            distance = Math.floorMod(free - homeIndex, CAPACITY);
        }

        table[free] = key;
        System.out.println("  placed " + key + " at index " + free
                + " (offset " + distance + " from home)");
    }

    /**
     * Moves the empty slot at emptyIndex closer to homeIndex by swapping it with
     * an earlier resident whose home neighbourhood still covers emptyIndex.
     * Returns the new empty index, or -1 if no swap is possible.
     */
    private int hopCloser(int emptyIndex, int homeIndex) {
        for (int back = H - 1; back >= 1; back--) {
            int candidate = Math.floorMod(emptyIndex - back, CAPACITY);
            Integer resident = table[candidate];
            if (resident == null) {
                continue;
            }
            int residentHome = home(resident);
            int spanToEmpty = Math.floorMod(emptyIndex - residentHome, CAPACITY);
            if (spanToEmpty < H) {
                table[emptyIndex] = resident;
                table[candidate] = null;
                return candidate;
            }
        }
        return -1;
    }

    private boolean contains(int key) {
        int homeIndex = home(key);
        for (int offset = 0; offset < H; offset++) {
            int idx = (homeIndex + offset) % CAPACITY;
            if (table[idx] != null && table[idx] == key) {
                return true;
            }
        }
        return false;
    }

    private void printTable() {
        System.out.print("  index: ");
        for (int i = 0; i < CAPACITY; i++) {
            System.out.printf("%3d ", i);
        }
        System.out.println();
        System.out.print("  value: ");
        for (int i = 0; i < CAPACITY; i++) {
            System.out.printf("%3s ", table[i] == null ? "." : table[i]);
        }
        System.out.println();
    }
}
