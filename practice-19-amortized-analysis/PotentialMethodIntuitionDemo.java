/**
 * PotentialMethodIntuitionDemo
 *
 * Builds intuition for the potential method of amortized analysis. We define a
 * potential function on the data structure's state that measures "stored work".
 * The amortized cost of an operation is its actual cost plus the change in
 * potential. Choosing a good potential makes the amortized cost smooth even
 * when actual costs spike.
 *
 * For the doubling array we use the potential
 *   Phi = 2 * size - capacity
 * which is small right after a resize and grows as the array fills, peaking just
 * before the next resize. The stored potential then pays for the copy.
 *
 * Time complexity: O(n) to simulate. Space complexity: O(1).
 */
public class PotentialMethodIntuitionDemo {

    public void demonstrate() {
        System.out.println("Potential method: amortized = actual + (Phi_after - Phi_before).");
        System.out.println("Potential chosen: Phi = 2 * size - capacity.");
        System.out.println();
        System.out.printf("%-8s %-8s %-10s %-8s %-10s%n",
                "append", "actual", "capacity", "Phi", "amortized");

        int capacity = 1;
        int size = 0;
        int phiBefore = 2 * size - capacity;

        for (int value = 1; value <= 16; value++) {
            int actual;
            if (size == capacity) {
                actual = size + 1;
                capacity *= 2;
            } else {
                actual = 1;
            }
            size++;
            int phiAfter = 2 * size - capacity;
            int amortized = actual + (phiAfter - phiBefore);
            System.out.printf("%-8d %-8d %-10d %-8d %-10d%n",
                    value, actual, capacity, phiAfter, amortized);
            phiBefore = phiAfter;
        }

        System.out.println();
        System.out.println("The amortized column stays small and bounded even on resize steps,");
        System.out.println("because the potential drop pays for the expensive copy.");
    }
}
