public class SingleRotationDemo {
    public static void run() {
        System.out.println("--- AVL single rotations ---");
        AVLTree ll = new AVLTree(true);
        System.out.println("LL sequence: 30, 20, 10");
        for (int x : new int[]{30, 20, 10}) ll.insert(x);
        ll.printTree();

        AVLTree rr = new AVLTree(true);
        System.out.println("RR sequence: 10, 20, 30");
        for (int x : new int[]{10, 20, 30}) rr.insert(x);
        rr.printTree();
        System.out.println();
    }
}
