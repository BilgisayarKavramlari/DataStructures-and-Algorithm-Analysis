/**
 * HeapArrayIndexDemo
 *
 * Explains the array layout of a complete binary tree. Using 1-based indexing,
 * the parent of node i is at i/2, the left child at 2i and the right child at
 * 2i+1. No pointers are stored; the tree shape lives entirely in arithmetic.
 *
 * Time complexity: O(n) to print the relationships for n nodes.
 */
public class HeapArrayIndexDemo {

    public void demonstrate() {
        int[] values = {0, 5, 9, 11, 14, 18, 19, 21};   // index 0 unused
        System.out.println("Array (1-based, index 0 ignored):");
        for (int i = 1; i < values.length; i++) {
            System.out.println("  index " + i + " = " + values[i]);
        }
        System.out.println();
        System.out.println("Parent/child relationships by arithmetic:");
        for (int i = 1; i < values.length; i++) {
            int left = 2 * i;
            int right = 2 * i + 1;
            StringBuilder sb = new StringBuilder("  node " + i + " (" + values[i] + "): ");
            sb.append("parent=").append(i == 1 ? "none" : String.valueOf(i / 2));
            sb.append(", left=").append(left < values.length ? String.valueOf(left) : "none");
            sb.append(", right=").append(right < values.length ? String.valueOf(right) : "none");
            System.out.println(sb);
        }
        System.out.println();
        System.out.println("Because the tree is complete, indices encode the structure with no links.");
    }
}
