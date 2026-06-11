import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        // ArrayList is a resizable array from the Java standard library.
        ArrayList<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Carol");

        System.out.println("Name at index 1: " + names.get(1));
        names.remove("Bob");
        System.out.println("After removal: " + names);
    }
}
