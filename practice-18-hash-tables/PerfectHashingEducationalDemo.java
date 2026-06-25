import java.util.Random;

/**
 * PerfectHashingEducationalDemo
 *
 * Concept:
 *   Perfect hashing stores a STATIC set of keys with guaranteed worst-case
 *   O(1) lookup and zero collisions. It uses a two-level scheme (the FKS
 *   construction):
 *
 *     Level 1: a universal hash function spreads n keys into n primary buckets.
 *     Level 2: each primary bucket holding b keys gets its own small secondary
 *              table of size b*b, with its own universal hash function chosen
 *              (by retrying) so that the b keys land without any collision.
 *
 *   The b*b sizing is the crucial idea: with a table that large, a random
 *   universal function is collision-free with probability at least 1/2, so a
 *   few retries always succeed.
 *
 * Invariant:
 *   After construction, every key occupies a unique secondary slot, so lookup
 *   evaluates exactly two hash functions and compares once.
 *
 * Time complexity: lookup is worst-case O(1). Construction is expected O(n).
 * Space complexity: expected O(n) total across all secondary tables.
 *
 * This demo builds the structure for a small static key set and verifies that
 * every bucket ends collision-free.
 */
public class PerfectHashingEducationalDemo {

    private static final int PRIME = 100003;
    private final Random random = new Random(7);

    public void demonstrate() {
        int[] keys = { 10, 22, 37, 40, 52, 60, 73, 75 };
        int n = keys.length;

        System.out.println("Building a perfect hash for a static set of " + n + " keys.");
        System.out.println("Level 1 spreads keys into " + n + " primary buckets.");
        System.out.println();

        long a1 = 1 + random.nextInt(PRIME - 1);
        long b1 = random.nextInt(PRIME);

        int[][] primaryBuckets = new int[n][];
        int[] counts = new int[n];
        for (int key : keys) {
            int slot = level1(key, a1, b1, n);
            counts[slot]++;
        }
        for (int i = 0; i < n; i++) {
            primaryBuckets[i] = new int[counts[i]];
        }
        int[] fill = new int[n];
        for (int key : keys) {
            int slot = level1(key, a1, b1, n);
            primaryBuckets[slot][fill[slot]++] = key;
        }

        int totalSecondary = 0;
        for (int i = 0; i < n; i++) {
            int b = counts[i];
            int secondarySize = b * b;
            totalSecondary += secondarySize;
            System.out.print("Primary bucket " + i + " holds " + b + " key(s)");
            if (b == 0) {
                System.out.println(" -> empty");
                continue;
            }
            System.out.println(", secondary table size " + secondarySize + ":");
            buildCollisionFreeSecondary(primaryBuckets[i], secondarySize);
        }

        System.out.println();
        System.out.println("Total secondary slots used: " + totalSecondary
                + " (expected O(n) for n = " + n + ")");
        System.out.println("Every key now has a unique slot, giving worst-case O(1) lookup.");
    }

    private void buildCollisionFreeSecondary(int[] bucketKeys, int size) {
        int attempt = 0;
        while (true) {
            attempt++;
            long a = 1 + random.nextInt(PRIME - 1);
            long b = random.nextInt(PRIME);
            Integer[] slots = new Integer[size];
            boolean ok = true;
            for (int key : bucketKeys) {
                int s = (int) (((a * key + b) % PRIME) % size);
                if (slots[s] != null) {
                    ok = false;
                    break;
                }
                slots[s] = key;
            }
            if (ok) {
                System.out.println("    collision-free after " + attempt + " attempt(s)"
                        + " with a=" + a + ", b=" + b);
                for (int s = 0; s < size; s++) {
                    if (slots[s] != null) {
                        System.out.println("      slot " + s + " -> key " + slots[s]);
                    }
                }
                return;
            }
        }
    }

    private int level1(int key, long a, long b, int m) {
        return (int) (((a * key + b) % PRIME) % m);
    }
}
