public class Main {
    public static void main(String[] args) {
        System.out.println("CS 3345 Practice 13: Red-Black Trees and 2-4 Trees");
        System.out.println("Theory alignment: Course Module 4, balanced search trees and red-black invariants.\n");
        RedBlackInsertionTraceDemo.run();
        ColorFlipRotationDemo.run();
        RedBlackInvariantChecker.run();
        TwoFourTreeTraceDemo.run();
        TwoFourCorrespondenceDemo.run();
        RedBlackDeletionConceptDemo.run();
        System.out.println("End of Practice 13. Compare the red-black colors with the 2-4 tree grouping idea.");
    }
}
