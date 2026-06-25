/**
 * PrimalityTestingConceptDemo
 *
 * Surveys primality testing as a design-technique case study: a deterministic
 * trial-division test that is simple but slow for large numbers, and the idea
 * behind the randomized Fermat test, which trades a tiny error probability for
 * speed. Randomized testing underpins practical cryptography.
 *
 * Time complexity: trial division O(sqrt(n)); Fermat test O(k log n) modular
 *   exponentiations for k rounds. Space complexity: O(1).
 *
 * Teaching note: the Fermat test can be fooled by Carmichael numbers, which is
 * why production systems use the stronger Miller-Rabin test; the educational
 * focus here is the deterministic-versus-randomized trade-off.
 */
public class PrimalityTestingConceptDemo {

    public void demonstrate() {
        System.out.println("Deterministic trial division on small numbers:");
        for (int n : new int[] { 2, 15, 17, 21, 23, 91, 97 }) {
            System.out.println("  " + n + " is prime? " + isPrimeTrialDivision(n));
        }
        System.out.println();

        System.out.println("Randomized Fermat test idea: if a^(n-1) mod n != 1 for some base a,");
        System.out.println("then n is definitely composite. Passing several random bases gives");
        System.out.println("strong (not absolute) evidence of primality.");
        System.out.println();
        for (int n : new int[] { 17, 21, 97, 100 }) {
            boolean probablyPrime = fermatTest(n, 5);
            System.out.println("  Fermat test on " + n + " -> "
                    + (probablyPrime ? "probably prime" : "composite"));
        }
        System.out.println();
        System.out.println("Trial division is exact but O(sqrt(n)); the randomized test is much");
        System.out.println("faster for huge numbers, accepting a controllable error probability.");
    }

    private boolean isPrimeTrialDivision(int n) {
        if (n < 2) {
            return false;
        }
        for (int d = 2; (long) d * d <= n; d++) {
            if (n % d == 0) {
                return false;
            }
        }
        return true;
    }

    private boolean fermatTest(int n, int rounds) {
        if (n < 4) {
            return n == 2 || n == 3;
        }
        java.util.Random random = new java.util.Random(11);
        for (int i = 0; i < rounds; i++) {
            int a = 2 + random.nextInt(n - 3);
            if (modPow(a, n - 1, n) != 1) {
                return false;
            }
        }
        return true;
    }

    private long modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
}
