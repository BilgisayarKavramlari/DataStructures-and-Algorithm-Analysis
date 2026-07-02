/**
 * This is an executable concept trace for red-black deletion.
 * Full deletion is longer than insertion, so this demo focuses on the cases
 * students must recognize: double-black, red sibling, black sibling with black
 * children, and restructuring when a sibling has a red child.
 */
public class RedBlackDeletionConceptDemo {
    public static void run() {
        System.out.println("--- Red-black Delete Checker ---");

        RedBlackTreeEducational tree = new RedBlackTreeEducational(false);
        // Test what happens if no items in the tree (tree is empty)
        tree.delete(1); // delete from an empty tree
        tree.printTree();
        tree.insert(50); 
        tree.printTree();
        tree.delete(2); // delete something not on the tree
        tree.printTree();
        tree.delete(50);
        tree.printTree();


        for (int key : new int[]{50, 25, 75, 10, 30, 60, 80, 5, 15}) tree.insert(key);
        tree.printTree();
        System.out.println("valid red-black tree? " + tree.isValidRedBlackTree());
        System.out.println("The checker verifies root black, no red-red parent/child, BST order, and equal black height.\n");


        System.out.println ( " ---- Some more tests --- ");
        tree.delete(80);
        tree.delete(5);
        tree.printTree();

        tree.delete(50);
        tree.printTree();
    }



}
