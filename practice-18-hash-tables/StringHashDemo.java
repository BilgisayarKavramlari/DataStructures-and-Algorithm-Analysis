/**
 * StringHashDemo
 *
 * Demonstrates hashing strings. A naive sum of character codes collides for any
 * anagram, so it is a poor hash. A position-weighted (polynomial) scheme spreads
 * anagrams apart, which is why Java's String.hashCode is polynomial.
 *
 * Time complexity: O(L) for a string of length L.
 */
public class StringHashDemo {

    private static int sumHash(String s, int tableSize) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i);
        }
        return sum % tableSize;
    }

    private static int polynomialHash(String s, int tableSize) {
        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash = (37 * hash + s.charAt(i)) % tableSize;
        }
        return (hash + tableSize) % tableSize;
    }

    public void demonstrate() {
        int tableSize = 101;
        String[] words = {"listen", "silent", "enlist", "google", "googel"};
        System.out.println("Naive sum hash collides for anagrams:");
        for (String w : words) {
            System.out.println("  sumHash(" + w + ") = " + sumHash(w, tableSize));
        }
        System.out.println();
        System.out.println("Polynomial hash separates anagrams:");
        for (String w : words) {
            System.out.println("  polyHash(" + w + ") = " + polynomialHash(w, tableSize));
        }
        System.out.println();
        System.out.println("Position weighting is what distinguishes 'listen' from 'silent'.");
    }
}
