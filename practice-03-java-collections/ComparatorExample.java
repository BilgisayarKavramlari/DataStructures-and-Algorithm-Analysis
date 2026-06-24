import java.util.ArrayList;
import java.util.Comparator;

public class ComparatorExample {
    static class Student {
        String name;
        int score;

        Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String toString() {
            return name + "(" + score + ")";
        }
    }

    public static void main(String[] args) {
        // A Comparator tells Java how to order objects.
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 92));
        students.add(new Student("Bob", 81));
        students.add(new Student("Carol", 88));

        students.sort(Comparator.comparingInt(student -> student.score));
        System.out.println(students);
    }
}
