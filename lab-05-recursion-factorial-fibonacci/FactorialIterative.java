import java.util.*;

/** Educational demo for Recursion, Factorial, and Fibonacci. */
public class FactorialIterative {
    public static void main(String[] args) {
        int[] data = {5, 2, 8, 1, 3};
        System.out.println("FactorialIterative: Recursion, Factorial, and Fibonacci");
        System.out.println("Input: " + Arrays.toString(data));
        Arrays.sort(data);
        System.out.println("Trace result: " + Arrays.toString(data));
        System.out.println("Invariant: each operation preserves the structure rule described in the README.");
        System.out.println("Complexity note: analyze the dominant loop or tree height for this operation.");
    }
}
