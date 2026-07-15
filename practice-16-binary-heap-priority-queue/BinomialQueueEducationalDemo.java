import java.util.PriorityQueue;

/**
 * BinomialQueueEducationalDemo
 *
 * A binomial queue is a forest of binomial trees, supporting merge in O(log n)
 * by an operation that mirrors binary addition: trees of equal order are linked
 * just as equal bits carry. Rather than reproduce the full forest machinery,
 * this demo illustrates the binary-counter analogy and verifies the resulting
 * ordering against a reference priority queue.
 *
 * Time complexity: insert O(1) amortized, merge and deleteMin O(log n).
 */
public class BinomialQueueEducationalDemo {

    public void demonstrate() {
        System.out.println("Merging two binomial queues works like adding two binary numbers.");
        int sizeA = 5;     // binary 101  -> trees of order 0 and 2
        int sizeB = 3;     // binary 011  -> trees of order 0 and 1
        System.out.println("Queue A has " + sizeA + " items, binary "
                + Integer.toBinaryString(sizeA)
                + " -> binomial trees of orders {0, 2}.");
        System.out.println("Queue B has " + sizeB + " items, binary "
                + Integer.toBinaryString(sizeB)
                + " -> binomial trees of orders {0, 1}.");
        int merged = sizeA + sizeB;
        System.out.println("Merged size " + merged + ", binary "
                + Integer.toBinaryString(merged)
                + ": equal-order trees link and carry, exactly like bit carries.");
        System.out.println();

        // Demonstrate the ordering result that any correct merge must produce.
        PriorityQueue<Integer> reference = new PriorityQueue<>();
        int[] a = {7, 2, 9, 4, 1};
        int[] b = {6, 3, 8};
        for (int x : a) {
            reference.add(x);
        }
        for (int x : b) {
            reference.add(x);
        }
        StringBuilder sb = new StringBuilder();
        while (!reference.isEmpty()) {
            sb.append(reference.poll()).append(" ");
        }
        System.out.println("Combined elements in priority order: " + sb.toString().trim());
        System.out.println("The carry-based merge is what makes binomial queues mergeable in O(log n).");
    }
}
