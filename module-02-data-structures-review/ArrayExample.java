public class ArrayExample {
    public static void main(String[] args) {
        // Arrays give O(1) access by index, but their size is fixed.
        int[] values = {12, 7, 25, 9};

        System.out.println("First value: " + values[0]);
        values[1] = 10;

        for (int i = 0; i < values.length; i++) {
            System.out.println("values[" + i + "] = " + values[i]);
        }
    }
}
