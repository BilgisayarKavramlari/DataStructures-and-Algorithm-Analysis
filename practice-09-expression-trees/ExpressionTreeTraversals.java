/** Converts an expression tree into prefix, infix, and postfix forms. */
public class ExpressionTreeTraversals {
    public static String prefix(ExpressionTreeNode node) {
        if (node == null) return "";
        if (!node.isOperator()) return node.token;
        return node.token + " " + prefix(node.left) + " " + prefix(node.right);
    }

    public static String infix(ExpressionTreeNode node) {
        if (node == null) return "";
        if (!node.isOperator()) return node.token;
        return "(" + infix(node.left) + " " + node.token + " " + infix(node.right) + ")";
    }

    public static String postfix(ExpressionTreeNode node) {
        if (node == null) return "";
        if (!node.isOperator()) return node.token;
        return postfix(node.left) + " " + postfix(node.right) + " " + node.token;
    }
}
