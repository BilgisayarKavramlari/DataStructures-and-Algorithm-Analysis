/**
 * PolynomialHashDemo
 *
 * Explains Horner's rule for evaluating a polynomial hash efficiently. The hash
 * treats the string as a base-b number and reduces modulo the table size at each
 * step to avoid overflow while preserving the distribution.
 *
 * Time complexity: O(L) using Horner's rule instead of O(L^2) naive powers.
 */
public class PolynomialHashDemo {

    public void demonstrate() {
        String key = "HASH";
        int base = 37;
        int tableSize = 1009;
        System.out.println("Evaluating hash of \"" + key + "\" with base " + base
                + " via Horner's rule:");
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            int c = key.charAt(i);
            hash = (base * hash + c) % tableSize;
            System.out.println("  after char '" + key.charAt(i) + "' (code " + c
                    + "): running hash = " + hash);
        }
        System.out.println("Final hash slot: " + hash);
        System.out.println();
        System.out.println("Reducing mod tableSize each step keeps the value small without changing it.");
    }
}
