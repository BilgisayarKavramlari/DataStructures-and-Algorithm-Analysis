public class RecurrenceExamples {
    public static int binaryRecurrenceWork(int n) {
        // Models T(n) = T(n / 2) + 1, which is logarithmic.
        if (n <= 1) {
            return 1;
        }
        return 1 + binaryRecurrenceWork(n / 2);
    }

    public static int divideAndConquerWork(int n) {
        // Models T(n) = 2T(n / 2) + n, a common merge-sort-style recurrence.
        if (n <= 1) {
            return 1;
        }
        return n + divideAndConquerWork(n / 2) + divideAndConquerWork(n / 2);
    }

    public static void main(String[] args) {
        System.out.println("T(n/2)+1 work for n=16: " + binaryRecurrenceWork(16));
        System.out.println("2T(n/2)+n work for n=16: " + divideAndConquerWork(16));
    }
}
