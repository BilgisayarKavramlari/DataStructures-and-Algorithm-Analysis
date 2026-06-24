public class LoopAnalysisExamples {
    public static int triangularNumber(int n) {
        // This loop runs n times, so the running time is O(n).
        int total = 0;
        for (int i = 1; i <= n; i++) {
            total += i;
        }
        return total;
    }

    public static int nestedCounter(int n) {
        // The inner loop runs 1 + 2 + ... + n times, which is O(n^2).
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("triangular = " + triangularNumber(5));
        System.out.println("nested count = " + nestedCounter(5));
    }
}
