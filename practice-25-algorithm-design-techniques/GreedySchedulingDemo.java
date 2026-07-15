import java.util.Arrays;

/**
 * GreedySchedulingDemo
 *
 * The activity-selection problem: choose the largest set of mutually compatible
 * intervals. The greedy rule is to always pick the activity that finishes
 * earliest among those still compatible, which provably yields a maximum-size
 * selection. This is a canonical example of a greedy choice being globally
 * optimal.
 *
 * Invariant: after each pick, only activities starting at or after the last
 * chosen finish time remain candidates.
 *
 * Time complexity: O(n log n) for sorting by finish time. Space complexity: O(n).
 */
public class GreedySchedulingDemo {

    public void demonstrate() {
        int[][] activities = {
            {1, 4}, {3, 5}, {0, 6}, {5, 7}, {3, 9}, {5, 9}, {6, 10}, {8, 11}, {12, 14}, {2, 14}
        };
        Arrays.sort(activities, (a, b) -> Integer.compare(a[1], b[1]));

        System.out.println("Activity selection: pick earliest-finishing compatible activities.");
        System.out.println("Activities sorted by finish time (start, finish):");
        for (int[] a : activities) {
            System.out.println("  [" + a[0] + ", " + a[1] + "]");
        }
        System.out.println();

        int lastFinish = -1;
        int count = 0;
        System.out.println("Greedy selection:");
        for (int[] a : activities) {
            if (a[0] >= lastFinish) {
                System.out.println("  select [" + a[0] + ", " + a[1] + "]");
                lastFinish = a[1];
                count++;
            }
        }
        System.out.println("  selected " + count + " activities (maximum possible).");
    }
}
