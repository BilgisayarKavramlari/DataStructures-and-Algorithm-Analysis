/**
 * DivideAndConquerDemo
 *
 * Illustrates the divide-and-conquer paradigm with two examples: merge sort
 * (split, recurse, merge) and a recurrence-driven view of why splitting a
 * problem of size n into two halves plus linear combining yields O(n log n).
 * The general pattern: divide into subproblems, conquer recursively, combine.
 *
 * Time complexity: merge sort O(n log n). Space complexity: O(n) for merging.
 */
public class DivideAndConquerDemo {

    private int mergeOperations = 0;

    public void demonstrate() {
        int[] data = { 8, 3, 5, 1, 9, 2, 7, 4 };
        System.out.println("Divide and conquer via merge sort on " + java.util.Arrays.toString(data));
        System.out.println("Each level splits the array in half, then merges sorted halves.");
        System.out.println();

        int[] sorted = mergeSort(data, 0);
        System.out.println();
        System.out.println("  sorted result: " + java.util.Arrays.toString(sorted));
        System.out.println("  total merge comparisons: " + mergeOperations);
        System.out.println("  recurrence T(n) = 2T(n/2) + O(n) solves to O(n log n).");
    }

    private int[] mergeSort(int[] a, int depth) {
        if (a.length <= 1) {
            return a;
        }
        int mid = a.length / 2;
        int[] left = java.util.Arrays.copyOfRange(a, 0, mid);
        int[] right = java.util.Arrays.copyOfRange(a, mid, a.length);
        System.out.println("  " + indent(depth) + "divide " + java.util.Arrays.toString(a));
        int[] sortedLeft = mergeSort(left, depth + 1);
        int[] sortedRight = mergeSort(right, depth + 1);
        return merge(sortedLeft, sortedRight);
    }

    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            mergeOperations++;
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }
        return result;
    }

    private String indent(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("  ");
        }
        return sb.toString();
    }
}
