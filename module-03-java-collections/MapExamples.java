import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapExamples {
    public static void main(String[] args) {
        // Maps connect keys to values. The key is used for lookup.
        Map<String, Integer> hashMap = new HashMap<>();
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        Map<String, Integer> treeMap = new TreeMap<>();

        for (String name : new String[] {"Carol", "Alice", "Bob"}) {
            int length = name.length();
            hashMap.put(name, length);
            linkedHashMap.put(name, length);
            treeMap.put(name, length);
        }

        System.out.println("HashMap: " + hashMap);
        System.out.println("LinkedHashMap: " + linkedHashMap);
        System.out.println("TreeMap: " + treeMap);
    }
}
