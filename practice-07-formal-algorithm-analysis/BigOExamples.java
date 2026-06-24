public class BigOExamples {
    public static void examples(int n) {
        // O(1): constant amount of work.
        System.out.println("constant step");

        // O(n): one loop that grows with n.
        for (int i = 0; i < n; i++) {
            System.out.println("linear step " + i);
        }

        // O(n^2): nested loops each grow with n.
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.println("pair " + row + "," + col);
            }
        }
    }

    public static void main(String[] args) {
        examples(3);
    }
}
