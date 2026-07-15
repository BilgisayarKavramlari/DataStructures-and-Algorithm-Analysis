import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * BucketSortIntro
 *
 * Distributes values into buckets by range, sorts each bucket, then concatenates
 * them. When the input is roughly uniform over a known range, the buckets stay
 * small and the overall cost is close to linear.
 *
 * Invariant: every value lands in the bucket whose range contains it; buckets
 * are in increasing range order.
 *
 * Time complexity: O(n) expected for uniform input, O(n^2) worst case when all
 * values fall in one bucket. Space complexity: O(n).
 */
public class BucketSortIntro {

    public static void sort(int[] a, int maxValue) {
        int bucketCount = 10;
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }
        // Map each value to a bucket by its range.
        for (int v : a) {
            int index = (int) ((long) v * bucketCount / (maxValue + 1));
            buckets.get(index).add(v);
        }
        int pos = 0;
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);        // each small bucket sorted internally
            for (int v : bucket) {
                a[pos++] = v;
            }
        }
    }

    public void demonstrate() {
        int[] a = {78, 17, 39, 26, 72, 94, 21, 12, 23, 68};
        System.out.println("Before: " + java.util.Arrays.toString(a));
        sort(a, 100);
        System.out.println("After : " + java.util.Arrays.toString(a));
        System.out.println("Uniform data spreads evenly across buckets, giving near-linear time.");
    }
}
