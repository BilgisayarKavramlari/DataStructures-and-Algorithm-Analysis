public class DoubleRotationDemo {
    public static void run() {
        System.out.println("--- AVL double rotations ---");
        AVLTree lr = new AVLTree(true);
        System.out.println("LR sequence: 30, 10, 20");
        for (int x : new int[]{30, 10, 20}) lr.insert(x);
        lr.printTree();

        AVLTree rl = new AVLTree(true);
        System.out.println("RL sequence: 10, 30, 20");
        for (int x : new int[]{10, 30, 20}) rl.insert(x);
        rl.printTree();
        System.out.println();
    }
}
