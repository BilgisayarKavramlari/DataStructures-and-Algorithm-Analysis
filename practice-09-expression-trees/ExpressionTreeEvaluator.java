import java.util.Map;

/** Evaluates an expression tree using a variable/value map. */
public class ExpressionTreeEvaluator {
    public static int evaluate(ExpressionTreeNode node, Map<String, Integer> values) {
        if (!node.isOperator()) {
            if (values.containsKey(node.token)) return values.get(node.token);
            return Integer.parseInt(node.token);
        }
        int left = evaluate(node.left, values);
        int right = evaluate(node.right, values);
        return switch (node.token) {
            case "+" -> left + right;
            case "-" -> left - right;
            case "*" -> left * right;
            case "/" -> left / right;
            default -> throw new IllegalStateException("Unknown operator " + node.token);
        };
    }
}
