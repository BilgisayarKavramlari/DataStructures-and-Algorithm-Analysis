public class ConstantExample {
    public static int firstElement(int[] values) {
        // O(1): one array access, regardless of input length.
        return values[0];
    }

    public static void main(String[] args) {
        int[] values = {10, 20, 30, 40};
        System.out.println(firstElement(values));
    }
}
