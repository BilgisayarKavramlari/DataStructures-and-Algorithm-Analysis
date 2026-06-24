import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Runnable trace of how a 2-4 tree node can overflow and split. */
public class TwoFourTreeTraceDemo {
    static class Node24 {
        List<Integer> keys = new ArrayList<>();
        void addKey(int key) { keys.add(key); Collections.sort(keys); }
        boolean overflows() { return keys.size() == 4; }
    }

    public static void run() {
        System.out.println("--- 2-4 tree split trace ---");
        Node24 node = new Node24();
        for (int key : new int[]{10, 20, 30, 40}) {
            node.addKey(key);
            System.out.println("after inserting " + key + " into one node: " + node.keys);
        }
        if (node.overflows()) {
            int promoted = node.keys.get(2);
            List<Integer> left = node.keys.subList(0, 2);
            List<Integer> right = node.keys.subList(3, 4);
            System.out.println("overflow: promote " + promoted + ", left child keys=" + left + ", right child keys=" + right);
        }
        System.out.println("A red-black color flip corresponds to splitting a temporary 4-node.\n");
    }
}
