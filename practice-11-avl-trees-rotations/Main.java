public class Main {
    public static void main(String[] args) {
        System.out.println("CS 3345 Practice 11: AVL Trees and Rotations");
        System.out.println("Theory alignment: Course Module 4, Weiss Chapter 4 AVL trees.\n");
        SingleRotationDemo.run();
        DoubleRotationDemo.run();
        AVLRotationTraceDemo.run();
        AVLInsertionDemo.run();
        AVLDeletionEducationalDemo.run();
        AVLInvariantChecker.run();
        AVLvsBSTExperiment.run();
        System.out.println("End of Practice 11. Change insertion sequences to create different rotations.");
    }
}
