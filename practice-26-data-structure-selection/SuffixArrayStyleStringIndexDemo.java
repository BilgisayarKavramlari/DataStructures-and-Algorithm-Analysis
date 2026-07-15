import java.util.Arrays;

/**
 * SuffixArrayStyleStringIndexDemo
 *
 * A suffix array lists the starting positions of all suffixes of a string in
 * sorted order. It is a compact index that supports fast substring search by
 * binary search over the sorted suffixes, and is the practical alternative to a
 * suffix tree when memory matters.
 *
 * Invariant: the array is a permutation of suffix start positions ordered by the
 * lexicographic order of the suffixes they begin.
 *
 * Time complexity (this educational build): O(n^2 log n) from comparison-based
 *   sorting of suffixes; specialised constructions reach O(n). Substring search
 *   is O(m log n). Space complexity: O(n).
 */
public class SuffixArrayStyleStringIndexDemo {

    public void demonstrate() {
        String text = "banana";
        System.out.println("Building a suffix array for \"" + text + "\".");

        Integer[] suffixStarts = new Integer[text.length()];
        for (int i = 0; i < text.length(); i++) {
            suffixStarts[i] = i;
        }
        Arrays.sort(suffixStarts, (a, b) -> text.substring(a).compareTo(text.substring(b)));

        System.out.println("  sorted suffixes:");
        for (int start : suffixStarts) {
            System.out.println("    index " + start + ": " + text.substring(start));
        }

        String pattern = "ana";
        boolean found = containsViaBinarySearch(text, suffixStarts, pattern);
        System.out.println("  substring search for \"" + pattern + "\": "
                + (found ? "present" : "absent"));
        System.out.println("  binary search over sorted suffixes locates a pattern in O(m log n).");
    }

    private boolean containsViaBinarySearch(String text, Integer[] suffixStarts, String pattern) {
        int low = 0;
        int high = suffixStarts.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            String suffix = text.substring(suffixStarts[mid]);
            int cmp = compareToPrefix(suffix, pattern);
            if (cmp == 0) {
                return true;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    private int compareToPrefix(String suffix, String pattern) {
        int limit = Math.min(suffix.length(), pattern.length());
        for (int i = 0; i < limit; i++) {
            int diff = suffix.charAt(i) - pattern.charAt(i);
            if (diff != 0) {
                return diff;
            }
        }
        if (suffix.length() >= pattern.length()) {
            return 0;
        }
        return -1;
    }
}
