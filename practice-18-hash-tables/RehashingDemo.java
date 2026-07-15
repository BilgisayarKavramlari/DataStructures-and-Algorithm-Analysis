/**
 * RehashingDemo
 *
 * When the load factor crosses a threshold, the table is rebuilt into a larger
 * array and every key is reinserted with the new modulus. Rehashing is expensive
 * (O(n)) but rare, so its cost amortizes to O(1) per insertion.
 *
 * Time complexity: O(n) per rehash; O(1) amortized per insert overall.
 */
public class RehashingDemo {

    private Integer[] table;
    private int size;

    public RehashingDemo() {
        table = new Integer[5];
    }

    private int hash(int key, int capacity) {
        return Math.floorMod(key, capacity);
    }

    public void insert(int key) {
        if ((double) (size + 1) / table.length > 0.7) {
            rehash();
        }
        int index = hash(key, table.length);
        while (table[index] != null) {
            index = (index + 1) % table.length;
        }
        table[index] = key;
        size++;
    }

    private void rehash() {
        Integer[] old = table;
        int newCapacity = nextPrime(old.length * 2);
        System.out.println("  rehashing from capacity " + old.length
                + " to " + newCapacity);
        table = new Integer[newCapacity];
        size = 0;
        for (Integer key : old) {
            if (key != null) {
                int index = hash(key, table.length);
                while (table[index] != null) {
                    index = (index + 1) % table.length;
                }
                table[index] = key;
                size++;
            }
        }
    }

    private int nextPrime(int n) {
        while (!isPrime(n)) {
            n++;
        }
        return n;
    }

    private boolean isPrime(int n) {
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

    public void demonstrate() {
        System.out.println("Inserting 12 keys into a table that starts with capacity 5:");
        for (int k = 1; k <= 12; k++) {
            insert(k * 3);
        }
        System.out.println("Final capacity = " + table.length + ", size = " + size);
        System.out.printf("Final load factor = %.2f%n", (double) size / table.length);
        System.out.println("Each costly rehash is amortized over the many cheap inserts it enables.");
    }
}
