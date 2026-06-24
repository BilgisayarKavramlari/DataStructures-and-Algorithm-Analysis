import java.util.ArrayDeque;

public class QueueExample {
    public static void main(String[] args) {
        // A queue is first-in, first-out (FIFO): the oldest item is removed first.
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.add("Alice");
        queue.add("Bob");
        queue.add("Carol");

        while (!queue.isEmpty()) {
            System.out.println("Serving: " + queue.remove());
        }
    }
}
