/**
 * IntegerHashDemo
 *
 * Shows the simplest hash function for integer keys: take the key modulo the
 * table size. A prime table size spreads clustered keys more evenly than a power
 * of two, which would only keep the low bits.
 *
 * Time complexity: O(1) per hash computation.
 */
public class IntegerHashDemo {

    public void demonstrate() {
        int tableSize = 11;            // prime size
        int[] keys = {0, 11, 22, 5, 16, 27, 7};
        System.out.println("Hashing integers with h(k) = k mod " + tableSize + ":");
        for (int k : keys) {
            System.out.println("  h(" + k + ") = " + (k % tableSize));
        }
        System.out.println();
        System.out.println("Keys 0, 11, 22 all map to slot 0: that is a collision cluster.");
        System.out.println("A prime modulus mixes the bits better than a power-of-two size.");
    }
}
