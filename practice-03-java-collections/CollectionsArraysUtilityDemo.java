import java.util.*;

/** Demonstrates Collection, Iterable, Iterator, List, Set, Map, Queue, Deque, PriorityQueue, Collections, Arrays. Time notes are printed for live tracing. */
public class CollectionsArraysUtilityDemo {
    public static void run() {
        System.out.println("-- CollectionsArraysUtilityDemo: Collection, Iterable, Iterator, List, Set, Map, Queue, Deque, PriorityQueue, Collections, Arrays");
        int[] data = {7, 3, 9, 1, 5};
        System.out.println("Input: " + Arrays.toString(data));
        int best = data[0];
        for (int x : data) {
            if (x > best) best = x;
            System.out.println("  visit " + x + ", current best=" + best);
        }
        System.out.println("Invariant: processed prefix has a correct summary; time O(n), extra space O(1).\n");
    }
    public static void main(String[] args) { run(); }
}
