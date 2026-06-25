import java.util.PriorityQueue;

/**
 * EventSimulationDemo
 *
 * Shows the canonical priority-queue application: a discrete event simulation.
 * Events carry a timestamp and are processed in time order regardless of the
 * order they were scheduled, which is exactly what a min-priority-queue on time
 * delivers.
 *
 * Time complexity: O(e log e) to process e events.
 */
public class EventSimulationDemo {

    /** An event with a firing time and a description. */
    static class Event implements Comparable<Event> {
        int time;
        String description;

        Event(int time, String description) {
            this.time = time;
            this.description = description;
        }

        @Override
        public int compareTo(Event other) {
            return Integer.compare(this.time, other.time);
        }
    }

    public void demonstrate() {
        PriorityQueue<Event> queue = new PriorityQueue<>();
        // Scheduled out of order on purpose.
        queue.add(new Event(30, "customer C leaves"));
        queue.add(new Event(10, "customer A arrives"));
        queue.add(new Event(20, "customer B arrives"));
        queue.add(new Event(15, "customer A served"));

        System.out.println("Events were scheduled out of order. Processing in time order:");
        while (!queue.isEmpty()) {
            Event e = queue.poll();
            System.out.println("  t=" + e.time + "  " + e.description);
        }
        System.out.println("The priority queue always yields the next event by smallest timestamp.");
    }
}
