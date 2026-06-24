import java.util.Arrays;

public class MergeSortExample {
    public static void mergeSort(int[] values) {
        // Merge sort divides the array, recursively sorts each half, then merges.
        if (values.length <= 1) {
            return;
        }

        int middle = values.length / 2;
        int[] left = Arrays.copyOfRange(values, 0, middle);
        int[] right = Arrays.copyOfRange(values, middle, values.length);

        mergeSort(left);
        mergeSort(right);
        merge(values, left, right);
    }

    private static void merge(int[] values, int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                values[k++] = left[i++];
            } else {
                values[k++] = right[j++];
            }
        }

        while (i < left.length) {
            values[k++] = left[i++];
        }
        while (j < right.length) {
            values[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        int[] values = {9, 3, 7, 1, 5};
        mergeSort(values);
        System.out.println(Arrays.toString(values));
    }
}
