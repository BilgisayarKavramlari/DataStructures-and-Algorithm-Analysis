import java.util.LinkedHashMap;
import java.util.Map;

/** Demonstrates expression tree construction, traversal, and evaluation. */
public class ExpressionTreeTraceDemo {
    public static void run() {
        System.out.println("--- Expression tree from postfix notation ---");
        String[] postfix = {"a", "b", "+", "c", "d", "-", "*"};
        System.out.println("Postfix input: a b + c d - *");
        ExpressionTreeNode root = PostfixExpressionTreeBuilder.build(postfix, true);

        System.out.println("\nTraversals produced from the tree:");
        System.out.println("Prefix : " + ExpressionTreeTraversals.prefix(root));
        System.out.println("Infix  : " + ExpressionTreeTraversals.infix(root));
        System.out.println("Postfix: " + ExpressionTreeTraversals.postfix(root));

        Map<String, Integer> values = new LinkedHashMap<>();
        values.put("a", 2);
        values.put("b", 3);
        values.put("c", 10);
        values.put("d", 4);
        System.out.println("Values : " + values);
        System.out.println("Result : " + ExpressionTreeEvaluator.evaluate(root, values));
        System.out.println("Complexity: construction and each traversal visit every token once, so time O(n).\n");
    }
}
