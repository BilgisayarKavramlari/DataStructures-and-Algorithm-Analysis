import java.util.Random;

/**
 * UniversalHashingEducationalDemo
 *
 * Concept:
 *   A single fixed hash function can always be defeated by an adversary who
 *   chooses keys that all collide. Universal hashing defeats this by selecting
 *   a hash function at random from a carefully designed family. For any two
 *   distinct keys, the probability of collision over the random choice is at
 *   most 1/m, where m is the table size.
 *
 * The family used here is the classic Carter-Wegman construction:
 *   h(k) = ((a * k + b) mod p) mod m
 * where p is a prime larger than every key, a is drawn from {1, ..., p-1},
 * and b is drawn from {0, ..., p-1}. Each random (a, b) yields a different
 * member of the family.
 *
 * Teaching goal:
 *   Show that no single key set is consistently bad: re-rolling (a, b) changes
 *   which keys collide, so expected performance is good regardless of input.
 *
 * Time complexity: evaluating h is O(1). Space complexity: O(1) for the
 *   parameters plus O(m) for any backing table.
 */
public class UniversalHashingEducationalDemo {

    private static final int PRIME = 100003;
    private final Random random = new Random(42);

    public void demonstrate() {
        int tableSize = 7;
        int[] keys = { 14, 21, 28, 35, 42, 49 };

        System.out.println("Family: h(k) = ((a*k + b) mod " + PRIME + ") mod " + tableSize);
        System.out.println("Keys (all multiples of 7): 14 21 28 35 42 49");
        System.out.println();
        System.out.println("Drawing three random functions from the family and");
        System.out.println("counting collisions for the same key set each time:");
        System.out.println();

        for (int trial = 1; trial <= 3; trial++) {
            long a = 1 + random.nextInt(PRIME - 1);
            long b = random.nextInt(PRIME);
            System.out.println("Function " + trial + ": a = " + a + ", b = " + b);

            int[] buckets = new int[tableSize];
            for (int key : keys) {
                int slot = (int) (((a * key + b) % PRIME) % tableSize);
                buckets[slot]++;
                System.out.println("  h(" + key + ") = " + slot);
            }

            int collisions = 0;
            for (int count : buckets) {
                if (count > 1) {
                    collisions += count - 1;
                }
            }
            System.out.println("  collisions in this trial: " + collisions);
            System.out.println();
        }

        System.out.println("Observation: the colliding keys differ between functions,");
        System.out.println("so an adversary cannot fix one bad input for the whole family.");
    }
}
