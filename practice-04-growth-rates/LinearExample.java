public class LinearExample {
    public static int sum(int[] values) {
        // O(n): the loop visits each element once.
        int total = 0;
        for (int value : values) {
            total += value;
        }
        return total;
    }

    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5};
        System.out.println("sum = " + sum(values));
    }
}
