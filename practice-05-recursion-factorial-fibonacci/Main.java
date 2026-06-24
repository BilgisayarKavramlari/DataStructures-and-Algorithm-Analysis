/** Main driver for Practice 05: Recursion Factorial Fibonacci. */
public class Main {
    public static void main(String[] args) {
        System.out.println("CS 3345 Practice 05: Recursion Factorial Fibonacci");
        System.out.println("Related Course Module: Module 2");
        System.out.println("Weiss topic: Chapter 1 recursion review and Chapter 2 recursive analysis");
        System.out.println("Goal: trace complete plain-Java examples for live teaching.\n");
        RecursivePrintDemo.run();
        FactorialIterative.run();
        FactorialRecursive.run();
        FibonacciNaiveRecursive.run();
        FibonacciIterative.run();
        FibonacciMemoized.run();
        CallStackTraceDemo.run();
        SafeStackOverflowDemo.run();
        DuplicateWorkDemo.run();
        System.out.println("End of Practice 05. Re-run after changing input values to experiment.");
    }
}
