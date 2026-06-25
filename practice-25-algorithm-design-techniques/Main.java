/**
 * Main - Practice 25: Algorithm Design Techniques
 *
 * Surveys the major algorithm-design paradigms: greedy (activity selection,
 * Huffman coding, bin-packing approximation), divide and conquer, the selection
 * problem via quickselect, dynamic programming (Fibonacci, matrix-chain
 * multiplication, optimal BST), randomization (randomized quicksort, skip lists,
 * randomized primality testing), and backtracking (subsets and permutations).
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("==== Practice 25: Algorithm Design Techniques ====");
        run("Greedy scheduling", new GreedySchedulingDemo()::demonstrate);
        run("Huffman coding", new HuffmanCodingDemo()::demonstrate);
        run("Approximate bin packing", new ApproximateBinPackingDemo()::demonstrate);
        run("Divide and conquer", new DivideAndConquerDemo()::demonstrate);
        run("Selection problem", new SelectionProblemDemo()::demonstrate);
        run("Dynamic programming (Fibonacci)", new DynamicProgrammingFibonacciDemo()::demonstrate);
        run("Matrix chain multiplication", new MatrixChainMultiplicationDemo()::demonstrate);
        run("Optimal BST", new OptimalBSTEducationalDemo()::demonstrate);
        run("Randomized quicksort", new RandomizedQuickSortDemo()::demonstrate);
        run("Skip list", new SkipListEducationalDemo()::demonstrate);
        run("Primality testing", new PrimalityTestingConceptDemo()::demonstrate);
        run("Backtracking subsets", new BacktrackingSubsetsDemo()::demonstrate);
        run("Backtracking permutations", new BacktrackingPermutationsDemo()::demonstrate);
        System.out.println();
        System.out.println("Algorithm design techniques study complete.");
    }

    private static void run(String title, Runnable demo) {
        System.out.println();
        System.out.println("--- " + title + " ---");
        demo.run();
    }
}
