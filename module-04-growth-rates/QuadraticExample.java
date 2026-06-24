public class QuadraticExample {
    public static void printPairs(int[] values) {
        // O(n^2): for each element, the inner loop scans all elements.
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length; j++) {
                System.out.println(values[i] + ", " + values[j]);
            }
        }
    }

    public static void main(String[] args) {
        printPairs(new int[] {1, 2, 3});
    }
}
