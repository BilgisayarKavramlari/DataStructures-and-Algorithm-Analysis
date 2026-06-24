import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Builds an expression tree from postfix notation.
 *
 * Invariant during construction: the stack contains roots of complete expression
 * subtrees for the tokens processed so far.
 */
public class PostfixExpressionTreeBuilder {
    public static ExpressionTreeNode build(String[] tokens, boolean trace) {
        Deque<ExpressionTreeNode> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (isOperator(token)) {
                ExpressionTreeNode right = stack.pop();
                ExpressionTreeNode left = stack.pop();
                ExpressionTreeNode combined = new ExpressionTreeNode(token, left, right);
                stack.push(combined);
                if (trace) {
                    System.out.println("operator " + token + ": pop right=" + right.token + ", left=" + left.token + ", push subtree rooted at " + token);
                }
            } else {
                stack.push(new ExpressionTreeNode(token));
                if (trace) System.out.println("operand " + token + ": push leaf");
            }
        }
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid postfix expression: stack size is " + stack.size());
        }
        return stack.pop();
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
}
