/** Main driver for Practice 18: Hash Tables. */
public class Main {
    public static void main(String[] args) {
        System.out.println("CS 3345 Practice 18: Hash Tables");
        System.out.println("Related Course Module: Module 6");
        System.out.println("Weiss topic: Chapter 5, Hashing");
        System.out.println("Goal: trace complete plain-Java examples for live teaching.\n");
        IntegerHashDemo.run();
        StringHashDemo.run();
        PolynomialHashDemo.run();
        SeparateChainingHashTable.run();
        SeparateChainingDemo.run();
        LinearProbingHashTable.run();
        LinearProbingDemo.run();
        QuadraticProbingHashTable.run();
        QuadraticProbingDemo.run();
        DoubleHashingDemo.run();
        LazyDeletionDemo.run();
        LoadFactorExperiment.run();
        RehashingDemo.run();
        JavaHashMapHashSetDemo.run();
        CuckooHashingEducationalDemo.run();
        HopscotchHashingEducationalDemo.run();
        UniversalHashingEducationalDemo.run();
        PerfectHashingEducationalDemo.run();
        ExtendibleHashingEducationalDemo.run();
        System.out.println("End of Practice 18. Re-run after changing input values to experiment.");
    }
}
