/** Main driver for Practice 04: Growth Rates. */
public class Main {
    public static void main(String[] args) {
        System.out.println("CS 3345 Practice 04: Growth Rates");
        System.out.println("Related Course Module: Module 1");
        System.out.println("Weiss topic: Chapter 2, algorithm analysis and growth rates");
        System.out.println("Goal: trace complete plain-Java examples for live teaching.\n");
        ConstantGrowthDemo.run();
        LogarithmicGrowthDemo.run();
        LinearGrowthDemo.run();
        LinearithmicGrowthDemo.run();
        QuadraticGrowthDemo.run();
        CubicGrowthDemo.run();
        ExponentialGrowthDemo.run();
        FactorialGrowthDemo.run();
        TimingExperiment.run();
        OperationCountingDemo.run();
        System.out.println("End of Practice 04. Re-run after changing input values to experiment.");
    }
}
