import java.util.HashSet;
import java.util.TreeSet;

/**
 * EqualsCompareToConsistencyDemo
 *
 * Demonstrates why compareTo should be consistent with equals. When the two
 * disagree, the same objects behave differently in a HashSet (which uses equals
 * and hashCode) than in a TreeSet (which uses compareTo), producing confusing
 * results.
 *
 * Time complexity: O(n log n) for the TreeSet operations.
 */
public class EqualsCompareToConsistencyDemo {

    static class Money implements Comparable<Money> {
        int cents;

        Money(int cents) {
            this.cents = cents;
        }

        // compareTo uses cents...
        @Override
        public int compareTo(Money other) {
            return Integer.compare(this.cents, other.cents);
        }

        // ...but equals here uses object identity, which is INCONSISTENT.
        @Override
        public boolean equals(Object o) {
            return this == o;
        }

        @Override
        public int hashCode() {
            return System.identityHashCode(this);
        }

        @Override
        public String toString() {
            return cents + "c";
        }
    }

    public void demonstrate() {
        Money a = new Money(100);
        Money b = new Money(100);    // equal value, different identity

        HashSet<Money> hashSet = new HashSet<>();
        hashSet.add(a);
        hashSet.add(b);
        System.out.println("HashSet uses equals/hashCode (identity here): size = "
                + hashSet.size());

        TreeSet<Money> treeSet = new TreeSet<>();
        treeSet.add(a);
        treeSet.add(b);
        System.out.println("TreeSet uses compareTo (value here): size = "
                + treeSet.size());
        System.out.println();
        System.out.println("The same two objects count as 2 in the hash set but 1 in the tree set.");
        System.out.println("Keep compareTo consistent with equals to avoid this divergence.");
    }
}
