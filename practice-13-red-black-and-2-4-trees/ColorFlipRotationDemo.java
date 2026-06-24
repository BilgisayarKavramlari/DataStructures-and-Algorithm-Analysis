public class ColorFlipRotationDemo {
    public static void run() {
        System.out.println("--- Color flip and rotation demo ---");
        RedBlackTreeEducational tree = new RedBlackTreeEducational(true);
        int[] keys = {3, 1, 2, 5, 4};
        for (int key : keys) {
            System.out.println("insert " + key);
            tree.insert(key);
        }
        tree.printTree();
        System.out.println("Rotations repair leaning/stacked red links; color flips split temporary 4-nodes.\n");
    }
}
