/**
 * Main - Practice 15: Java Ordered Collections
 *
 * Demonstrates Comparable natural ordering, external Comparators, TreeSet and
 * TreeMap, NavigableSet and NavigableMap navigation, and two ordering pitfalls:
 * losing elements to a non-total comparator and inconsistency between compareTo
 * and equals.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("==== Practice 15: Java Ordered Collections ====");
        run("Comparable natural order", new ComparableStudentDemo()::demonstrate);
        run("External comparators", new ComparatorDemo()::demonstrate);
        run("TreeSet", new TreeSetDemo()::demonstrate);
        run("TreeMap", new TreeMapDemo()::demonstrate);
        run("NavigableSet", new NavigableSetDemo()::demonstrate);
        run("NavigableMap", new NavigableMapDemo()::demonstrate);
        run("Ordering pitfalls", new OrderingPitfallsDemo()::demonstrate);
        run("compareTo / equals consistency", new EqualsCompareToConsistencyDemo()::demonstrate);
        System.out.println();
        System.out.println("Ordered collections study complete.");
    }

    private static void run(String title, Runnable demo) {
        System.out.println();
        System.out.println("--- " + title + " ---");
        demo.run();
    }
}
