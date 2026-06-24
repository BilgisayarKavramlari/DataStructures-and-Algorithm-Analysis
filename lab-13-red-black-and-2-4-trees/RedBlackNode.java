/** Node with color for a red-black tree. */
public class RedBlackNode { static final boolean RED=true, BLACK=false; int key; boolean color=RED; RedBlackNode left,right,parent; RedBlackNode(int k){key=k;} public static void main(String[] args){System.out.println("Red nodes cannot have red children; every path has equal black height.");}}
