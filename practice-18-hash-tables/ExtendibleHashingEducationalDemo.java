import java.util.ArrayList;
import java.util.List;

/**
 * ExtendibleHashingEducationalDemo
 *
 * Concept:
 *   Extendible hashing is a dynamic, disk-oriented scheme that grows gracefully
 *   without rehashing every key. It keeps a directory of 2^globalDepth pointers
 *   to buckets. Each bucket has a localDepth telling how many leading bits of
 *   the hash actually distinguish its keys.
 *
 *   When a bucket overflows:
 *     - if localDepth < globalDepth, split that bucket only and redistribute;
 *     - if localDepth == globalDepth, double the directory first, then split.
 *
 *   This means most insertions touch a single bucket, and the expensive
 *   directory doubling happens rarely.
 *
 * Invariant:
 *   A key whose hash has prefix p is reached by directory[p], and all keys in a
 *   bucket of localDepth d share the same top d hash bits.
 *
 * Time complexity: lookup is O(1) (one directory index plus a bucket scan).
 *   Insertion is O(1) amortized; a split touches one bucket, a doubling copies
 *   the directory. Space complexity: O(number of keys + directory size).
 *
 * Simplifications for teaching: hashing uses the low bits of the integer key
 * read most-significant-first, and bucket capacity is small so splits occur
 * often and visibly.
 */
public class ExtendibleHashingEducationalDemo {

    private static final int BUCKET_CAPACITY = 2;
    private static final int HASH_BITS = 4;

    private static class Bucket {
        int localDepth;
        List<Integer> keys = new ArrayList<>();

        Bucket(int localDepth) {
            this.localDepth = localDepth;
        }
    }

    private int globalDepth = 1;
    private List<Bucket> directory = new ArrayList<>();

    public void demonstrate() {
        Bucket b0 = new Bucket(1);
        Bucket b1 = new Bucket(1);
        directory.add(b0);
        directory.add(b1);

        System.out.println("Extendible hashing: directory of 2^globalDepth pointers,");
        System.out.println("bucket capacity = " + BUCKET_CAPACITY + ", hash = top " + HASH_BITS + " bits of key.");
        System.out.println();

        int[] keys = { 1, 4, 5, 9, 12, 7, 0, 13 };
        for (int key : keys) {
            insert(key);
        }

        System.out.println();
        System.out.println("Final directory (globalDepth = " + globalDepth + "):");
        printDirectory();
    }

    private int prefix(int key, int depth) {
        int hash = key & ((1 << HASH_BITS) - 1);
        return hash >> (HASH_BITS - depth);
    }

    private void insert(int key) {
        System.out.println("Insert " + key + " (hash bits "
                + toBits(key & ((1 << HASH_BITS) - 1)) + "):");
        int index = prefix(key, globalDepth);
        Bucket bucket = directory.get(index);

        if (bucket.keys.size() < BUCKET_CAPACITY) {
            bucket.keys.add(key);
            System.out.println("  directory[" + index + "] has room; stored.");
            return;
        }

        System.out.println("  bucket overflow (localDepth " + bucket.localDepth
                + ", globalDepth " + globalDepth + ")");
        if (bucket.localDepth == globalDepth) {
            doubleDirectory();
        }
        splitBucket(index);
        insert(key);
    }

    private void doubleDirectory() {
        System.out.println("  doubling directory: globalDepth " + globalDepth
                + " -> " + (globalDepth + 1));
        List<Bucket> expanded = new ArrayList<>();
        for (Bucket b : directory) {
            expanded.add(b);
            expanded.add(b);
        }
        directory = expanded;
        globalDepth++;
    }

    private void splitBucket(int index) {
        Bucket old = directory.get(index);
        int newDepth = old.localDepth + 1;
        Bucket zero = new Bucket(newDepth);
        Bucket one = new Bucket(newDepth);

        for (int key : old.keys) {
            int bit = prefix(key, newDepth) & 1;
            if (bit == 0) {
                zero.keys.add(key);
            } else {
                one.keys.add(key);
            }
        }

        int highPrefix = prefix(index << (HASH_BITS - globalDepth), old.localDepth);
        for (int i = 0; i < directory.size(); i++) {
            if (prefix(i << (HASH_BITS - globalDepth), old.localDepth) == highPrefix) {
                int decidingBit = (i >> (globalDepth - newDepth)) & 1;
                directory.set(i, decidingBit == 0 ? zero : one);
            }
        }
        System.out.println("  split bucket into two of localDepth " + newDepth);
    }

    private void printDirectory() {
        for (int i = 0; i < directory.size(); i++) {
            Bucket b = directory.get(i);
            System.out.println("  directory[" + toBits(i, globalDepth) + "] -> localDepth "
                    + b.localDepth + ", keys " + b.keys);
        }
    }

    private String toBits(int value) {
        return toBits(value, HASH_BITS);
    }

    private String toBits(int value, int width) {
        StringBuilder sb = new StringBuilder();
        for (int i = width - 1; i >= 0; i--) {
            sb.append((value >> i) & 1);
        }
        return sb.toString();
    }
}
