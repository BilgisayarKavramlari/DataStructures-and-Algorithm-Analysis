/**
 * AggregateAnalysisDemo
 *
 * Illustrates the aggregate method of amortized analysis: bound the TOTAL cost
 * of a sequence of n operations, then divide by n to get the amortized cost per
 * operation.
 *
 * For capacity-doubling appends starting from capacity 1, the copy work over n
 * appends is 1 + 2 + 4 + ... + the largest power of two below n, which is less
 * than 2n. Adding the n cheap writes gives total work below 3n, hence O(1)
 * amortized per append.
 *
 * Time complexity of the analysis routine: O(n). Space complexity: O(1).
 */
public class AggregateAnalysisDemo {

    public void demonstrate() {
        int[] sizes = { 16, 64, 256, 1024 };
        System.out.println("Aggregate method: total cost of n appends, divided by n.");
        System.out.println();
        System.out.printf("%-8s %-14s %-14s %-16s%n",
                "n", "writes", "copies", "amortized/op");

        for (int n : sizes) {
            DynamicArray array = new DynamicArray(1);
            long totalCost = 0;
            for (int i = 0; i < n; i++) {
                totalCost += array.add(i);
            }
            long copies = array.totalCopies();
            double amortized = (double) totalCost / n;
            System.out.printf("%-8d %-14d %-14d %-16.3f%n", n, n, copies, amortized);
        }

        System.out.println();
        System.out.println("As n grows the amortized cost stays near a small constant,");
        System.out.println("confirming the < 3n total-work bound.");
    }
}
