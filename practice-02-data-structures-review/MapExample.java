import java.util.HashMap;

public class MapExample {
    public static void main(String[] args) {
        // A map stores key-value pairs, such as a name mapped to a score.
        HashMap<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 92);
        scores.put("Bob", 81);
        scores.put("Carol", 88);

        System.out.println("Alice score: " + scores.get("Alice"));
        System.out.println("Has Bob: " + scores.containsKey("Bob"));
    }
}
