public class BinarySearchExample {
    public static int binarySearch(int[] sortedValues, int target) {
        // Binary search repeatedly discards half of a sorted array.
        int left = 0;
        int right = sortedValues.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (sortedValues[middle] == target) {
                return middle;
            } else if (sortedValues[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] values = {2, 4, 6, 8, 10, 12};
        System.out.println("index of 10 = " + binarySearch(values, 10));
    }
}
