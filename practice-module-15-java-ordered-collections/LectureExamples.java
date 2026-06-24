import java.util.*;

/** Shared lecture examples for this practice module. */
public class LectureExamples {
    public static void showCoreTrace() {
        int[] values = {7, 3, 9, 1, 5, 8};
        System.out.println("Input values: " + Arrays.toString(values));
        System.out.println("Linear scan maximum: " + max(values));
        System.out.println("Binary-search trace on sorted copy:");
        int[] sorted = values.clone();
        Arrays.sort(sorted);
        traceBinarySearch(sorted, 5);
        System.out.println("Operation count demo for n=" + values.length + ": " + countPairs(values.length) + " pair visits");
    }

    // Invariant: best stores the largest value seen in the processed prefix.
    static int max(int[] a) {
        int best = a[0];
        for (int x : a) if (x > best) best = x;
        return best; // Time O(n), extra space O(1).
    }

    static int countPairs(int n) {
        int count = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                count++;
        return count; // Time O(n^2), extra space O(1).
    }

    static void traceBinarySearch(int[] a, int target) {
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            System.out.println("  low=" + low + " mid=" + mid + " high=" + high + " value=" + a[mid]);
            if (a[mid] == target) return;
            if (a[mid] < target) low = mid + 1; else high = mid - 1;
        }
    }
}
