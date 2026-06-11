import java.util.ArrayDeque;

public class StackExample {
    public static void main(String[] args) {
        // A stack is last-in, first-out (LIFO): the newest item is removed first.
        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.push("read problem");
        stack.push("write code");
        stack.push("test solution");

        while (!stack.isEmpty()) {
            System.out.println("Next task: " + stack.pop());
        }
    }
}
