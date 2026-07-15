/**
 * SeparateChainingDemo
 *
 * Exercises the separate-chaining table, deliberately inserting keys that
 * collide so the chains grow visibly. Shows that several keys can share a slot
 * yet remain individually retrievable.
 *
 * Time complexity: O(1 + load factor) expected per operation.
 */
public class SeparateChainingDemo {

    public void demonstrate() {
        SeparateChainingHashTable table = new SeparateChainingHashTable(7);
        int[] keys = {1, 8, 15, 3, 10, 5, 22};   // 1,8,15,22 all hash to slot 1
        for (int k : keys) {
            table.insert(k);
        }
        System.out.println("After inserting " + java.util.Arrays.toString(keys) + ":");
        table.printChains();
        System.out.println();
        System.out.println("contains(15)? " + table.contains(15));
        System.out.println("contains(99)? " + table.contains(99));
        table.remove(8);
        System.out.println("After removing 8, slot 1 chain shrinks:");
        table.printChains();
        System.out.printf("Load factor = %.2f%n", table.loadFactor());
    }
}
