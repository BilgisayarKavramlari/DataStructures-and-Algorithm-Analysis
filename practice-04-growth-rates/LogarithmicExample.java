public class LogarithmicExample {
    public static int countHalvings(int n) {
        // O(log n): n is cut in half each iteration.
        int steps = 0;
        while (n > 1) {
            n = n / 2;
            steps++;
        }
        return steps;
    }

    public static void main(String[] args) {
        System.out.println("halving steps for 64 = " + countHalvings(64));
    }
}
