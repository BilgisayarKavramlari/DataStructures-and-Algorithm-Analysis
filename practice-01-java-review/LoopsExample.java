public class LoopsExample {
    public static void main(String[] args) {
        // A for loop repeats when you know how many times to run.
        for (int i = 1; i <= 5; i++) {
            System.out.println("for loop count = " + i);
        }

        // A while loop repeats while a condition remains true.
        int value = 16;
        while (value > 1) {
            System.out.println("halving value: " + value);
            value = value / 2;
        }
    }
}
