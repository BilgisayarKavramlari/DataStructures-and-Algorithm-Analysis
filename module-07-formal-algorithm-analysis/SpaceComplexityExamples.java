public class SpaceComplexityExamples {
    public static int sumInPlace(int[] values) {
        // O(1) extra space: only one total variable is used.
        int total = 0;
        for (int value : values) {
            total += value;
        }
        return total;
    }

    public static int[] copyArray(int[] values) {
        // O(n) extra space: the new array grows with the input size.
        int[] copy = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            copy[i] = values[i];
        }
        return copy;
    }

    public static void main(String[] args) {
        int[] values = {1, 2, 3};
        System.out.println("sum = " + sumInPlace(values));
        System.out.println("copy length = " + copyArray(values).length);
    }
}
