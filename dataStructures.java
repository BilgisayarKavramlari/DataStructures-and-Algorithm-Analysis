import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;
import java.util.HashMap;



// data unit
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
    
    public String toString(){
        return " Value : " +data;
    }
}



public class dataStructures{


    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }


    public static void main(String[] args) {
        int[] a = {12, 7, 25, 9, 18};
        System.out.println(linearSearch(a, 25)); // O(n)
        System.out.println(findMax(a));
        //a[10] = 33;

        ArrayList<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Carol");

        System.out.println(names.get(0));
        System.out.println(names.size());

        names.add("Sarah");

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(12);
        numbers.add(7);
        numbers.add(25);
        numbers.add(9);
        numbers.add(18);

        System.out.println(numbers.get(3));
        System.out.println(numbers.size());

        numbers.add(33);

        ArrayList<human> humans = new ArrayList<>();
        humans.add(new human("John"));
        humans.add(new human("Joshua"));
        humans.add(new human("Alice"));

        humans.get(0).setWeight(100);
        System.out.println(humans.get(0));


        Node first = new Node(10);
        first.next = new Node(20);
        first.next.next = new Node(30);
        System.out.println(" first element " + first);
        System.out.println(" Last element " + first.next.next);


        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        HashSet<String> names2 = new HashSet<>();
        names2.add("Alice");
        names2.add("Bob");
        names2.add("Alice");

        System.out.println(names2);
        System.out.println(names2.contains("Bob"));
        System.out.println(names2.size());


        HashMap <String, Integer> scores = new HashMap<>();

        // < key , value > : JSON , NoSQL , Big Data
        // O(1)

        scores.put("Alice", 92);
        scores.put("Bob", 81);
        scores.put("Carol", 88);

        System.out.println(scores.get("Alice"));
        System.out.println(scores.containsKey("Bob"));
        System.out.println(scores.containsKey("Sarah"));

        int[] values = {2, 3, 2, 5, 3, 2};
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int v : values) {
            freq.put(v, freq.getOrDefault(v, 0) + 1);
        }
        System.out.println(freq);



    }

}