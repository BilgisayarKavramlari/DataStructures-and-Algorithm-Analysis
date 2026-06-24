public class TimingExperiment {
    public static long sumUpTo(int n) {
        long total = 0;
        for (int i = 1; i <= n; i++) {
            total += i;
        }
        return total;
    }

    public static void main(String[] args) {
        // Timing experiments are approximate, but useful for observing growth.
        int n = 10_000_000;
        long start = System.nanoTime();
        long total = sumUpTo(n);
        long end = System.nanoTime();

        System.out.println("sum = " + total);
        System.out.println("nanoseconds = " + (end - start));
    }
}
