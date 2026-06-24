import java.util.*;
/** B-tree node: keys remain sorted; children count is keys plus one for internal nodes. */
public class BTreeNode { ArrayList<Integer> keys=new ArrayList<Integer>(); ArrayList<BTreeNode> children=new ArrayList<BTreeNode>(); boolean leaf; BTreeNode(boolean leaf){this.leaf=leaf;} public static void main(String[] args){System.out.println("BTreeNode stores multiple sorted keys per block.");}}
