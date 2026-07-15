import java.util.Collections;
import java.util.PriorityQueue;

/**
 * JavaPriorityQueueDemo
 *
 * Shows the standard library java.util.PriorityQueue, a binary heap. By default
 * it is a min-heap by natural order; supplying a reversed comparator turns it
 * into a max-heap. This is the priority queue students should reach for in
 * practice.
 *
 * Time complexity: O(log n) for offer/poll, O(1) for peek.
 */
public class JavaPriorityQueueDemo {

    public void demonstrate() {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int[] data = {40, 10, 30, 20, 50};
        for (int x : data) {
            minHeap.offer(x);
        }
        System.out.println("Min-heap peek (smallest): " + minHeap.peek());
        StringBuilder asc = new StringBuilder();
        while (!minHeap.isEmpty()) {
            asc.append(minHeap.poll()).append(" ");
        }
        System.out.println("Min-heap poll order: " + asc.toString().trim());
        System.out.println();

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : data) {
            maxHeap.offer(x);
        }
        System.out.println("Max-heap peek (largest): " + maxHeap.peek());
        StringBuilder desc = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            desc.append(maxHeap.poll()).append(" ");
        }
        System.out.println("Max-heap poll order: " + desc.toString().trim());
        System.out.println("A reversed comparator is all it takes to flip min into max.");
    }
}
