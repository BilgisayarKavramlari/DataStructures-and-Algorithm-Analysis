import java.util.TreeSet;

/**
 * OrderingPitfallsDemo
 *
 * Highlights a classic pitfall: a sorted collection decides equality by the
 * comparator or compareTo result, NOT by equals. If the ordering key collides,
 * the collection treats the elements as duplicates and silently drops one.
 *
 * Time complexity: O(n log n) to build the sets shown.
 */
public class OrderingPitfallsDemo {

    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name + "/" + age;
        }
    }

    public void demonstrate() {
        // A comparator that only looks at age loses people who share an age.
        TreeSet<Person> byAgeOnly = new TreeSet<>((a, b) -> Integer.compare(a.age, b.age));
        byAgeOnly.add(new Person("Ada", 30));
        byAgeOnly.add(new Person("Bob", 30));     // same age -> seen as duplicate
        byAgeOnly.add(new Person("Cara", 25));

        System.out.println("Comparator keyed only on age: " + byAgeOnly);
        System.out.println("Size is " + byAgeOnly.size()
                + ": Bob was dropped because age 30 already existed.");
        System.out.println();

        // Adding the name as a tie-breaker fixes the loss.
        TreeSet<Person> byAgeThenName = new TreeSet<>(
                (a, b) -> {
                    int byAge = Integer.compare(a.age, b.age);
                    return byAge != 0 ? byAge : a.name.compareTo(b.name);
                });
        byAgeThenName.add(new Person("Ada", 30));
        byAgeThenName.add(new Person("Bob", 30));
        byAgeThenName.add(new Person("Cara", 25));
        System.out.println("Comparator keyed on age then name: " + byAgeThenName);
        System.out.println("Size is " + byAgeThenName.size() + ": no one is lost now.");
        System.out.println("In sorted collections, 'equal order' means 'duplicate', so keys must be total.");
    }
}
