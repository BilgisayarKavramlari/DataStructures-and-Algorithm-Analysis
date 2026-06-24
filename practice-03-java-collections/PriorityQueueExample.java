import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        // PriorityQueue removes the smallest item first by default.
        PriorityQueue<Integer> priorities = new PriorityQueue<>();
        priorities.add(5);
        priorities.add(1);
        priorities.add(3);

        while (!priorities.isEmpty()) {
            System.out.println("Next priority: " + priorities.remove());
        }
    }
}
