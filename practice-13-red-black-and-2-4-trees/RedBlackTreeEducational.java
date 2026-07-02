import java.util.ArrayList;
import java.util.List;

/**
 * Educational left-leaning red-black tree insertion.
 *
 * Red-black invariants shown here:
 * 1. The root is black.
 * 2. No red node has a red child.
 * 3. Every root-to-null path has the same number of black nodes.
 * 4. This left-leaning variant also avoids red right links after rebalancing.
 */
public class RedBlackTreeEducational {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    static class Node {
        int key;
        boolean color = RED;
        Node left, right;
        Node(int key) { this.key = key; }
    }

    private Node root;
    private boolean trace;

    public RedBlackTreeEducational(boolean trace) { this.trace = trace; }
    public RedBlackTreeEducational() { this(false); }

    public Node findMin(){
        return findMin(root);
    }

    public Node findMin(Node node){
        if(node == null){
            return null;
        }
        while (node.left != null) node = node.left;
        return node;
    }
    public Node parent_findMin(Node node){
        if(node == null){
            return null;
        }
        while (node.left.left != null) node = node.left;
        return node;
    }

    public void delete(int key) {
        if(!contains(key)){
            System.out.println("Key not exists in the tree");
            return;
        }
        if( !isRed(root.left) && !isRed(root.right) ){
            root.color = RED; // root to be deleted
        }
        root = delete(root, key);
        if(root!=null)
            root.color = BLACK;
    }

    public Node delete (Node h, int key){
        if (h == null) {
            return null;
        }
        if (key < h.key){
            if( !isRed(h.left) &&  !isRed(h.left.left) ){
                h = moveRedLeft(h);
            }
            h.left = delete(h.left, key);
        } 
        else { // Left lean RB
            if(isRed(h.left)){
                h = rotateLeft(h);
            }
            if( key == h.key && h.right==null){
                return null;
            }
            if(!isRed(h.right)&& !isRed(h.right.left)){
                h = moveRedRight(h);
            }
            if(key == h.key){
                Node successor = findMin(h.right);
                h.key=successor.key;
                h.right=deleteMin(h.right);
            } else{
                h.right = delete(h.right,key);
            }
        }
        return balance(h);
    }

    private Node balance(Node h){
        if(isRed(h.right)&& !isRed(h.left))
            h = rotateLeft(h);
        if(isRed(h.left)&& isRed(h.left.left))
            h = rotateRight(h);
        if(isRed(h.left)&&isRed(h.right))
            flipColors(h);
        return h;
    }

    private Node deleteMin(Node h){
        if(h.left == null){
            return null;
        }
        if(!isRed(h.left) && !isRed(h.left.left)){
            h = moveRedLeft(h);
        }
        h.left = deleteMin(h.left);
        return balance(h);
    }

    private Node moveRedLeft(Node h){
        flipColors(h);
        if(isRed(h.right.left)){
            h.right= rotateRight(h.right);
            h = rotateLeft(h);
            flipColors(h);
        }
        return h;
    }

    private Node moveRedRight(Node h){
        flipColors(h);
        if(isRed(h.left.left)){
            h = rotateRight(h);
            flipColors(h);
        }
        return h;

    }


    public void insert(int key) {
        root = insert(root, key);
        root.color = BLACK;
    }

    private Node insert(Node h, int key) {
        if (h == null) {
            if (trace) System.out.println("insert red leaf " + key);
            return new Node(key);
        }
        if (key < h.key) h.left = insert(h.left, key);
        else if (key > h.key) h.right = insert(h.right, key);

        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);
        return h;
    }

    private boolean isRed(Node node) { return node != null && node.color == RED; }

    private Node rotateLeft(Node h) {
        if (trace) System.out.println("rotateLeft at " + h.key + " to fix right-leaning red link");
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Node rotateRight(Node h) {
        if (trace) System.out.println("rotateRight at " + h.key + " to split two consecutive left red links");
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private void flipColors(Node h) {
        if (trace) System.out.println("flipColors at " + h.key + " to split temporary 4-node");
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }

    public boolean contains(int key) {
        Node current = root;
        while (current != null) {
            if (key == current.key) return true;
            current = key < current.key ? current.left : current.right;
        }
        return false;
    }

    public List<Integer> inorder() {
        List<Integer> out = new ArrayList<>();
        inorder(root, out);
        return out;
    }

    private void inorder(Node n, List<Integer> out) {
        if (n == null) return;
        inorder(n.left, out);
        out.add(n.key);
        inorder(n.right, out);
    }

    public boolean isValidRedBlackTree() {
        if (root == null) return true;
        if (isRed(root)) return false;
        try { check(root, null, null); return true; }
        catch (IllegalStateException ex) { return false; }
    }

    private int check(Node node, Integer low, Integer high) {
        if (node == null) return 1; // null links count as black sentinels in this check
        if (low != null && node.key <= low) throw new IllegalStateException("BST lower bound violation");
        if (high != null && node.key >= high) throw new IllegalStateException("BST upper bound violation");
        if (isRed(node) && (isRed(node.left) || isRed(node.right))) throw new IllegalStateException("red-red violation");
        int leftBlackHeight = check(node.left, low, node.key);
        int rightBlackHeight = check(node.right, node.key, high);
        if (leftBlackHeight != rightBlackHeight) throw new IllegalStateException("black-height mismatch at " + node.key);
        return leftBlackHeight + (isRed(node) ? 0 : 1);
    }

    public void printTree() { printTree(root, "", "root"); }

    private void printTree(Node n, String indent, String label) {
        if (n == null) {
            System.out.println(indent + label + ": null");
            return;
        }
        System.out.println(indent + label + ": " + n.key + (isRed(n) ? " RED" : " BLACK"));
        printTree(n.left, indent + "  ", "L");
        printTree(n.right, indent + "  ", "R");
    }
}
