/** A node in an arithmetic expression tree. */
public class ExpressionTreeNode {
    final String token;
    ExpressionTreeNode left;
    ExpressionTreeNode right;

    public ExpressionTreeNode(String token) {
        this.token = token;
    }

    public ExpressionTreeNode(String token, ExpressionTreeNode left, ExpressionTreeNode right) {
        this.token = token;
        this.left = left;
        this.right = right;
    }

    public boolean isOperator() {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
}
