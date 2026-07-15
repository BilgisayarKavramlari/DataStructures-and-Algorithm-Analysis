import java.util.TreeMap;

/**
 * NavigableMapDemo
 *
 * Demonstrates NavigableMap navigation on a TreeMap: floorEntry, ceilingEntry,
 * and range views over keys. A common use is mapping a numeric threshold to a
 * category, such as turning a score into a letter grade.
 *
 * Time complexity: O(log n) per navigation query.
 */
public class NavigableMapDemo {

    public void demonstrate() {
        TreeMap<Integer, String> grades = new TreeMap<>();
        grades.put(90, "A");
        grades.put(80, "B");
        grades.put(70, "C");
        grades.put(60, "D");
        grades.put(0, "F");

        int[] scores = {95, 83, 72, 65, 40};
        for (int s : scores) {
            // floorEntry finds the highest threshold not exceeding the score.
            var entry = grades.floorEntry(s);
            System.out.println("score " + s + " -> grade " + entry.getValue()
                    + " (threshold " + entry.getKey() + ")");
        }
        System.out.println("A NavigableMap turns a continuous score into a banded category cleanly.");
    }
}
