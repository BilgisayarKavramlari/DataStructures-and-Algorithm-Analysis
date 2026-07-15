import java.util.HashSet;

public class SetExample {
    public static void main(String[] args) {
        // A set stores unique values and ignores duplicates.
        HashSet<String> courses = new HashSet<>();
        courses.add("CS 3345");
        courses.add("CS 3345");
        courses.add("MATH 2418");

        System.out.println("Courses: " + courses);
        System.out.println("Contains CS 3345: " + courses.contains("CS 3345"));
    }
}
