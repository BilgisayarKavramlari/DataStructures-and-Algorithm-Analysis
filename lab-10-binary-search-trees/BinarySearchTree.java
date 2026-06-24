/** Educational integer BST. */
public class BinarySearchTree {
    static class Node { int key; Node left, right; Node(int k){key=k;} }
    Node root;
    public void insert(int key){ root=insert(root,key); }
    private Node insert(Node n,int key){ if(n==null)return new Node(key); if(key<n.key)n.left=insert(n.left,key); else if(key>n.key)n.right=insert(n.right,key); return n; }
    public boolean contains(int key){ Node c=root; while(c!=null){ if(key==c.key)return true; c=key<c.key?c.left:c.right;} return false;}
    public int min(){ Node c=root; while(c.left!=null)c=c.left; return c.key;}
    public int max(){ Node c=root; while(c.right!=null)c=c.right; return c.key;}
    public int height(){ return height(root); } private int height(Node n){ return n==null?-1:1+Math.max(height(n.left),height(n.right));}
    public static void main(String[] args){ BinarySearchTree t=new BinarySearchTree(); for(int x:new int[]{6,3,8,1,4,7,9})t.insert(x); System.out.println("contains 4="+t.contains(4)+", min="+t.min()+", max="+t.max()+", height="+t.height());}
}
