public class Main {
    public static void main(String[] args) {
        System.out.println("CS 3345 Practice 12: Splay Trees");
        System.out.println("Theory alignment: Course Module 4, Weiss Chapter 4 and amortized-search idea.\n");
        ZigDemo.run();
        ZigZigDemo.run();
        ZigZagDemo.run();
        SplayAccessTraceDemo.run();
        SplayLocalityExperiment.run();
        SplayAmortizedIntuitionDemo.run();
        System.out.println("End of Practice 12. Try repeated access patterns and observe root movement.");
    }
}
