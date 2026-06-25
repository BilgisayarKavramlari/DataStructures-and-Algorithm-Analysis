/**
 * BinomialQueueAmortizedDemo
 *
 * Explains why merging binomial queues (and therefore insertion) is amortized
 * O(1) even though a single merge can touch O(log n) trees. Merging two
 * binomial queues mirrors binary addition: combining two trees of equal rank
 * produces a carry into the next rank. A long run of carries is expensive once,
 * but it leaves behind a sparse structure that makes the next several inserts
 * cheap.
 *
 * We demonstrate by inserting keys 1..n and printing the number of trees
 * carried (linked) at each step, which equals the number of trailing ones in
 * the binary representation of the current size, exactly as in binary counting.
 *
 * Time complexity of the simulation: O(n log n) for the bit counting.
 * Space complexity: O(1).
 */
public class BinomialQueueAmortizedDemo {

    public void demonstrate() {
        System.out.println("Insertion into a binomial queue behaves like incrementing a binary counter.");
        System.out.println("The link (carry) cost equals the number of trailing 1-bits in the size.");
        System.out.println();
        System.out.printf("%-8s %-12s %-10s%n", "insert", "size(binary)", "links");

        long totalLinks = 0;
        for (int size = 1; size <= 16; size++) {
            int previous = size - 1;
            int links = Integer.numberOfTrailingZeros(~previous);
            totalLinks += links;
            System.out.printf("%-8d %-12s %-10d%n",
                    size, Integer.toBinaryString(size), links);
        }

        System.out.println();
        System.out.println("Total links over 16 inserts: " + totalLinks
                + " (about n, so amortized O(1) per insert).");
    }
}
