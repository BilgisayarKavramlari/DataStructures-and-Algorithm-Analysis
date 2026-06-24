public class ArraysExample {
    public static void main(String[] args) {
        // Arrays store fixed-size sequences of values of the same type.
        int[] scores = {88, 92, 75, 100, 81};
        int total = 0;

        for (int i = 0; i < scores.length; i++) {
            total += scores[i];
            System.out.println("score[" + i + "] = " + scores[i]);
        }

        double average = (double) total / scores.length;
        System.out.println("Average = " + average);
    }
}
