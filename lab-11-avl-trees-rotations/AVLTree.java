/** Educational AVL insertion tree with rotations. */
public class AVLTree {
    AVLNode root; int h(AVLNode n){return n==null?-1:n.height;} int bal(AVLNode n){return n==null?0:h(n.left)-h(n.right);}
    AVLNode rotR(AVLNode y){ AVLNode x=y.left; y.left=x.right; x.right=y; y.height=1+Math.max(h(y.left),h(y.right)); x.height=1+Math.max(h(x.left),h(x.right)); return x;}
    AVLNode rotL(AVLNode x){ AVLNode y=x.right; x.right=y.left; y.left=x; x.height=1+Math.max(h(x.left),h(x.right)); y.height=1+Math.max(h(y.left),h(y.right)); return y;}
    public void insert(int k){root=ins(root,k);}
    AVLNode ins(AVLNode n,int k){ if(n==null)return new AVLNode(k); if(k<n.key)n.left=ins(n.left,k); else if(k>n.key)n.right=ins(n.right,k); n.height=1+Math.max(h(n.left),h(n.right)); int b=bal(n); if(b>1&&k<n.left.key)return rotR(n); if(b<-1&&k>n.right.key)return rotL(n); if(b>1){n.left=rotL(n.left);return rotR(n);} if(b<-1){n.right=rotR(n.right);return rotL(n);} return n;}
    void inorder(AVLNode n){ if(n!=null){inorder(n.left);System.out.print(n.key+" ");inorder(n.right);}}
    public static void main(String[] a){AVLTree t=new AVLTree(); for(int x:new int[]{30,20,10,25,40,50})t.insert(x); t.inorder(t.root); System.out.println();}
}
