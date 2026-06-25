/**
 * Main - Practice 18: Hash Tables
 *
 * Demonstrates how arbitrary keys are mapped to array indices and how
 * collisions are resolved. Covers integer, string, and polynomial hashing;
 * separate chaining; linear, quadratic, and double-hashing open addressing;
 * lazy deletion; the effect of load factor; rehashing; the Java HashMap and
 * HashSet; and the advanced schemes cuckoo, hopscotch, universal, perfect, and
 * extendible hashing.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("==== Practice 18: Hash Tables ====");
        run("Hashing integers", new IntegerHashDemo()::demonstrate);
        run("Hashing strings", new StringHashDemo()::demonstrate);
        run("Polynomial string hash", new PolynomialHashDemo()::demonstrate);
        run("Separate chaining", new SeparateChainingDemo()::demonstrate);
        run("Linear probing", new LinearProbingDemo()::demonstrate);
        run("Quadratic probing", new QuadraticProbingDemo()::demonstrate);
        run("Double hashing", new DoubleHashingDemo()::demonstrate);
        run("Lazy deletion", new LazyDeletionDemo()::demonstrate);
        run("Load factor experiment", new LoadFactorExperiment()::demonstrate);
        run("Rehashing", new RehashingDemo()::demonstrate);
        run("Java HashMap and HashSet", new JavaHashMapHashSetDemo()::demonstrate);
        run("Cuckoo hashing", new CuckooHashingEducationalDemo()::demonstrate);
        run("Hopscotch hashing", new HopscotchHashingEducationalDemo()::demonstrate);
        run("Universal hashing", new UniversalHashingEducationalDemo()::demonstrate);
        run("Perfect hashing", new PerfectHashingEducationalDemo()::demonstrate);
        run("Extendible hashing", new ExtendibleHashingEducationalDemo()::demonstrate);
        System.out.println();
        System.out.println("Hash table study complete.");
    }

    private static void run(String title, Runnable demo) {
        System.out.println();
        System.out.println("--- " + title + " ---");
        demo.run();
    }
}
