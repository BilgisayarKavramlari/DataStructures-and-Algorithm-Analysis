import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListExamples {
    public static void main(String[] args) {
        // List is an interface; ArrayList and LinkedList are two implementations.
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        for (int value : new int[] {3, 1, 4}) {
            arrayList.add(value);
            linkedList.add(value);
        }

        System.out.println("ArrayList: " + arrayList);
        System.out.println("LinkedList: " + linkedList);
    }
}
