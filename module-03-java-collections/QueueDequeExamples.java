import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class QueueDequeExamples {
    public static void main(String[] args) {
        // Queue operations model waiting in line.
        Queue<String> helpLine = new ArrayDeque<>();
        helpLine.add("Alice");
        helpLine.add("Bob");
        System.out.println("First helped: " + helpLine.remove());

        // Deque means double-ended queue: add or remove from both ends.
        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("front");
        deque.addLast("back");
        System.out.println("Deque front: " + deque.removeFirst());
        System.out.println("Deque back: " + deque.removeLast());
    }
}
