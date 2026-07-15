/**
 * AccountingMethodDemo
 *
 * Illustrates the accounting (banker's) method of amortized analysis. We charge
 * each append a fixed amortized price and store the surplus as "credit" on the
 * inserted element. When a resize happens, the saved credit pays for copying
 * the elements, so no single operation is ever charged more than the constant
 * amortized price.
 *
 * Charging scheme used here: pay 3 credits per append.
 *   - 1 credit pays to write the new element.
 *   - 1 credit is saved on the new element to fund copying it later.
 *   - 1 credit is saved to fund copying an old element that has already used up
 *     its own saved credit.
 *
 * Invariant: the bank balance never goes negative, which proves the amortized
 * charge of 3 is sufficient.
 *
 * Time complexity: O(n) to simulate n appends. Space complexity: O(1).
 */
public class AccountingMethodDemo {

    private static final int AMORTIZED_CHARGE = 3;

    public void demonstrate() {
        System.out.println("Accounting method: charge " + AMORTIZED_CHARGE
                + " credits per append, spend saved credit on resizes.");
        System.out.println();
        System.out.printf("%-8s %-10s %-10s %-10s %-10s%n",
                "append", "charged", "actual", "balance", "capacity");

        int capacity = 1;
        int size = 0;
        long balance = 0;

        for (int value = 1; value <= 16; value++) {
            int actual;
            if (size == capacity) {
                actual = size + 1;
                capacity *= 2;
            } else {
                actual = 1;
            }
            balance += AMORTIZED_CHARGE;
            balance -= actual;
            size++;
            System.out.printf("%-8d %-10d %-10d %-10d %-10d%n",
                    value, AMORTIZED_CHARGE, actual, balance, capacity);
        }

        System.out.println();
        System.out.println("The balance never drops below zero, so charging 3 per append");
        System.out.println("safely covers every resize: amortized cost is O(1).");
    }
}
