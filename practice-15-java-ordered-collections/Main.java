/** Main driver for Practice 15: Java Ordered Collections. */
public class Main {
    public static void main(String[] args) {
        System.out.println("CS 3345 Practice 15: Java Ordered Collections");
        System.out.println("Related Course Module: Module 4");
        System.out.println("Weiss topic: Chapter 4, Sets and Maps in the standard library");
        System.out.println("Goal: trace complete plain-Java examples for live teaching.\n");
        ComparableStudentDemo.run();
        ComparatorDemo.run();
        TreeSetDemo.run();
        TreeMapDemo.run();
        NavigableSetDemo.run();
        NavigableMapDemo.run();
        OrderingPitfallsDemo.run();
        EqualsCompareToConsistencyDemo.run();
        System.out.println("End of Practice 15. Re-run after changing input values to experiment.");
    }
}
